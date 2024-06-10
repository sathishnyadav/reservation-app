import { Navigate } from 'react-router-dom';
export default function Protect({Child}) {
    let x = localStorage.getItem("Admin")

  function verify(){
    if(x == null){
        return false;
    }
    else{
        return true;
    }
  }
  return (
    <div>
      {verify() ? <Child/> : <Navigate to='/adminlogin'/>}
    </div>
  )  
}
