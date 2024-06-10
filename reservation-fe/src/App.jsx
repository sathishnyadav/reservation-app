import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter, Route,Routes } from 'react-router-dom';
import LandingPage from './Components/LandingPage';
import AdminLogin from './Components/AdminLogin';
import AdminSignUp from './Components/AdminSignUp';
import UserLogin from './Components/UserLogin';
import AdminHomePage from './Components/AdminHomePage';
import PageNotFound from './Components/PageNotFound';
import Protect from './Components/Protect';
function App() {
  return (
    <div className="App">
     <BrowserRouter>
     <Routes>
      <Route path='/*' element={<PageNotFound/>}/>
      <Route path='/' element={<LandingPage/>}/>
      <Route path='/adminlogin' element={<AdminLogin/>}/>
      <Route path='/userlogin' element={<UserLogin/>}/>
      <Route path='/adminsignup' element={<AdminSignUp/>}/>
      <Route path='/adminhomepage/*' element={<Protect Child={AdminHomePage}/>}/>
     </Routes>
     </BrowserRouter>
    </div>
  );
}

export default App;