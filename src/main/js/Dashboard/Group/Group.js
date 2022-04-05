import React from 'react';
import Shortcut from "./Shortcut/Shortcut";

import './Group.css';

function Group(){
  return <div className='group_container'>
      <div className='group_header'>
          <div className='group_title'>Group title</div>
          <div className='btn-group'>
              <button type="button" className="btn btn-dark btn-sm">Add shortcut</button>
              <button type="button" className="btn btn-dark btn-sm">Edit group</button>
          </div>
      </div>
      <div className='group_items'>
          <Shortcut />
          <Shortcut />
          <Shortcut />
          <Shortcut />
          <Shortcut />

      </div>
    </div>;
}

export default Group;