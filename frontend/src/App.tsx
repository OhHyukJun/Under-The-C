import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Board from './Pages/Board/Board';
import RegisterPage from './Pages/Auth/RegisterPage';
import Main from './Pages/Main/Main';
import UserPage from './Pages/User/UserPage';

//<Route path="/" element={<Main/>}/>
const App = () => {
  return (
    <>
      {
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<Main/>}/>
            <Route path="/board" element={<Board/>}/>
            <Route path="/UserPage" element={<UserPage/>}/>
            <Route path="/RegisterPage" element={<RegisterPage/>}/>
          </Routes>
        </BrowserRouter>
      }
    </>
  )
}

export default App;
