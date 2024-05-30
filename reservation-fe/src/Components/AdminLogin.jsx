import React, { useState } from 'react'
import '../Styles/AdminLogin.css'
import { Link } from 'react-router-dom'
export default function AdminLogin() {
  let [username,setusername] = useState("")
  let [password,setpassword] = useState("")

  function verify(){
    if(username == "abcd" && password == 1234){
      alert("Login Succefull")
    }
    else{
      alert("login failed")
    }
  }
  return (
    <div className='AdminLogin'>
        <form onSubmit={verify} action="">
            <label htmlFor="">  
                UserName
            </label>
            <input type="text" value={username} onChange={(e)=>{setusername(e.target.value)}} placeholder='Enter the username' required />
            <label htmlFor="">
                Password
            </label>
            <input type="text" value={password} onChange={(e)=>{setpassword(e.target.value)}}  placeholder='Enter the password' required />
            <button className='btn btn-primary'>Login</button>

        </form>
        <p>Are you the new user ? <Link to="/adminsignup">Register here..</Link></p>

    </div>
  )
}
