import React, { useEffect, useState } from 'react'
import '../Styles/AdminLogin.css'
import { Link, useNavigate } from 'react-router-dom'
import axios from 'axios'
export default function AdminLogin() {
  let [email,setusername] = useState("")
  let [password,setpassword] = useState("")
  
  let navigate =  useNavigate()

  function verify(e){
    e.preventDefault()
   axios.post(`http://localhost:8080/api/admins/verify-by-email?email=${email}&password=${password}`)
   .then((res)=>{
    navigate('/adminhomepage')
    alert("Login Succesfull")
   }) 
   .catch((err)=>{
    alert("Login Failed")
   })
  }
  return (
    <div className='AdminLogin'>
        <form onSubmit={verify} action="">
            <label htmlFor="">  
                UserName
            </label>
            <input type="text" value={email} onChange={(e)=>{setusername(e.target.value)}} placeholder='Enter the username' required />
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