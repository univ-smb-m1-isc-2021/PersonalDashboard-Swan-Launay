import {Modal} from "react-bootstrap";
import React, {useState} from "react";
import {addGroup} from "../../../Services/GroupService";

function NewGroupModal(props) {

    const [groupName, setGroupName] = useState('');

    const handleClose = () => {
        props.setShow(false);
        setGroupName('');
    };

    const handleSubmit = () => {
        addGroup(groupName).then(r => {
            handleClose()
            props.reloadGroups();
        });
    };


    function handleGroupNameChange(e) {
        setGroupName(e.target.value);
    }

    return <Modal centered show={props.show} className='' onHide={handleClose}>
        <Modal.Header closeButton>
            <Modal.Title>New Group</Modal.Title>
        </Modal.Header>
        <Modal.Body>
            <div className='mb-2'>
                <input type='text' placeholder="Group name" className='form-control' onChange={handleGroupNameChange}
                       value={groupName}/>
            </div>
        </Modal.Body>
        <button className="submit-button" onClick={handleSubmit}>Add to dashboard</button>
    </Modal>;
}

export default NewGroupModal;