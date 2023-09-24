const inputName  = document.querySelector("#input-name");
const nameResult = document.querySelector("#name-result");

inputName.addEventListener("keyup",()=>{
    const regEx = /^[가-힣]{2,15}$/;

    const value = inputName.value.trim();  //좌우공백 제거
    inputName.value = value;


    if(value.length == 0){  //입력된 값이 없으면
        nameResult.innerText = "이름을 입력하세요";

        nameResult.classList.remove("check");
        nameResult.classList.remove("error");
        return;
    }

    if(regEx.test(value)){  //유효한 경우
        nameResult.innerText = "유효한 이름입니다";

        nameResult.classList.add("check");
        nameResult.classList.remove("error");

    }else{
        nameResult.innerText = "유효하지 않은 이름입니다";

        nameResult.classList.add("error");
        nameResult.classList.remove("check");
    }

});


const inputId = document.querySelector("#input-id");
const idResult = document.querySelector("#id-result");

inputId.addEventListener("keyup",()=>{

    const regEx = /^[A-Za-z\d\-\_]{6,16}$/;
    

    const value = inputId.value.trim();
    inputId.value = value;

    if(value.length == 0){ //입력된 값이 없으면
        idResult.innerText = "아이디를 입력하세요";
        idResult.classList.remove("check");
        idResult.classList.remove("error");
    }

    if(regEx.test(value)){ //입력값이 유효하면
        idResult.innerText = "유효한 아이디 입니다";
        idResult.classList.add("check");
        idResult.classList.remove("error");
    }else{
        idResult.innerText = "유효하지 않은 아이디 입니다";
        idResult.classList.add("error");
        idResult.classList.remove("check");
    }




});


const inputPw = document.querySelector("#input-name");











