function plus(){
  const input1 = document.getElementById("input1");
  const input2 = document.getElementById("input2");
  
  // console.log(input1.value);
  // console.log(input2.value);

  // console.log(input1.value + input2.value);
  // console.log(Number(input1.value) + Number(input2.value));

  
  // 요소.innerText : <시작>내용</종료> -> 내용에 글자 대입
  document.getElementById("result").innerText = Number(input1.value) + Number(input2.value);
}



function minus(){
   const input1 = document.getElementById("input1");
   const input2 = document.getElementById("input2");

  document.getElementById("result").innerText =  Number(input1.value) - Number(input2.value);

}


function multi(){
  const input1 = document.getElementById("input1");
  const input2 = document.getElementById("input2");

  document.getElementById("result").innerText = Number(input1.value) * Number(input2.value);
}

function div(){
  const input1 = document.getElementById("input1");
  const input2 = document.getElementById("input2");

  

  document.getElementById("result").innerText = Number(input1.value) / Number(input2.value);
}

function mod(){
  const input1 = document.getElementById("input1");
  const input2 = document.getElementById("input2");

  

  document.getElementById("result").innerText = Number(input1.value) % Number(input2.value);
}

