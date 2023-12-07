import React from 'react';

/* 변수형태로 함수 선언 */
/* 컴포넌트 함숨여, 변수명은 대문자로 시작 */
/* props : 매개변수 */
const PropsEx1 = (props) => {

  console.log(props);

  return(
    /* fragment(조각) : 감싸는 용도 */
    /* 컴포넌트 함수는 하나의 요소만 리턴가능! 여러개의 태그 사용하기 위해 묶음 */
    <>
      <h3>번호 : {props.num} / 이름 : {props.name}</h3>
    </>
  );
};

//외부에서 import 시 PropsEx1 함수(컴포넌트)를 기본값으로 내보냄
export default PropsEx1;