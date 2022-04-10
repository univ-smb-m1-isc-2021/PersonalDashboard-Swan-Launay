import {Modal} from "react-bootstrap";
import React from "react";
import {deleteGroup, updateGroup} from "../../../Services/GroupService";
import './EditGroupModal.css';

function EditGroupModal(props){

    const handleCloseEditGroupModal = () => {
        props.setShow(false);
        setNewGroupName('');
    };

    const [newGroupName, setNewGroupName] = React.useState('');

    const handleChangeNewGroupName = (event) => {
        setNewGroupName(event.target.value);
    };

    const handleSubmitUpdateGroup = () => {
        if (newGroupName !== '') {
            updateGroup(props.groupId, newGroupName).then(r => {
                console.log(r);
                handleCloseEditGroupModal();
                props.reloadGroups();
                console.log("Handle error");
            });
        }
    };


    function handleRemoveGroup() {
        deleteGroup(props.groupId).then(r => {
            console.log(r);
            props.reloadGroups();
            handleCloseEditGroupModal();
            console.log("Handle error");
        });
    }

    return <Modal centered show={props.show} className='' onHide={handleCloseEditGroupModal}>
        <Modal.Header closeButton>
            <Modal.Title>Edit the group <b>{props.groupName}</b></Modal.Title>
        </Modal.Header>
        <Modal.Body>
            <div className="mb-2">
                <input type='text' placeholder="New group name" className='form-control' onChange={handleChangeNewGroupName} value={newGroupName}/>
                <div className="mt-2 danger-zone">
                    Danger zone
                    <button type="button" className='btn btn-danger mt-2' onClick={handleRemoveGroup}>Delete group</button>
                </div>
            </div>
        </Modal.Body>
        <button type="button"  className="submit-button" onClick={handleSubmitUpdateGroup}>Save {props.groupName}</button>
    </Modal>;
}

export default EditGroupModal;