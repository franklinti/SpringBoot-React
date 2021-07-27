import React from 'react';
import UsuarioService from '../services/UsuarioService';

class UsuarioComponent extends React.Component{

    constructor(props){
        super(props)
        this.state = {
            usuarios:[]
        }
        this.changeState = this.changeState.bind
    }
    changeState(){
        UsuarioService.getUsuario().then((response) => {
           this.setState({usuarios:response.data}) 
        });
    }
    render(){
        return(
            <div>
                <table>
                    <thead>
                        <tr>
                            <td>id</td>
                            <td>Nome</td>
                        </tr>
                        <tbody>
                        { 
                            this.state.usuarios.push((u) =>
                            <tr >
                                <td >key= {u.id}</td>
                                <td >{u.nome}</td>
                            </tr>
                            
                    
                             )
                         }
                        </tbody>
                    </thead>
                </table>
               
            </div>
        )
    }
}
export default UsuarioComponent 