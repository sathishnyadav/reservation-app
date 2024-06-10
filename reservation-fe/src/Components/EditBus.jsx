import axios from 'axios'
import React, { useEffect } from 'react'
import { useState } from 'react'
import { useParams } from 'react-router-dom'
export default function EditBus() {
    let [name, setname] = useState("")
    let [date_of_departure, setdate] = useState("")
    let [bus_number, setbus_number] = useState("")
    let [from_location, setfrom] = useState("")
    let [to_location, setto] = useState("")
    let [no_of_seats, setseats] = useState("")

    let params = useParams()
    useEffect(()=>{
        axios.get(`http://localhost:8080/api/bus/${params.id}`)
        .then((res)=>{
            console.log(res.data);
            setname(res.data.name)
            setbus_number(res.data.bus_number)
            setfrom(res.data.from_location)
            setto(res.data.to_location)
            setseats(res.data.no_of_seats)
            setdate(res.data.date_of_departure)
        })
    },[])


    let newbus = { name,date_of_departure,bus_number,from_location,to_location,no_of_seats }
    function editBus(e){
        e.preventDefault()
        axios.put(`http://localhost:8080/api/bus/${params.id}`,newbus)
        .then((res)=>{
            console.log(res);
            alert("Bus Details Have been Edited Successfully")
        })
        .catch((err)=>{ 
            console.log(err);
            alert("Invalid Data Format")
        })
    }
  return (
    <div className='editbus'>
        <form onSubmit={editBus} action="">
                <label htmlFor="">Bus Name:</label>
                <input type="text" placeholder='Enter the bus Name' required value={name} onChange={(e) => { setname(e.target.value) }} />
                <label htmlFor="">From : </label>
                <input type="text" placeholder='Enter the From Details' required value={from_location} onChange={(e) => { setfrom(e.target.value) }} />
                <label htmlFor="">To : </label>
                <input type="text" placeholder='Enter the To Details' required value={to_location} onChange={(e) => { setto(e.target.value) }} />
                <label htmlFor="">Date Of Departure : </label>
                <input type="date" placeholder='Enter the bus Date' required value={date_of_departure} onChange={(e) => { setdate(e.target.value) }} />
                <label htmlFor="">Number Of Seats:</label>
                <input type="number" placeholder='Enter the seat Details' required value={no_of_seats} onChange={(e) => { setseats(e.target.value) }} />
                <label htmlFor="">Bus Number : </label>
                <input type="text" placeholder='Enter the bus Number' required value={bus_number} onChange={(e) => { setbus_number(e.target.value) }} />
                <button className='btn btn-danger'>Update</button>
            </form>
    </div>
  )
}
