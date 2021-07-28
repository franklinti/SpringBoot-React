import logo from '../../assets/2.jpg';
import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import '../../pages/SignUp/signup.css';

function SignUp() {
  const [nome, setNome] = useState('');
  const [sobrenome, setSobrenome] = useState('');
  const [email, setEmail] = useState('');
  const [userNome, setUsernome] = useState('');
  const [senha, setSenha] = useState('');
  
  function registrar(e) {
        var myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");
    
        var raw = JSON.stringify({
            "nome": nome,
            "sobrenome":sobrenome,
            "email": email,
            "userNome": userNome,
            "senha":senha,
        });
    
        var requestOptions = {
            method: 'POST',
            headers: myHeaders,
            body: raw,
            redirect: 'follow'
        };
    
        fetch("http://localhost:7000/api/v1/usuario", requestOptions)
            .then(response => response.json())
            .then(response => {
                if (response === "existe") {
                    alert('email ja cadastrado!')
                } else {
                    alert('Cadastrado com sucesso')
                }
            })
      
}
  return (
    <div className="container-center">
        <div className="login">
            <div className="login-area">
                <img src={logo} alt="logomarca" />
            </div>
            <form onSubmit={registrar}>
                <h1>Cadastro Usuario</h1>
                <input type="text" placeholder="Nome"  value={nome} onChange={(e) => setNome(e.target.value)} />
                <input type="text" placeholder="Sobrenome" value={sobrenome}  onChange={(e) => setSobrenome(e.target.value)} />
                <input type="text" placeholder="email" value={email} onChange={(e) => setEmail(e.target.value)} />
                <input type="text" placeholder="Nome Usuario" value={userNome} onChange={(e) => setUsernome(e.target.value)} />
                <input type="text" placeholder="senha" value={senha} onChange={(e) => setSenha(e.target.value)} />
               
                <button type="submit">Cadastrar</button>
            </form>
            <Link to="/">Ja possui conta? Entre.</Link>
        </div>
    </div>
);
}

export default SignUp;