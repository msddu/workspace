package com.kh.test.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.test.board.model.dto.Board;
import com.kh.test.board.model.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardController {

	@Autowired
	private BoardService service;


	//게시글 조회
	@GetMapping("selectOne")
	public String selectOne(int no, Model model, RedirectAttributes ra) {
		
		//서비스 호출
		Board board = service.selectOne(no);
		
		//게시글이 null값이 아니면
		if(board != null) {
			
			model.addAttribute("board", board);
			return "board/selectOne";
		}
		//게시글이 null값이면 메시지 전달
		ra.addFlashAttribute("message", "게시글이 존재하지 않습니다.");
		return "redirect:/";
	}

	
	@GetMapping("insert")
	public String insert() {
		return "board/insert";
	}


	//게시글 작성
	@PostMapping("insert")
	public String insert(Board board, RedirectAttributes ra) {
		
		//insert 성공 or 실패  result에 저장
		int result = service.insert(board);
		
		//성공 시 메시지 전달
		ra.addFlashAttribute("message", "글쓰기 성공");
		
		//메인 화면으로...
		return "redirect:/";
	}


	//비밀번호 일치하면 게시글삭제
	@PostMapping("deleteBoard")
	public String deleteBoard(String boardPw, int boardNo, RedirectAttributes ra) {

		
		int result = service.deleteBoard(boardPw, boardNo);

		if(result > 0) {
			ra.addFlashAttribute("message", "글이 삭제되었습니다.");
			return "redirect:/";
		}

		ra.addFlashAttribute("message", "비밀번호가 일치하지 않습니다");
		return "redirect:selectOne?no=" + boardNo;
	}


	
}

