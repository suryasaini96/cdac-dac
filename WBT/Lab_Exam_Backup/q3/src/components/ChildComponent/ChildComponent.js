import React, { Component } from 'react';

class ChildComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            num1: '',
            num2: '',
            result: ''
        };
    }
    setNum1 = (event) => {
        this.setState({num1: event.target.value});
    }
    setNum2 = (event) => {
        this.setState({num2: event.target.value});
    }
    add = () => {
        this.setState({result: "Sum is: " + (Number(this.state.num1) + Number(this.state.num2))});
    }
    render() {
        return (
            <div>
                Number1: <input type="text" id="num1" onBlur={this.setNum1}/><br/>
                Number2: <input type="text" id="num2" onBlur={this.setNum2}/><br/>
                <button onClick={this.add}>Add</button><br/><br/>
                <span>{this.state.result}</span>
            </div>
        )
    }

}
export default ChildComponent;