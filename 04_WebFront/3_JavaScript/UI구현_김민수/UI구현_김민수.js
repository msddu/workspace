const inputId = document.getElementById("id");
const inputPw = document.getElementById("pw");
const inputPwCheck = document.getElementById("pw_check");
const inputEmail = document.getElementById("email");
const inputAddress = document.getElementById("address");

const resultId = document.querySelector("#result-id");
const resultPw = document.querySelector("#result-pw");
const resultPwCheck = document.querySelector("#result-pw-check");
const resultEmail = document.querySelector("#result-email");
const resultAddress = document.querySelector("#result-address");

/**************************아이디 클릭 시*************************/

inputId.addEventListener("click", ()=>{
  const val = inputId.value.trim();
  inputId.value = val;

  if(val.length === 0){
    resultId.innerText = "*필수 입력 항목 입니다";
    resultId.classList.add("error");
    
    return;
  }

});


/**************************비밀번호 클릭 시*************************/

inputPw.addEventListener("click", ()=>{
  const val = inputPw.value.trim();
  inputPw.value = val;

  if(val.length === 0){
    resultPw.innerText = "*영문자 대/소문자 특수문자, 숫자 포함 8 ~ 32자";

    return;
  }

});

/**************************비밀번호 입력 시*************************/

inputPw.addEventListener("input", ()=>{
  const val = inputPw.value.trim();
  inputPw.value = val;
  
  if(val.length === 0){
    resultId.innerText = "*필수 입력 항목입니다";
    resultId.classList.add("error");
    
    return;
  }

  const regEx = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,32}$/;

  if(regEx.test(val)){  //비밀번호 입력 유효
    resultPw.innerText = "*유효한 비밀번호 입니다";
    resultPw.classList.add("check");
    resultPw.classList.remove("error");
  }else{                //비밀번호 입력 유효x
    resultPw.innerText = "*유효하지 않은 비밀번호 입니다";
    resultPw.classList.add("error");
    resultPw.classList.remove("check");
  }

  
});


/**********************비밀번호 확인*************************/

inputPwCheck.addEventListener("click", ()=>{
  const val = inputPwCheck.value.trim();
  inputPwCheck.value = val;
  
  if(val.length === 0){
    resultId.innerText = "*필수 입력 항목입니다";
    resultPw.innerText = "*필수 입력 항목입니다";
    resultPwCheck.innerText = "*비밀번호를 입력해주세요"
    resultId.classList.add("error");
    resultPw.classList.add("error");
    
  }

  return;
  
});


/**************************이메일 클릭 시*************************/
inputEmail.addEventListener("click", ()=>{
  const val = inputEmail.value.trim();
  inputEmail.value = val;
  
  if(val.length === 0){
    resultId.innerText = "*필수 입력 항목입니다";
    resultPw.innerText = "*필수 입력 항목입니다";
    resultPwCheck.innerText = "*필수 입력 항목입니다";
   
    
    resultId.classList.add("error");
    resultPw.classList.add("error");
    resultPwCheck.classList.add("error");
    
  }

  return;
  
});



/**************************주소 클릭 시*************************/
inputAddress.addEventListener("click", ()=>{
  const val = inputAddress.value.trim();
  inputAddress.value = val;
  
  if(val.length === 0){
    resultId.innerText = "*필수 입력 항목입니다";
    resultPw.innerText = "*필수 입력 항목입니다";
    resultPwCheck.innerText = "*필수 입력 항목입니다";
    resultEmail.innerText = "*필수 입력 항목입니다";
   
    
    resultId.classList.add("error");
    resultPw.classList.add("error");
    resultPwCheck.classList.add("error");
    resultEmail.classList.add("error");
    
  }

  return;
  
});
