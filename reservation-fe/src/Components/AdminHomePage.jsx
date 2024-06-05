import React from 'react'
import { Route,Routes } from 'react-router-dom'
import AdminNavbar from './AdminNavbar'
import AdminDashBoard from './AdminDashBoard'
import AddBus from './AddBus'

export default function AdminHomePage() {
  return (
    <div>
        <AdminNavbar/>
      <Routes>
        <Route path='/' element={<AdminDashBoard/>}/>
        <Route path='/addbus' element={<AddBus/>}/>
      </Routes>
    </div>
  )
}
