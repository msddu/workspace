// 유효성 검사 객체 생성
const checkList= {
    "input-id" : false,
    "input-pw" : false,
    "input-pw-check" : false,
    "input-name" : false
};

const inputId = document.getElementById("input-id");
const inputPw = document.getElementById("input-pw");
const inputPwCheck = document.getElementById("input-pw-check");
const inputName = document.getElementById("input-name");
const inputResult = document.querySelector(".input-result");

//아이디 유효성 검사
inputId.addEventListener("input", e=>{
    //공백제거
    const val = inputId.value.trim();
    inputId.value = val;
    


    if(val.length == 0){
        inputResult.innerText = "아이디를 입력해주세요";
        inputResult.classList.remove("check");
        inputResult.classList.remove("error");

        //유효성검사 객체의 값을 false로 변경(유효하지 않다)
        checkList["input-id"] = false;
        return;
    }

    const regEx = /^[A-Za-z\d\-\_]{6,16}$/;

    if(regEx.test(val)){ //유효한 경우
        inputResult.innerText = "유효한 아이디 입니다";
        inputResult.classList.add("check");  
        inputResult.classList.remove("error");
    }else{
        inputResult.innerText = "유효하지 아이디 입니다";
        inputResult.classList.add("error");
        inputResult.classList.remove("check");
    }


});