import React, { useState } from 'react';

const NumberPlusMinus = (props) =>{

  const [count, setCount] = useState(props.init);
  
  return(

    <div>
      <button onClick={()=>{setCount(count-1)}} className='minusBtn'>-</button>
      <h1>{count}</h1>
      <button onClick={()=>{setCount(count+1)}} className='plusBtn'>+</button>
    </div>
  ); 
}

export default NumberPlusMinus;