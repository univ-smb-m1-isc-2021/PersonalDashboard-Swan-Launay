import React, {useEffect, useState} from "react";
import "core-js";
import "regenerator-runtime/runtime";


import './../../common.css';
import {getName} from "../../Services/UserService";

function Navbar() {

    const [name, setName] = useState("there");

    useEffect(() => {
        getName().then(res => {
            setName(res.name);
        });
    }, []);


    return <nav className='navbar navbar-dark bg-dark justify-content-between'>
        <a className='navbar-brand ms-3'>Hello <b>{name}</b>, nice to see you again</a>
        <ul className='nav nav-pills'>
            {/*
            <li className='nav-item me-2'>
                <Settings />
            </li>
            */}
            <li className='nav-item me-2'>
                <a className='btn btn-dark shadow-sm' href='/logout'>
                    Logout
                </a>
            </li>
        </ul>
    </nav>;
}


export default Navbar;