import React,{useState,createContext,useContext} from 'react';

/* 1. Context 객체 생성 */
const testContext = createContext();

/* 4. 손주(2단계 하위) 컴포넌트 */
const GradnChild = ()=>{

  // {"number" : number , setNumber" : setNumber}
  const{number,setNumber}= useContext(testContext);
  return(
    <>
      <h3>GradnChild component</h3>

      <input type='number' onChange={(e)=>{setNumber(e.target.value)}} value={number}/>

    </>
  );
};

/* 3. 자식(1단계 하위) 컴포넌트 */
const Child = ()=>{
  return(
    <>
      <h2>Child component</h2>
      <GradnChild/>
    </>
  );
};

/* 2. 부모 컴포넌트 */
const Parent = ()=>{
  const[number,setNumber] = useState(0);

  //상태 변수 선언
  return(

    /* Context에 추가해서 하위 컴포넌트에게 제공 */
    // {"number" : number , setNumber" : setNumber}
    <testContext.Provider value={{number,setNumber}}>"
      <h1>Parent component</h1>

      <h1>
        GrandChild에서 전달된 값
        <span className='color-red'> {number} </span>
      </h1>

      <Child/>
    </testContext.Provider>

  );
};

export default Parent;