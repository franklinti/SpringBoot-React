import { useContext } from 'react';
import {Route,Redirect} from 'react-router-dom';
import {AuthContext} from '../context/auth';

export default function RotasWrapper({
  
    component : Component,
    isPrivate,
    ...rest
}){

    const{signed,loading} = useContext(AuthContext);
   // const signed = true;
  //  const loading = false;
    
    if(loading){
        return(
            <div>Carregando..</div>
        )
    }
    if(!signed && isPrivate){
        return <Redirect to="/"/>
    }
    if(signed && !isPrivate){
        return <Redirect to="/dashboard"/>
    }
    return(
        <Route
        {...rest}
        render={props =>(
            <Component{...props}/>
        )}
        />
    )
}