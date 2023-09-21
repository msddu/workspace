//focus 이벤트
const focusTest = document.getElementById("focus-test");

//포커스가 맞춰졌을 때
focusTest.addEventListener("focus", ()=>{
  focusTest.classList.add("focus");
});

//포커스를 잃었을 때
focusTest.addEventListener("blur", ()=>{
  focusTest.classList.remove("focus");
});


/* checjk-box change이벤트 */
const checkTest = document.getElementById("check-test");
checkTest.addEventListener("change", e=>{
  console.log(e.target.checked);
});


/* text change이벤트 */
const inputChange = document.getElementById("input-change");
inputChange.addEventListener("change", e=>{
  alert("change이벤트 발생!")
});


/* input 이벤트 */
const Test = document.getElementById("test");
Test.addEventListener("input", e=>{
  console.log(e);
  console.log(e.target.value);
});