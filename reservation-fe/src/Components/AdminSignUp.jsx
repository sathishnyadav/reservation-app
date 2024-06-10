import React, { useState } from "react";
import "../Styles/AdminSignup.css";
import axios from "axios";
export default function AdminSignUp() {
  let [name, setname] = useState("");
  let [email, setemail] = useState("");
  let [password, setpassword] = useState("");
  let [phone, setphone] = useState("");
  let [gst_number, setgstno] = useState("");
  let [travels_name, settravel] = useState("");

  let data = {name,email,password,phone,gst_number,travels_name}
  function addAdmin(e){
    e.preventDefault();
    axios.post(`http://localhost:8080/api/admins`,data)
    .then((res)=>{
        console.log(res);
        alert("Bus Details Have been Added Successfully")
    })
    .catch((err)=>{ 
        console.log(err);
        alert("Invalid Data Format")
    })
}
  return (
    <div className="AdminSignUp">
      <form onSubmit={addAdmin} action="">
        <label htmlFor="">Name</label>
        <input
          type="text"
          required
          placeholder="Enter the Name"
          value={name}
          onChange={(e) => setname(e.target.value)}
        />
        <label htmlFor="">Email</label>
        <input
          type="email"
          required
          placeholder="Enter the Email"
          value={email}
          onChange={(e) => setemail(e.target.value)}
        />
        <label htmlFor="">Phone</label>
        <input
          type="tel"
          pattern="[0-9]{10}"
          required
          placeholder="Enter the Phone"
          value={phone}
          onChange={(e) => setphone(e.target.value)}
        />
        <label htmlFor="">gst_no</label>
        <input
          type="text"
          required
          placeholder="Enter the gst_no "
          value={gst_number}
          onChange={(e) => setgstno(e.target.value)}
        />
        <label htmlFor="">Travels_Name</label>
        <input
          type="text"
          required
          placeholder="Enter the Travels_Name"
          value={travels_name}
          onChange={(e) => settravel(e.target.value)}
        />
        <label htmlFor="">Password</label>
        <input
          type="text"
          required
          placeholder="Enter the Password"
          value={password}
          onChange={(e) => setpassword(e.target.value)}
        />
        <button className="btn btn-danger">Register</button>
      </form>
    </div>
  );
}
