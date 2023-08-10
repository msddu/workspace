package edu.kh.collection.map.ex;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import edu.kh.collection.list.model.dto.Student;

public class MapEx {
	
	/*Map : 특정 키워드(key)를 입력하면 
	 *   	해당되는 상세한 값(value)를 얻을 수 있는 컬렉션 객체
	 *   
	 *   -K:V 한쌍으로 데이터를 저장하고 (K:V 한쌍을 묶어서 Entry라 부름)
	 *   
	 *   -Key : 키워드 역할
	 *   1) 중복 X(Key중복 시 Value를 새로운 내용으로 덮어씌움)
	 *   	*Key역할을 하는 객체에는
	 *   	 equals(), hashCode()가 오버라이딩 되어있어야 한다.
	 *   
	 *   2) 순서 유지 X
	 *   
	 *   -->Map에서 Key만 묶어놓으면 set과 같은 특징을 지님
	 *   
	 *   -Value : 키워드에 대응되는 값의 역할
	 *   1) Key로 인해서 구분됨 -> 중복 허용
	 *   -->Value만 묶어놓으면 List와 같은 특징을 지님
	 * */
	
	
	
	public void ex1() {
		
		// Key제한 , Value 제한
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		//1. V map.put(K k, V v) : map에 추가
		//  map에 추가시 key가 중복되면 새로운 value로 덮어 씌우고
		//	이전 value가 반환된다.
		//  중복 아니면 null 반환
		System.out.println(map.put(1, "에그마요"));
		System.out.println(map.put(2, "로스트치킨"));
		System.out.println(map.put(3, "바베큐"));
		
		System.out.println(map.put(3, "서브웨이"));
		
		System.out.println(map);
		
		//2. V map.get(K k) :
		//   map에서 key에 해당하는 value를 반환한다.
		//	 일치하는 key가 없으면 null을 반환
		
		System.out.println(map.get(1));
		System.out.println(map.get(2));
		System.out.println(map.get(3));
		
		String s = map.get(1);  //Value가 String이니까 String 변수에 저장
		
		//3. int map.size() : 저장된 k:v 쌍의 수를 반환
		System.out.println("k:V몇쌍?" + map.size() + "쌍");
		
		//4. V map.remove(K K)
		//   map에서 key가 일치하는 요소(k:v쌍) 을 제거
		//   제거되는 v반환, 없으면 null반환
		System.out.println(map.remove(1) + "제거");
		System.out.println(map.remove(2) + "제거");
		
		//5. void map.clear() : map다 지움
		
		map.clear();
		
		//6. boolean map.isEmpty()
		System.out.println("비었음?" + map.isEmpty());
		
	}
	
	
	public void ex2() {
		
		//map에 저장된 값 순차접근(반복해서 순서대로 하나씩 꺼내기)
		
		// 1. map.keySet()
		//    Key만을 모아놓은 집합(set)을 반환
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("집", "경기도 의정부시");
		map.put("학원", "서울시 중구");
		map.put("스타필드", "경기도 하남");
		map.put("롯데타워", "서울시 송파구");
		
		Set<String> set = map.keySet();
		
		System.out.println(set);
		
		//2. keyset을 이용해서 map에 있는 모든 요소 순차접근 하기
		
		for(String key : set) {
			
			System.out.printf("[%S] %s \n" , key, map.get(key));
		}
		
		
	}
	
	
	public void ex3() {
		
		//Map은 언제 사용하면 좋을까??
		
		//1) 한 번에 많은 양의 데이터를
		//	 명확하게 구분할 수 있는 형태로
		//   전달해야하는 경우
		
		
		//2) DTO(Date Transfer Object) : 값 전달용 객체
		//	 DTO가 없거나, 있어도 사용 빈도가 낮을경우
		//	 Map으로 대체해서 사용
		
		
		
		Map<String, Object> s1 = new HashMap<String, Object>();
		
		//Value의 타입이 object로 제한되어 있다.
		//==어떤 객체든 value에 들어올수 있다.
		
		s1.put("grade", 3);    //3(int) -> Integer로 Auto Boxing
		s1.put("ban", 5);
		s1.put("number", 17);
		s1.put("name", "홍길동");
		s1.put("gender", 'M');
		s1.put("Score", 75);
		
		Set<String> set = s1.keySet();  //key들의 집합
		
		for(String key : set) {
			System.out.printf("%s : %s\n" , key, s1.get(key));
		}
		
		System.out.println("-------------------------------------");
		
		
		//Map과 DTO비교
		Student s2 = new Student();
		s2.setGrade(2);
		s2.setBan(3);;
		s2.setGender('F');
		s2.setName("김미영");
		s2.setScore(39);
		s2.setNumber(15);
		
		System.out.printf("s1 : %d학년 %d반 %d번 %s\n" ,
				                s1.get("grade"), s1.get("ban"), s1.get("number"), s1.get("name"));
		
		System.out.printf("s2 : %d학년 %d반 %d번 %s\n",
								s2.getGrade(), s2.getBan(), s2.getNumber(), s2.getName());
		
		
	}
	
	

}
