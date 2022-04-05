import React from "react";

import './Dashboard.css'
import SearchBar from "./SearchBar/SearchBar";
import Group from "./Group/Group";
import Settings from "./Settings/Settings";


function Dashboard(){
    return <div className='dashboard_container' style={{backgroundImage: 'url(https://wallpaperaccess.com/download/blue-sunset-art-2190031)'}}>
        <SearchBar/>
        <Group />
        <Group />
        <Group />
        <Settings />
    </div>;
}

export default Dashboard;