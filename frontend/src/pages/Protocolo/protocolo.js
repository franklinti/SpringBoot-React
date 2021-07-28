import logo from '../../assets/2.jpg';
import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import '../Protocolo/protocolo.css';

function Cad_Protocolo() {
  const [codigo, setCodigo] = useState('');
  const [dataP, setDataP] = useState('');
  const [textoP, setTexto] = useState('');
  const [usuario, setUsuario] = useState([]);

  function registrar(e) {
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var raw = JSON.stringify({
        "codigo": codigo,
        "dataP": dataP,
        "textoP": textoP,
        "usuario":usuario
    });

    var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
    };

    fetch("http://localhost:7000/api/v1/protocolo", requestOptions)
        .then(response => response.json())
        .then(response => {
            if (response === "existe_codigo") {
                alert("Codigo ja cadastrado!")
            } else {
                alert("Protocolo com sucesso")
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
                <h1>Protocolo</h1>
                <input type="text" placeholder="codigo" value={codigo} onChange={(e) => setCodigo(e.target.value)} />
                <input type="text" placeholder="texto" value={textoP} onChange={(e) => setTexto(e.target.value)} />
                <input type="text" placeholder="usuario" value={usuario} onChange={(e) => setUsuario(e.target.value)} />
                <input type="date" placeholder="01/01/2021" value={dataP} onChange={(e) => setDataP(e.target.value)} />
            
                <br></br>
                <button type="submit">Cadastrar</button>
            </form>
            <Link to="/">Voltar</Link>
        </div>
    </div>
);
}

export default Cad_Protocolo;