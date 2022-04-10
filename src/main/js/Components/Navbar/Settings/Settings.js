import React, {useState} from 'react';

import {Modal} from 'react-bootstrap';

import './Settings.css';

function Settings(){
    const [showModal, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    return(
        <div>
            <button onClick={handleShow} className='btn btn-dark shadow-sm'>
                Settings
            </button>
            <Modal show={showModal} fullscreen className='settings_modal' onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Settings</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <p>Settings</p>
                </Modal.Body>
                <Modal.Footer>
                    <button className="btn btn-primary" onClick={handleClose}>Close</button>
                    <button className="btn btn-primary" onClick={handleClose}>Save</button>
                </Modal.Footer>
            </Modal>
        </div>
    )
}

export default Settings;