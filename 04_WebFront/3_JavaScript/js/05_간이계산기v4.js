const input1 = document.getElementById("input1");
const input2 = document.getElementById("input2");

//연산자 버튼 클릭 시 동작
//매개 변수 btn(btn == 클릭된 버튼 자체(this))
function calc(btn){

  //클릭한 버튼에 작성된 연사자를 얻어와 op변수에 저장
  const op = btn.innerText;

  //입력된 값은 number 타입으로 변환하여 저장
  v1 = Number(input1.value); //입력 숫자 1
  v2 = Number(input2.value); //입력 숫자 2

  //1. eval("코드 형식의 문자열")
  //->매개변수의 문자열을 JS코드로 변환해서 해석하는 함수
  //->속도 + 보안 문제로 사용을 지양..(쓰지마)  

 //결과 출력
  //result.innerText = eval(v1 + op + v2);


  //2.new Function("return코드 형식의 문자열")();
  //->새 함수를 만들어서 바로 실행
  //->실행되는 함수의 내용은 첫 번째()에 작성된
  //  코드 형식의 문자열

  result.innerText = new Function("return " + v1 + op + v2)();

}