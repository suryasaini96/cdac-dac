import React, { Component } from 'react';
import './ToDoComponent.css';

class ToDoComponent extends Component{
    state = {
        text:"",
        list:[]
    }
    addItemHandler = ()=> {
        //e.preventDefault()  -- optional: used to prevent Form reset if we used form tag before input
        //console.log(this.state.text)
        if (this.state.text !== ""){
            this.setState({
                list: this.state.list.concat([this.state.text])
                // OR
                // list: [...this.state.list, this.state.text]
            })
        }
    }
    deleteItemHandler = (event)=>{
        console.log(event);
        this.setState({
                text: "",
                list: this.state.list.filter((ele)=>ele!==event.target.innerHTML)
        });
    }

    inputChangeHandler = (inp) => {
        this.state.text = inp.target.value;
    }

    render() {
        return(
            <div>
                <h3>TODO LIST</h3>
                <hr></hr>
                <input type="text" name="item" placeholder="add item..." onChange={this.inputChangeHandler}/>
                <input type="button" value="ADD" onClick={this.addItemHandler}></input>
                <ol>
                    {this.state.list.map(item => <li key={Math.random()} onClick={this.deleteItemHandler}>{item}</li>)}
                </ol>
                {   
                    // Method 2
                    //<List data={this.state.list}/>
                }
            </div>
        )
    }
}

// Method 2

// const List = (props) => {
//     return(<ol>{props.data.map(e => <li>{e}</li>)}</ol>)
// }    

export default ToDoComponent;