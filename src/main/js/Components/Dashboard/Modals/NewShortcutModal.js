import {Modal} from "react-bootstrap";
import React, {useState} from "react";
import './NewShortcutModal.css';
import {addShortcut} from "../../../Services/ShortcutService";
function NewShortcutModal(props){

    const [name, setName] = useState('');
    const [url, setUrl] = useState('');
    const [icon, setIcon] = useState('');
    const [description, setDescription] = useState('');
    const [keyMap, setKeyMap] = useState("Click here to select a key");


    function handleName(e) {setName(e.target.value);}
    function handleDesc(e) {setDescription(e.target.value);}
    function handleIcon(e) {setIcon(e.target.value);}
    function handleUrl(e) {setUrl(e.target.value);}
    const handleKeyMapChange = (e) => {
        setKeyMap(e.key);
        document.removeEventListener('keydown', handleKeyMapChange);
    };
    const listenKey = (e) => {
        setKeyMap("Press a key ...");
        document.addEventListener('keydown', handleKeyMapChange);
    };


    const handleCloseAddShortcutModal = () => {
        props.setShow(false);
        setName('');
        setDescription('');
        setIcon('');
        setUrl('');
        setKeyMap("Click here to select a key");
    }


    const handleSubmitAddShortcutModal = () => {
        addShortcut(name, description, icon, url, keyMap, props.groupId).then(r => {
            props.reloadGroups();
            handleCloseAddShortcutModal();
        });
    };





    return <Modal centered show={props.show} className='' onHide={handleCloseAddShortcutModal}>
        <Modal.Header closeButton>
            <Modal.Title>Add a new shortcut to <b>{props.groupName}</b></Modal.Title>
        </Modal.Header>
        <Modal.Body>
            <form className="mb-2">
                <input type='text' placeholder="Shortcut name" onChange={handleName} value={name} className='form-control my-1'/>
                <input type='text' placeholder="A quick description" onChange={handleDesc}  value={description}  className='form-control my-1'/>
                <input type='url' placeholder="Image URL" onChange={handleIcon}  value={icon}  className='form-control my-1'/>
                <input type='url' placeholder="Targeted website URL" onChange={handleUrl}  value={url}  className='form-control my-1'/>
                <button type='button' className='keymap my-2'  onClick={listenKey}>{keyMap}</button>
            </form>

        </Modal.Body>
        <button className="submit-button" onClick={handleSubmitAddShortcutModal}>Add to {props.groupName}</button>
    </Modal>;
}

export default NewShortcutModal;