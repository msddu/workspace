package edu.kh.project.common.interceptor;

import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardNameInterceptor implements HandlerInterceptor{
	
	
		//preHandle(전처리) : Dispatcher Servlet -> Controller 사이 요청을 가로채서 동작(Controller 도착하기 전에 요청을 가로챔)
	
		//postHandle(후처리) :  Controller -> Dispatcher Servlet 사이 응답을 가로 채서 동작
		
		//afterCompletion(뷰 완성 후) : Dispatcher Servlet -> Client 사이
		//					forward 한 뷰(html,jsp) 완성 후 동작
	
	
	//후처리
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	      // application scope 내장 객체 얻어오기
	      ServletContext application = request.getServletContext();
	      
	      List<Map<String, Object>> boardTypeList = (List<Map<String, Object>>)application.getAttribute("boardTypeList");
	      //												다운캐스팅			<-		Object 타입
	      
	      //URL(자원 경로) 	: http:/localhost/board/1
	      //URI(자원 식별자(요청주소) )	: /board/1
	      String uri = request.getRequestURI();
	      
	      // uri.split("/") -> ["", "board", "1"]
	      int boardCode = Integer.parseInt(uri.split("/")[2]);
	      
	      // [{boardCode=1, boardName=공지사항}, {boardCode=2, boardName=자유 게시판}, {boardCode=3, boardName=질문 게시판}]
	      for(Map<String, Object> map : boardTypeList) {
	         int temp =  Integer.parseInt( String.valueOf(map.get("boardCode")) );
	         
	         if(temp == boardCode) {
	            request.setAttribute("boardName",  map.get("boardName"));
	         }
	      }
	      
	      
		
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

}
