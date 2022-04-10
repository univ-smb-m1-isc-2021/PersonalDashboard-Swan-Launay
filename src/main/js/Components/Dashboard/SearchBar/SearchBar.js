import React from 'react';

import './SearchBar.css';

function SearchBar(){
    return <div className="search_bar">
      <input type="text" className='form-control-lg' placeholder="Search" />
    </div>;
}

export default SearchBar;