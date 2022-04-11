import React from 'react';
import './Shortcut.css'
import EditShortcutModal from "../../Modals/EditShortcutModal";
import {removeShortcut} from "../../../../Services/ShortcutService";


function Shortcut(props){

    const [showEditModal, setShowEditModal] = React.useState(false);

    function openUrl(){
        window.open(props.shortcutUrl, '_blank');
    }

    const handleRemoveShortcut = () => {
        removeShortcut(props.shortcutId).then(r => {
            props.reloadGroups();
        });
    }

    function handleEditShortcut() {
        setShowEditModal(true);
    }

    function EditShortcut(props) {
        if(props.show){
            return <div className='shortcut_remove_container'>
                <button className='shortcut_edit_button shortcut_action' onClick={handleEditShortcut} />
                <button className='shortcut_remove_button shortcut_action' onClick={handleRemoveShortcut} />
            </div>;
        } else {
            return <div></div>;
        }
    }

    return <div className='shortcut_container card'>
        <EditShortcut show={props.showEdit}/>
        <img className='card-img-top shortcut_img' src={props.shortcutHeader} alt=" "/>
        <div className="shortcut_letter_container">
            <div className='shortcut_letter'>{props.shortcutKey}</div>
        </div>
        <div className='card-body'>
            <p className='card-text'>{props.shortcutDesc}</p>
        </div>
        <button onClick={openUrl} className="shortcut_button">Access &#10140; </button>
        <EditShortcutModal show={showEditModal}
                           setShow={setShowEditModal}
                           shortcutId={props.shortcutId}
                           shortcutKeyMap={props.shortcutKey}
                           shortcutDescription={props.shortcutDesc}
                           shortcutUrl={props.shortcutUrl}
                           shortcutIcon={props.shortcutHeader}
                           shortcutName={props.shortcutName}
                           reloadGroups={props.reloadGroups}
        />
    </div>
}

export default Shortcut;