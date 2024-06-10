import React, { useState } from 'react'
import '../Styles/AddBus.css'
import axios from 'axios'
import { type } from '@testing-library/user-event/dist/type'
export default function AddBus() {
    let [name, setname] = useState("")
    let [dateOfDeparture, setdate] = useState("")
    let [busNumber, setbus_number] = useState("")
    let [from, setfrom] = useState("")
    let [to, setto] = useState("")
    let [numberOfSeats, setseats] = useState("")

    let busData = {
        name,dateOfDeparture,busNumber,from,to,numberOfSeats
    }

    let admin = JSON.parse(localStorage.getItem("Admin"))
    
    function addBusData(e){
        e.preventDefault()
        axios.post(`http://localhost:8080/api/buses/${admin.id}`,busData)
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
        <div className='AddBus'>
            <form onSubmit={addBusData} action="">
                <label htmlFor="">Bus Name:</label>
                <input type="text" placeholder='Enter the bus Name' required value={name} onChange={(e) => { setname(e.target.value) }} />
                <label htmlFor="">From : </label>
                <input type="text" placeholder='Enter the From Details' required value={from} onChange={(e) => { setfrom(e.target.value) }} />
                <label htmlFor="">To : </label>
                <input type="text" placeholder='Enter the To Details' required value={to} onChange={(e) => { setto(e.target.value) }} />
                <label htmlFor="">Date Of Departure : </label>
                <input type="date" placeholder='Enter the bus Date' required value={dateOfDeparture} onChange={(e) => { setdate(e.target.value) }} />
                <label htmlFor="">Number Of Seats:</label>
                <input type="number" placeholder='Enter the seat Details' required value={numberOfSeats} onChange={(e) => { setseats(e.target.value) }} />
                <label htmlFor="">Bus Number : </label>
                <input type="text" placeholder='Enter the bus Number' required value={busNumber} onChange={(e) => { setbus_number(e.target.value) }} />
                <button className='btn btn-danger'>Add Bus</button>
            </form>
        </div>
    )
}
