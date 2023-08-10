package edu.kh.collection.set.ex;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import edu.kh.collection.list.model.dto.Student;

public class SetEx {

	
	//컬렉션 특징 : 크기 제한x, 다양한 기능, 객체만 저장 가능
	//제네릭 <T> : 컬렉션 타입 제한
	
	//Set(집합)
	//-중복 데이터 저장 불가(같은 객체를 덮어 씌움)
	//-순서를 유지하지 않음(index 없음)
	// ->get() 메서드가 없음
	
	//대표적인 자식 클래스 
	//HashSet : hashCode()를 이용해서 중복 비교
	//          hashCode() 오버라이딩 필수
	//			빠른 검색 지원
	
	//LinkedHashSet : 순서가 유지되는 Set
	//				  hashCode() 오버라이딩 필수
	
	//treeSet : 저장되는 값을 자동으로 정렬
	//          Comparable 상속받기 필수
	
	public void ex1() {
		
		//기본적인 Set 사용법
		
		//String, integer 등 Java 제공 객체는
		//기본적으로 hashCode(), equals(), compareTo()등이 
		//오버라이딩 되어있음
		Set<String> set = new HashSet<String>();
		
		
	
		
		// 1. boolean set.add(E e) : 추가
		set.add("네이버");
		set.add("카카오");
		set.add("라인");
		set.add("쿠팡");
		set.add("배달의 민족");
		set.add("당근마켓");
		set.add("토스");
		set.add("직방");
		set.add("야놀자");
		
		System.out.println(set);
		//HashSet은 순서 유지 x

		
		//중복 저장 확인 -> 중복 저장x(제거)
		set.add("야놀자");
		set.add("야놀자");
		set.add("야놀자");
		set.add("야놀자");
		set.add("야놀자");
		
		//set에 null도 저장되나 1개만 저장 가능(중복x)
		set.add(null);
		set.add(null);
		set.add(null);
		//null : 참조하는 객체가 없다(주소 저장x)
		
		System.out.println(set);
		
		// 2. int set.size() : 저장된 객체의 수 반환
		System.out.println("size :" + set.size());
		
		// 3. boolean remove(E e)
		//    e와 똑같은 요소가 set에 있으면 지우고 true 반환
		//    없으면 false 반환
		if( set.remove("직방")) {
			System.out.println("직방이 제거되었습니다.");
			
		}else {
			System.out.println("직방이 없습니다.");
		}
		
		System.out.println(set);
		
		//4.boolean set.contains(E e) 
		//set에 저장된 객체e와 같은 객체가  있으면 true,아니면 false
		System.out.println("네이버 " + (set.contains("네이버")? "있음" : "없음"));
		System.out.println("직방 " + (set.contains("직방")? "있음" : "없음"));
		
		
		
		//5. void set.clear() : set에 저장된 객체를 모두 지움
		set.clear();
		System.out.println("clear 후 size : " + set.size());
		
		
		
		//6. boolean set.isEmpty()
		//   set에 저장된 객체가 없다면(비어있다면) true , 아니면 false
		//   set.size() == 0 과 같은 뜻
		System.out.println("set이 " + (set.isEmpty() ? "비어있음" : "비어있지않음"));
		
	}
	
	
	public void ex2() {
		
		
		//set에 저장된 값 꺼내쓰는 방법
		
		// 1. Iterator (반복자)
		// -컬렉션 객체의 요소를 하나씩 꺼내서 반복 접근 할 수 있는 객체
		//  (순서대로 요소 하나씩 꺼내는 객체)
		
		Set<String> set = new HashSet<String>();
		set.add("포카칩");
		set.add("빅파이");
		set.add("몽쉘");
		set.add("콘칩");
		set.add("하겐다즈");
		set.add("꼬북칩");
		
		//Iterator<String> it = set.iterator();
		//set의 내용을 순차(반복) 접근할 수 있는 형태로 변경해서 반환
		Iterator<String> it = set.iterator();
		
		
		//boolean it.hasNext()
		//다음 꺼낼 요소가 있으면 true , 없으면 false
		while(it.hasNext()) {
			
			//E it.next() : 다음 요소 꺼내서 반환
			String temp = it.next();
			
			System.out.println(temp);
			
		}
		
	
		//---------------------------------------------
	// 2 . 향상된 for문
	System.out.println("--------------------------------");
		
	for(String s : set) {
		System.out.println(s);
	}
}
	
	public void ex3() {
		
		//Set이 중복을 확인하는 방법
		//-> 새로 추가하려는 객체와 
		//   Set에 있는 객체가 
		//   equals() 수행 시 true
		//	 hashCode()비교 시 true이면 중복으로 판단
		//
		
		//결론: Set 이용하려면 equals()와 hashCode 필수로 오버라이딩
		
		Set<Student> set = new HashSet<Student>();
		
		set.add(new Student(3, 4, 1, "이초아", 'F', 100)); 
		set.add(new Student(3, 4, 1, "이초아", 'F', 100));
				
		System.out.println("size : "+ set.size());
		
		for(Student s: set) {
			System.out.println(s);
		}
	}
	
	
	public void createLottoNumber() {
		
	 
		// 로또번호 (1~45의 난수, 6개, 중복X, 오름차순)
		
		Random random = new Random(); //난수 생성 객체
        
		
		//컬렉션은 기본 자료형 저장이 불가
		//->Wrapper 클래스 이용
		
		//Treeset -> 오름차순
		Set<Integer> lotto = new TreeSet<Integer>();
		
		while(lotto.size() < 6) {  //lotto에 저장된 난수가 6개 미만이면 반복
			
			lotto.add(random.nextInt(45) + 1);
			
		}
		
		System.out.println(lotto);
	}
	
	public void LottoVersion2() {
		
		//금액을 입력 받아서(천원 단위)
		//3천원이면 3회, 5천원이면 5회 치
		//로또 번호를 자동으로 생성해서 출력하기
		
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			try{
				System.out.print("금액을 입력하세요(천원 단위): ");
				int input = sc.nextInt();
				
				
				if(input == 0) {
					System.out.println("프로그램이 종료되었습니다.");
					break;
				}
				
				if(input < 1000) {
					System.out.println("1000원 이상만 입력해주세요.");
					//return;
				}
				
				for(int i = 1; i<=input/1000; i++) {
				
					System.out.print(i + "회 : ");
					
					createLottoNumber();
				}	
				
			
		     }catch(InputMismatchException e) {
		    	 System.out.println("숫자만 입력해주세요.");
		    	 sc.nextLine(); //입력버퍼에 남은 문자열 제거
		     }
	
		}
}	
	
}
