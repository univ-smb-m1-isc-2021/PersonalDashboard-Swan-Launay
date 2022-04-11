import {Modal} from "react-bootstrap";
import React, {useState} from "react";
import './NewShortcutModal.css';
import {addShortcut, updateShortcut} from "../../../Services/ShortcutService";

function EditShortcutModal(props) {

    const [name, setName] = useState(props.shortcutName);
    const [url, setUrl] = useState(props.shortcutUrl);
    const [icon, setIcon] = useState(props.shortcutIcon);
    const [description, setDescription] = useState(props.shortcutDescription);
    const [keyMap, setKeyMap] = useState(props.shortcutKeyMap);


    function handleName(e) {
        setName(e.target.value);
    }

    function handleDesc(e) {
        setDescription(e.target.value);
    }

    function handleIcon(e) {
        setIcon(e.target.value);
    }

    function handleUrl(e) {
        setUrl(e.target.value);
    }

    const handleKeyMapChange = (e) => {
        setKeyMap(e.key);
        document.removeEventListener('keydown', handleKeyMapChange);
    };
    const listenKey = (e) => {
        setKeyMap("Press a key ...");
        document.addEventListener('keydown', handleKeyMapChange);
    };


    const handleCloseEditShortcutModal = () => {
        props.setShow(false);
    }


    const handleSubmitEditShortcutModal = () => {
        updateShortcut(props.shortcutId, name, description, icon, url, keyMap).then(r => {
            props.reloadGroups();
            handleCloseEditShortcutModal();
        });
    };


    return <Modal centered show={props.show} className='' onHide={handleCloseEditShortcutModal}>
        <Modal.Header closeButton>
            <Modal.Title>Edit the shortcut <b>{name}</b></Modal.Title>
        </Modal.Header>
        <Modal.Body>
            <form className="mb-2">
                <input type='text' placeholder="New shortcut name" onChange={handleName} value={name}
                       className='form-control my-1'/>
                <input type='text' placeholder="New description" onChange={handleDesc} value={description}
                       className='form-control my-1'/>
                <input type='url' placeholder="New image URL" onChange={handleIcon} value={icon}
                       className='form-control my-1'/>
                <input type='url' placeholder="New targeted website URL" onChange={handleUrl} value={url}
                       className='form-control my-1'/>
                <button type='button' className='keymap my-2' onClick={listenKey}>{keyMap}</button>
            </form>

        </Modal.Body>
        <button className="submit-button" onClick={handleSubmitEditShortcutModal}>Update {name}</button>
    </Modal>;
}

export default EditShortcutModal;