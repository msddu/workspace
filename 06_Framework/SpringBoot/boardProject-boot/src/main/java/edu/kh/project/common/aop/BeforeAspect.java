package edu.kh.project.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import edu.kh.project.member.model.dto.Member;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component //bean으로 등록 ==> Spring이 알아서 다룰 수 있음
@Aspect    //공통 관심사가 작성된 클래스임을 명시
		   //공통 관심사 : 특정 지점에서 동작하는 코드
public class BeforeAspect {

	//@Before(포인트컷) : 포인트컷 지점 코드 수행 전에 수행
	
	//execution( [접근제한자(생략가능)] 리턴타입  클래스명   메소드명 ([파라미터]) )
	//excution(* edu.kh.project..*Controller*.*(..)) 
	//-> edu.kh.project 패키지 내부에 Controller 라고 하는 이름이 포함된 클래스의 모든 메서드(반환형, 매개변수 상관x)를 지정
	
	@Before("execution(* edu.kh.project..*Controller*.*(..)) ")
	public void boforeLog(JoinPoint jp) {
	//public void boforeLog(JoinPoint jp) == 메서드 시그니처
		
		
		//JoinPoint : AOP가 적용된 대상의 각종 정보를 담고있는 객체
		
		log.debug("-----------------------------------------------------------");
		
		//클래스명 얻어오기
		String className = jp.getTarget().getClass().getSimpleName();
		
		//메서드명 얻어오기
		String methodName = jp.getSignature().getName();
		
		log.debug(className + "." + methodName + "() 요청됨");
		
		
		try { // 클라이언트가 아닌 스프링(스케줄러, 다른 클래스)요청 시 오류 발생
			
			//요청자 ip 얻어오기
			HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
			log.debug("Client IP : " + getRemoteAddr(req));
			
			if(req.getSession().getAttribute("loginMember")!= null) {
				Member loginMember = (Member)req.getSession().getAttribute("loginMember");
												//object타입으로 반환되기 때문에 다운캐스팅
				
				log.debug("email : " + loginMember.getMemberEmail());
			}
			
		}catch(Exception e) {
			log.debug("스프링 요청");
		}
		
		
	}
	
	   //요청온 ip를 가로채는 메서드
	   public static String getRemoteAddr(HttpServletRequest request) {

	        String ip = null;

	        ip = request.getHeader("X-Forwarded-For");

	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	            ip = request.getHeader("Proxy-Client-IP"); 
	        } 

	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	            ip = request.getHeader("WL-Proxy-Client-IP"); 
	        } 

	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	            ip = request.getHeader("HTTP_CLIENT_IP"); 
	        } 

	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	            ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
	        }

	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	            ip = request.getHeader("X-Real-IP"); 
	        }

	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	            ip = request.getHeader("X-RealIP"); 
	        }

	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	            ip = request.getHeader("REMOTE_ADDR");
	        }

	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	            ip = request.getRemoteAddr(); 
	        }

	      return ip;
	   }
	   
}
