package edu.kh.project.myPage.model.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.common.utility.Util;
import edu.kh.project.member.model.dto.Member;
import edu.kh.project.myPage.model.mapper.MyPageMapper;

@Transactional
@Service
@PropertySource("classpath:/config.properties")
public class MyPageServiceImpl implements MyPageService {
	
	@Autowired
	private MyPageMapper mapper;
	
	
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	
	
	@Value("${my.member.webpath}")
	private String webpath;
	
	@Value("${my.member.location}")
	private String folderPath;
	
	
	
	@Override
	public int info(Member updateMember, String[] memberAddress) {
		
		//주소 가공
		//주소가 입력되지 않은경우
				if(updateMember.getMemberAddress().equals(",,")) {
					updateMember.setMemberAddress(null); //null 반환
					
				}else {//주소를 입력한 경우
						//배열 -> 문자열로 합쳐서 inputMember에 추가
					String address = String.join("^^^", memberAddress);
					updateMember.setMemberAddress(address);
				}
		
		//mapper 호출 후 결과 반환
		return mapper.info(updateMember);
	}
	
	@Override
	public int changePw(String currentPw, String newPw, int memberNo) {
				//로그인한 회원의 비밀번호 조회
				String encPw = mapper.selectMemberPw(memberNo);
				
				
				if(!bcrypt.matches(currentPw, encPw)) {
					return 0;
				}
				
				//같으면 새 비밀번호 변경
				Map<String, Object> map = new HashMap<>();
				map.put("newPw", bcrypt.encode(newPw));
				map.put("memberNo", memberNo);
				
				
				return mapper.changePw(map);
			
	}
	
	
	@Override
	public int secession(String memberPw, int memberNo) {
		
		//로그인한 비밀번호 조회
		String encPw = mapper.selectMemberPw(memberNo);
		
		//비밀번호가 다르면
		if(!bcrypt.matches(memberPw,encPw)) {
			return 0;
		}
		//현재 비밀번호와 입력한 비밀번호 일치하면 탈퇴진행
		return mapper.secession(memberNo);
	}
	
	
	
	//프로필 이미지 수정
	@Override
	public int profile(MultipartFile profileImg, Member loginMember) throws IllegalStateException, IOException {
		
		//프로필 이미지 변경 실패 대비(이전 프로필 이미지 경로 저장)
		String backup = loginMember.getProfileImg();
		
		//변경된 파일명을 저장할 변수 선언
		//파일명 변경 이유 : 파일명이 같으면 이전 파일을 덮어씌우기 때문에
		String rename = null;
		
		//(중요!!!)업로드된 이미지가 있을 경우
		
		//문자열 데이터 -> 데이터 != null (null을 이용해서 비교)
		
		//파일 데이터(업로드 안돼도 MultipartFile 객체가 생성!!)
		//-> 업로드된 파일의 크기를 이용해 비교
		//-> 파일.getSize() > 0
		if(profileImg.getSize() > 0) { //업로드된 파일이 있다면
			
			//1) 파일명 변경
			rename = Util.fileRename(profileImg.getOriginalFilename());
			//2) 바뀐 파일명 + 경로를 loginMember 세팅
			loginMember.setProfileImg( webpath + rename );
		}else {//업로드된 파일이 없다면 -> 기본 이미지로 변경
			loginMember.setProfileImg(null);  //이미지 제거
		}
		
		//mapper호출
		int result = mapper.profile(loginMember);
		
		//DB업데이트 성공 시
		//메모리에 임시 저장된 파일을 지정된 경로에 저장
		if(result > 0) {
			if(profileImg.getSize() > 0) { //업로드 파일 있을 때
				//transfer : 옮기다, 갈아타다
				//파일.transfer(파일경로) : 메모리에 저장된 파일을 지정된 경로로 옮김(저장)
				profileImg.transferTo(new File(folderPath + rename));
				
			}
		}else { //DB업데이트 실패
			//loginMember에 backup 해둔 이미지를 세팅
			loginMember.setProfileImg(backup);
			
		}
		
		return result;
	}
	
}
