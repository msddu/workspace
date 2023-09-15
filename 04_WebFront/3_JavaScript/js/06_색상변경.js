function btn(){
  const boxs = document.getElementsByClassName("box");
  const inputs = document.getElementsByClassName("input")

  console.log(boxs);
  console.log(inputs);

  boxs[0].style.backgroundColor = inputs[0].value;




}