import React, { Component } from 'react';
import './NewsContent.css';

class NewsContent extends Component{
    state = {
        news: [
            {
                title: "Google Agrees To Alter Ad Practices After France Imposes Fine",
                content: "Alphabet's Google agreed to make changes to some of its widely-used online advertising services under an unprecedented settlement with France's antitrust watchdog released on Monday."
            },
            {
                title: "2 Farmers Make Bail, Call Of Sit-In Protest At Haryana Police Stations Called Off",
                content: "The Samyukt Kisan Morcha called off a plan to hold protests at 'all' police stations in Haryana after the release of two arrested farmers on bail Monday but said a sit-in at Tohana will continue since another man is still behind bars."
            },
            {
                title: "Flipkart In Talks To Raise $3 Billion From Ex-Stakeholder SoftBank, Wealth Funds",
                content: "Flipkart plans to raise the additional capital ahead of an initial public offering, now planned for next year, the people said."
            }
        ]
    }

    render(){
        var items = [];
        for (var i=0; i<this.state.news.length; i++){
            items.push(
                <div key={i} className="article">
                    <img src={`./images/${i+1}.jpg`}></img>
                    <h4>{this.state.news[i].title}</h4>
                    <p>{this.state.news[i].content}</p>
                </div>
            );
        }
        return(items);
    }
}

export default NewsContent;