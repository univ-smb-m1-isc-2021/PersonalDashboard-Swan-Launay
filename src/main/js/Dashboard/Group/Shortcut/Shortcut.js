import React from 'react';
import './Shortcut.css'


function Shortcut(){
    return <div className='shortcut_container card'>
        <img className='card-img-top' src='/assets/tempo.jpg' alt='Shortcut image cap'/>
        <div className="shortcut_letter_container">
            <div className='shortcut_letter'>g</div>
        </div>
        <div className='card-body'>
            <p className='card-text'>Shortcut for group</p>
        </div>
        <button className='shortcut_button'>Access &#10140; </button>

    </div>
}

export default Shortcut;