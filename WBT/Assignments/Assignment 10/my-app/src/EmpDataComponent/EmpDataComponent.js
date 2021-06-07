import React, { Component } from 'react';
import './EmpDataComponent.css';

class EmpDataComponent extends Component{    
    state = {
        emp: [
            {
                id: 1001,
                name: 'Anita',
                salary: 30000
            },
            {
                id: 1002,
                name: 'Shyam',
                salary: 50000
            },
            {
                id: 1003,
                name: 'Ghanshayam',
                salary: 60000
            }
        ]
    };
    
    render(){
        let rows = this.state.emp.map((e,i)=>
            <tr key={"row"+i}>
                <td>{e.id}</td>
                <td>{e.name}</td>
                <td>{e.salary}</td>
            </tr>
        );

        return(
            <div>
                <h3>Employee Data</h3>
                <table>
                    <thead></thead>
                    <tbody>{rows}</tbody>
                </table>    
            </div>
        );
    }
}

export default EmpDataComponent;