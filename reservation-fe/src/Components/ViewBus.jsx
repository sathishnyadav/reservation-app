import axios from 'axios'
import React, { useEffect, useState } from 'react'

export default function ViewBus() {
  let [bus, setbus] = useState([])
  useEffect(() => {
    axios.get(`http://localhost:8080/api/bus`)
      .then((res) => {
        console.log(res);
        setbus(res.data)
      })
      .catch((err) => {
        console.log(err);
      })
  }, [])


  function removeBus(id, bus_no) {
    axios.delete(`http://localhost:8080/api/bus/${id}`)
      .then((res) => {
        alert(`Bus Number ${bus_no} has been Removed from the list`)
      })
      .catch((err) => {
        alert("Cannot Remove this item")
      })
  }
  
  return (
    <div className='ViewBus'>
      {bus.map((item) => {
        return (
          <div className="bus_details">
            <h4>{item.name}</h4>
            <i>Seats : {item.seats}</i>
            <p>From : {item.from_location}</p>
            <p>To : {item.to_location}</p>
            <p>Date : {item.date_of_departure}</p>
            <span>Bus Number :{item.bus_number}</span>
            <button className='btn btn-warning'>Edit</button>
            <button className='btn btn-danger' onClick={() => { removeBus(item.id, item.bus_number) }}>Delete</button>
          </div>
        )
      })}
    </div>
  )
}
