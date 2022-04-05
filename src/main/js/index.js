import React from "react";
import ReactDOM from "react-dom";

import Navbar from "./Navbar/Navbar";
import Dashboard from "./Dashboard/Dashboard";
import Footer from "./Footer/Footer";


import 'bootstrap/dist/css/bootstrap.min.css';

ReactDOM.render(
    <div className='d-flex flex-column h-100 w-100'>
        <Navbar />
        <Dashboard />
        <Footer />
    </div>,
    document.getElementById("root")
);
