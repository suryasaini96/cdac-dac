import React, { Component } from 'react';
import './NewsHeader.css';

class NewsHeader extends Component{
    render(){
        return(
            <div className="Title">
                <h3>Latest News</h3>
                <hr></hr>
            </div>
        );
    }
}

export default NewsHeader;
