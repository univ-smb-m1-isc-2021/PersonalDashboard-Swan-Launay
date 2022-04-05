import React from "react";

import './Navbar.css';

function Navbar(){
    return <nav className='navbar navbar-dark bg-dark justify-content-between'>
        <a className='navbar-brand ms-3'>Hello [username] nice to see you again</a>
        <ul className='nav nav-pills'>
            <li className='nav-item me-2'>
                <button className='btn btn-light shadow-sm'>
                    New group
                </button>
            </li>
            <li className='nav-item me-2'>
                <button className='btn btn-light shadow-sm'>
                    Settings
                </button>
            </li>
            <li className='nav-item me-2'>
                <button className='btn btn-light shadow-sm'>
                    Logout
                </button>
            </li>
        </ul>
    </nav>;
}

export default Navbar;