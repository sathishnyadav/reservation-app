import axios from 'axios';
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';

export default function AdminDashBoard() {
  let [from,setfrom] = useState("")
  let [to,setto] = useState("")
  let [dateOfDeparture,setdate] = useState("")

  let [buses,setbuses] = useState([])
  let navigate = useNavigate()
  function searchBus(e){
    e.preventDefault();
    // axios.get(`http://localhost:8080/api/buses?
    // from=${from}&to=
    // ${to}&dateOfDeparture=
    // ${dateOfDeparture}`)

    axios.get(`http://localhost:8080/api/buses?from=${from}&to=${to}&dateOfDeparture=${dateOfDeparture}`)
    .then(res =>{
      console.log(res.data.data);
      setbuses(res.data.data)
    })
    .catch((err)=>{
      console.log(err);
    })
  }

  function bookbus(id){
    navigate(`/adminhomepage/bookbus/${id}`)
  }
  return (
    <div className='AdminDashBoard'>
      <form onSubmit={searchBus} action="">
        <input type="text" required value={from} onChange={(e)=>{setfrom(e.target.value)}} placeholder='Enter the From Location' />
        <input type="text" required value={to} onChange={(e)=>{setto(e.target.value)}} placeholder='Enter the To Location' />
        <input type="date" required value={dateOfDeparture} onChange={(e)=>{setdate(e.target.value)}} placeholder='Enter the Date of Departure ' />
        <button>Search</button>
      </form>
      {buses.map((item)=>{
        return (
          <div style={{display:"flex",justifyContent:"space-evenly",boxShadow:"0px 0px 10px grey",margin:"2px"}} className="bus_list">
            <h4>{item.name}</h4>
            <i>Seats : {item.seats}</i>
            <p>From : {item.from}</p>
            <p>To : {item.to}</p>
            <p>Date : {item.dateOfDeparture}</p>
            <span>Bus Number :{item.bus_number}</span>
            <button className='btn btn-danger' onClick={()=>{bookbus(item.id)}}>Book Bus</button>          
          </div>
        )
      })}

      <h1>Bus Booking Discount Offers</h1>
    </div>
  )
}
