/* JS파일을 script 태그 내부라고 생각하면됨 */
function externalFn(){
  alert("외부 파일에 작성된 externalFn()함수 호출됨");
}



// JS맛보기
const body = document.querySelector("body");  /* body 태그 */

/* JS는 기본적으로 카멜 표기법 사용 */
function lightMode(){
  body.style.backgroundColor = "White";
  body.style.Color = "black";
}
function darkMode(){
  body.style.backgroundColor = "black";
  body.style.Color = "white";
}