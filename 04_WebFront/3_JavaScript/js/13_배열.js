document.getElementById("btn1").addEventListener("click",()=>{

  const arr1 = new Array();
  const arr2 = new Array(3);
  const arr3 = [];
  const arr4 = ["사과", "바나나", "복숭아"];
  console.log(arr1);
  console.log(arr2);
  console.log(arr3);
  console.log(arr4);
  
  /* JS배열 기초 사용법 */

  //--배열에 요소를 추가하는 방법--
  //*요소를 지정된 인덱스에 추가할 수 있다!
  // -> 중간에 인덱스를 건너 뛰면 
  //    건너 뛴 인덱스 부분에 비어있는 요소를 자동 추가

  arr1[0] = "가나다";
  arr1[3] = 100;  //자료형 제한x

  console.log(arr1);

});

document.getElementById("btn2").addEventListener("click", ()=>{
  // 비어있는 배열 생성
  const arr = [];

  //push()
  arr.push("제육");
  arr.push("된장찌개");
  arr.push("라면");

  //unshift() : 첫 번째 요소 추가
  arr.unshift("칼국수");
  arr.unshift("햄버거");

  console.log(arr);

  //pop() : 마지막 요소 꺼내기
  let temp = arr.pop();

  console.log(arr);
  console.log(`꺼내진 요소 : ${temp}`);

  //shift() : 첫 번째 요소 꺼내기
  temp = arr.shift();
  console.log(arr);
  console.log(`꺼내진 요소 : ${temp}`);

  //sort() : 정렬(오름차순)
  console.log(arr); //정렬 전
  arr.sort();
  console.log(arr); //정렬 후

  
  /* sort() 사용 시 주의사항 
    ->문자열 숨서대로 오름차순 정렬(숫자 크기 x)

    해결 방법 : 정렬 기준 함수를 매개변수로 추가
                (a,b) => a-b (오름차순)
                (a,b) => b-a (내림차순)
  */
  const arr2 = [5,3,2,10,1];

  console.log( arr2.sort( (a,b) => a-b) ); 
  console.log( arr2.sort( (a,b) => b-a) ); 

  /* toString() : 배열 -> 문자열(구분자 ,) */
  console.log(arr.toString());

  /* joun("구분자") : 배열 -> 문자열(지정된 구분자) */
  console.log(arr.join(" 또는 "));
});




function testFn(callback){
  return callback(10,20) + 30;
}

function sum(a,b){
  return a + b;
}


/* 배열명.forEach() */
const forEachBtn = document.getElementById("forEach-btn");
forEachBtn.addEventListener("click", ()=>{
  const arr = [10,20.30,40,50];

  //arr의 모든 요소의 값을 *2한 결과를 출력
  arr.forEach( (item,index)=>{
    console.log(`${index} : ${item} * 2 = ${item*2}`);
  } )
});

const mapBtn = document.getElementById("map-btn");
mapBtn.addEventListener("click", ()=>{
  const arr = [10,20,30,40,50];

  const resultArr = arr.map(item=> item*2);
  console.log(arr);
  console.log(resultArr);
});

const forOfBtn = document.getElementById("for-if");
forOfBtn.addEventListener("click", ()=>{

  //.test 모두 얻어오기
  const arr = document.querySelectorAll(".test");

  for(let li of arr){
    console.log(li);
    li.innerText = "for of 테스트 중...";
  }

});