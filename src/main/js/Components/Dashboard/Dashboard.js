import React, {useEffect, useState} from "react";

import "core-js";
import "regenerator-runtime/runtime";

import './Dashboard.css'
import SearchBar from "./SearchBar/SearchBar";
import Group from "./Group/Group";
import {getGroups} from "../../Services/GroupService";
import NewGroupModal from "./Modals/NewGroupModal";


function Dashboard(){

    const [groupsProp, setGroupsProp] = React.useState([]);

    const [showAddGroup, setShowAddGroup,] = useState(false);

    const handleShowAddGroup = () => setShowAddGroup(true);


    const reloadGroups = () => {
        getGroups().then(groups => {
            let groupsArray = [];
            for (let i = 0; i < groups.length; i++) {
                groupsArray.push(<Group key={"group"+groups[i].groupId}
                                        groupId={groups[i].groupId}
                                        shortcuts={groups[i].shortcuts}
                                        groupName={groups[i].name}
                                        reloadGroups={reloadGroups}/>);
            }
            setGroupsProp(groupsArray);
        });
    };

    useEffect(() => {
        reloadGroups();
    }, []);


    return <div id='dashboard_container'>
        <div className='test'>
            <div className='background_container'></div>
        </div>
        <SearchBar/>
        <button className='btn btn-dark shadow-sm' onClick={handleShowAddGroup}>
            New group
        </button>
        <NewGroupModal reloadGroups={reloadGroups} show={showAddGroup} setShow={setShowAddGroup}/>
        {groupsProp}
    </div>;
}

export default Dashboard;