import React from 'react';
import Shortcut from "./Shortcut/Shortcut";

import './Group.css';
import {Modal} from "react-bootstrap";
import NewShortcutModal from "../Modals/NewShortcutModal";
import EditGroupModal from "../Modals/EditGroupModal";

function Group(props){

    // START : Modals state handlers
    const [showEditGroupModal, setShowEditGroupModal] = React.useState(false);
    const [showAddShortcutModal, setShowAddShortcutModal] = React.useState(false);
    const handleShowEditGroupModal = () => setShowEditGroupModal(true);
    const handleShowAddShortcutModal = () => setShowAddShortcutModal(true);
    // END : Modals state handlers

    const [showEditShortcutButton, setShowEditShortcutButton] = React.useState(false);


    const shortcuts = []

    for(let i = 0; i < props.shortcuts.length; i++){
        let shortcut = props.shortcuts[i];
        shortcuts.push(<Shortcut key={"shortcut"+shortcut.shortcutId}
                                 shortcutId={shortcut.shortcutId}
                                 shortcutName={shortcut.name}
                                 shortcutHeader={shortcut.headerUrl}
                                 shortcutUrl={shortcut.url}
                                 shortcutKey={shortcut.keyboardShortcut}
                                 shortcutDesc={shortcut.description}
                                 showEdit={showEditShortcutButton}
                                 reloadGroups={props.reloadGroups}

        />);
    }

    function handleToggleEditShortcuts() {
        if(showEditShortcutButton){
            setShowEditShortcutButton(false);
        }else{
            setShowEditShortcutButton(true);
        }
    }

    return <div className='group_container'>
      <div className='group_header'>
          <div className='group_title'>{props.groupName}</div>
          <div className='btn-group'>
              <button type="button" onClick={handleShowAddShortcutModal} className="btn btn-dark btn-sm">Add shortcut</button>
              <button type="button" onClick={handleToggleEditShortcuts}  className="btn btn-dark btn-sm">Toggle shortcut editing</button>
              <button type="button" onClick={handleShowEditGroupModal}  className="btn btn-dark btn-sm">Edit group</button>
          </div>
      </div>
      <div className='group_items'>
          {shortcuts}
      </div>
      <NewShortcutModal reloadGroups={props.reloadGroups}
                        setShow={setShowAddShortcutModal}
                        show={showAddShortcutModal}
                        groupName={props.groupName}
                        groupId={props.groupId}/>
      <EditGroupModal reloadGroups={props.reloadGroups}
                      setShow={setShowEditGroupModal}
                      show={showEditGroupModal}
                      groupName={props.groupName}
                      groupId={props.groupId}/>
    </div>;
}

export default Group;