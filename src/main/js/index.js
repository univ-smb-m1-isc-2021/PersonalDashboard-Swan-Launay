import React, {useEffect} from "react";
import ReactDOM from "react-dom";

import Navbar from "./Components/Navbar/Navbar";
import Dashboard from "./Components/Dashboard/Dashboard";
import Footer from "./Components/Footer/Footer";


import 'bootstrap/dist/css/bootstrap.min.css';

import './spinner.css';
import './common.css';


function Loader() {
    useEffect(() => {
        window.setTimeout(() => {
            document.getElementById("loader").classList.add("fade-out");
            window.setTimeout(() => {
                document.getElementById("loader").style.display = "none";
            }, 500);
        }, 500);
    });
    return (
        <div id="loader">
            <div className="lds-ellipsis">
                <div></div>
                <div></div>
                <div></div>
                <div></div>
            </div>
        </div>
    );
}

ReactDOM.render(
    <div className='d-flex flex-column h-100 w-100' id='main_container'>
        <Navbar/>
        <Dashboard/>
        <Footer/>
        <Loader/>
    </div>,
    document.getElementById("root")
);
