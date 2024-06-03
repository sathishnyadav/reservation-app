import React from 'react'
import Dropdown1 from './DropDowns'
import '../Styles/AdminNavbar.css'
export default function AdminNavbar() {
  return (
    <div className='AdminNavbar'>
      <div className="logo">
        <h1><i>yatra</i><sup><i>.in</i></sup></h1>
      </div>
      <div className="options">
        <Dropdown1/>
      </div>
    </div>
  )
}
