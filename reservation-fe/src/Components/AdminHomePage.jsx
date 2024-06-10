import React from 'react'
import { Route,Routes } from 'react-router-dom'
import AdminNavbar from './AdminNavbar'
import AdminDashBoard from './AdminDashBoard'
import AddBus from './AddBus'
import EditBus from './EditBus'
import ViewBus from './ViewBus'
import BookBus from './BookBus'

export default function AdminHomePage() {
  return (
    <div>
        <AdminNavbar/>
      <Routes>
        <Route path='/' element={<AdminDashBoard/>}/>
        <Route path='/viewbus' element={<ViewBus/>}/>
        <Route path='/addbus' element={<AddBus/>}/>
        <Route path='/editbus/:id' element={<EditBus/>}/>
        <Route path='/bookbus/:id' element={<BookBus/>}/>
      </Routes>

    </div>
  )
}
