import { Component } from 'react';
import './App.css';
import EmpDataComponent from './EmpDataComponent/EmpDataComponent';
import ParentComponent from './SkillsListComponent/ParentComponent.js'
import ToDoComponent from './ToDoComponent/ToDoComponent.js'

function App() {
  return (
    <div className="App">
        <EmpDataComponent />
        <ParentComponent />
        <ToDoComponent/>
    </div>
  );
}

// class App extends Component{
  
//   render(){
//     return(
//       <div>
//           <ToDoComponent/>
//       </div>
//     )
//   }
// }

export default App;
