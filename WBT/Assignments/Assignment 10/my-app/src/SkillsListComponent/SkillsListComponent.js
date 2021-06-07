import React from 'react';

const SkillsListComponent = (props) => {
    return(
        <ol>
            {props.children.map((item,i)=>
                <li key={i}>{item}</li>
            )}
        </ol>
    )
};

export default SkillsListComponent;