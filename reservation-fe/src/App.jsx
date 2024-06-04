import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter, Route,Routes } from 'react-router-dom';
import LandingPage from './Components/LandingPage';
import AdminLogin from './Components/AdminLogin';
import LoginUser from './Components/LoginUser';
import AdminSignUp from './Components/AdminSignUp';
function App() {
  return (
    <div className="App">
     <BrowserRouter>
     <Routes>
      <Route path='/' element={<LandingPage/>}/>
      <Route path='/adminlogin' element={<AdminLogin/>}/>
      <Route path='/userlogin' element={<LoginUser/>}/>
      <Route path='/adminsignup' element={<AdminSignUp/>}/>
     </Routes>
     </BrowserRouter>
    </div>
  );
}

export default App;
