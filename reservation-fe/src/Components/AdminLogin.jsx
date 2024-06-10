import React, { useState } from 'react'
import '../Styles/AdminLogin.css'
import { Link, useNavigate } from 'react-router-dom'
import axios from 'axios'
export default function AdminLogin() {
  let [email,setemail] = useState("")
  let [password,setpassword] = useState("")

  let nav = useNavigate()
  function verify(e){
    e.preventDefault()
    axios.post(`http://localhost:8080/api/admins/verify-by-email?email=${email}&password=${password}`)
    .then((res)=>{
        alert("Login Successfull")
        console.log(res.data.data);
        localStorage.setItem("Admin",JSON.stringify(res.data.data))
        nav('/adminhomepage')

    })
    .catch((err)=>{
        alert("Login Fail")
    })

  }

  return (
    <div className='AdminLogin'>
        <form onSubmit={verify} action="">
            <label htmlFor="">  
                email
            </label>
            <input type="text" value={email} onChange={(e)=>{setemail(e.target.value)}} placeholder='Enter the email' required />
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
