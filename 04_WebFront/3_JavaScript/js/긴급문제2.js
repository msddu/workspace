//적용하기 버튼 클릭 되었을 때
const applyBtn = document.querySelector("#apply-btn");

applyBtn.addEventListener("click",function(){


  //위에 작성된 input요소들을 모두 얻어오기
  const boxWidth = document.querySelector("#box-width");
  const boxHeight = document.querySelector("#box-Height");
  const fs = document.querySelector("#fs");
  const fw = document.querySelector("[name = 'fw]:checked");
  const fontColor = document.querySelector("#box-font-color");
  const bgColor = document.querySelector("#box-bg-color");
  const row = document.querySelector("[name = 'align-row]:checked");
  const col = document.querySelector("[name = 'align-col]:checked");

  const box = document.querySelector("#box");

  const content = document.querySelector("content");

  //input에 작성된 값에 따라 #box에 JS로 CSS추가하기

  //너비를 입력하는 input에 값이 작성되어 있다면
  if(boxWidth.value.trim().length != 0){
    box.style.width = boxWidth.value + "px";
  }

  //높이를 입력하는 input에 값이 작성되어 있다면
  if(boxHeight.value.trim().length != 0){
    box.style.Height = boxHeight.value + "px";
  }
  //글자 크기를 입력하는 input에 값이 작성되어 있다면
  if(fs.value.trim().length != 0){
    box.style.fontSize = fs.value + "px";
  }


  //fw -> 체크된게 없으면 null반환
  //   -> 체크된게 있으면 null아님
  if(fw != null){ //글자 굵기가 체크 되었을 때
     //글자 굵기 적용
    box.style.fontWeight = fw.value;
  }
  //글자색 입력하는 input에 값이 작성되어 있다면
  if(fontColor.value.trim().length != 0){
    box.style.Color = fontColor.value + "px";
  }

  //배경색 입력하는 input에 값이 작성되어 있다면
  if(bgColor.value.trim().length != 0){
    box.style.backgroundColor = bgColor.value
  }

  if(row != null){ 
    
   box.style.justifyContent = row.value;
 }

 if(col != null){ 
  
 box.style.alignItems = col.value;
 }

if(content.value.trim().length != 0){
  box.innerText = content.value;
 }

  

});
