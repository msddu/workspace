package edu.kh.jdbc.model.dto;


//DTO (Data Transfer Object) : 데이터 전달용 객체
public class Member {
	/*DTO필드는 DB컬럼과 비슷하게 작성되는 경우가 많음*/
	/*->상황에 따라서 필드가 추가 또는 삭제될 수 있음(개발자 재량)*/
	
	private int memberNo;
	private String memberEmail;
	private String memberPw;
	private String memberNPw;
	private String memberNickname;
	
	//java, db의 char구분하기
	private String memberTel;
	
	private String memberAdress;
	
	//Date -> String으로 변환해서 사용할 예정
	private String enrollDate;
	
	private String memberDelFl;
	
	
	//기본 생성자
	public Member() {}
	
	
	//매개변수 생성자
	public Member(String memberEmail, String memberPw, String memberNickname, String memberTel, String memberAdress) {
		super();
		this.memberEmail = memberEmail;
		this.memberPw = memberPw;
		this.memberNickname = memberNickname;
		this.memberTel = memberTel;
		this.memberAdress = memberAdress;
	}
	
	public Member(String memberEmail, String memberPw, String memberNPw) {
		
		this.memberEmail = memberEmail;
		this.memberPw  = memberPw;
		this.memberNPw= memberNPw;
	}
	
	
	public Member(String memberEmail, String memberPw, String memberNickname, String memberTel) {
		
		
		this.memberEmail = memberEmail;
		this.memberPw = memberPw;
		this.memberNickname = memberNickname;
		this.memberTel = memberTel;
		
	}
	
	public Member(String memberPw, int memberNo) {
		this.memberPw = memberPw;
		this.memberNo = memberNo;
		
	}
	
	
	
	
	
	
	
	//getter / setter
	
	public int getMemberNo() {
		return memberNo;
	}
	
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPw() {
		return memberPw;
	}
	
	public String getMemberNPw() {
		return memberNPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberNickname() {
		return memberNickname;
	}

	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}

	public String getMemberTel() {
		return memberTel;
	}

	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
	}

	public String getMemberAdress() {
		return memberAdress;
	}

	public void setMemberAdress(String memberAdress) {
		this.memberAdress = memberAdress;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getMemberDelFl() {
		return memberDelFl;
	}

	public void setMemberDelFl(String memberDelFl) {
		this.memberDelFl = memberDelFl;
	}
	
	//Object.toString() 오버라이딩 
	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberEmail=" + memberEmail + ", memberPw=" + memberPw
				+ ", memberNickname=" + memberNickname + ", memberTel=" + memberTel + ", memberAdress=" + memberAdress
				+ ", enrollDate=" + enrollDate + ", memberDelFl=" + memberDelFl + "]";
	}
	
	
	
	
}
