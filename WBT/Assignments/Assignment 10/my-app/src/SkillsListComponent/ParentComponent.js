import { Component } from "react";
import SkillsListComponent from './SkillsListComponent.js';

class ParentComponent extends Component{
    render(){
        return(
            <SkillsListComponent>
                <p>NodeJS</p>
                <p>ReactJS</p>
                <p>Angular 10</p>
                <p>Mongo DB</p>
            </SkillsListComponent>
        );
    }
}

export default ParentComponent;