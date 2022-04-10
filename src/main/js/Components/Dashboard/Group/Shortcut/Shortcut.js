import React from 'react';
import './Shortcut.css'


function Shortcut(props){

    function openUrl(){
        window.open(props.shortcutUrl, '_blank');
    }

    const removeShortcut = () => {
        //props.removeShortcut(props.shortcutId);
    }

    function editShortcut() {

    }

    function EditShortcut(props) {
        if(props.show){
            return <div className='shortcut_remove_container'>
                <button className='shortcut_edit_button shortcut_action' onClick={editShortcut} />
                <button className='shortcut_remove_button shortcut_action' onClick={removeShortcut} />
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
    </div>
}

export default Shortcut;