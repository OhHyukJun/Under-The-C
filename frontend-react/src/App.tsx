import React from 'react';
import "./App.css";
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Board from './Pages/Board/Board';
import LoginPage from './Pages/Auth/LoginPage';
import RegisterPage from './Pages/Auth/RegisterPage';
import Header from './Layout/Header';
import Footer from './Layout/Footer';
import Main from './Pages/Main/Main';
import UserPage from './Pages/User/UserPage';

//<Route path="/" element={<Main/>}/>
const App = () => {
  return (
    <>
    <Header/>
      {
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<Main/>}/>
            <Route path="/Board" element={<Board/>}/>
            <Route path="/UserPage" element={<UserPage/>}/>
            <Route path='/LoginPage' element={<LoginPage/>}/>
            <Route path="/RegisterPage" element={<RegisterPage/>}/>
          </Routes>
        </BrowserRouter>
      }
      <Footer/>
    </>
  )
}

export default App;
