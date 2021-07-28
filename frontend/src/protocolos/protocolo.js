import logo from '../assets/cagece.jpg';
import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import '../protocolo/protocolo.css';

function Cad_Protocolo() {
  const [codigo, setCodigo] = useState('');
  const [dataP, setDataProto] = useState('');
  const [textoP, setTexto] = useState('');
  const [usuario, setUsuario] = useState([]);

  function registrar(e) {
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var raw = JSON.stringify({
        "codigo": codigo,
        "dataProto": dataP,
        "textoProto": textoP,
        "usuario":usuario
    });

    var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
    };

    fetch("http://localhost:8080/api/v1/protocolo", requestOptions)
        .then(response => response.json())
        .then(response => {
            if (response == "existe_codigo") {
                alert("Codigo ja cadastrado!")
            } else {
                alert("Protocolo com sucesso")
            }
        })
        .then(result => console.log(result))
        .catch(error => console.log('error', error));
}
  return (
    <div className="container-center">
        <div className="login">
            <div className="login-area">
                <img src={logo} alt="logomarca" />
            </div>
            <form onSubmit={registrar}>
                <h1>Atendimentos</h1>
                <input type="text" placeholder="codigo" value={codigo} onChange={(e) => setCodigo(e.target.value)} />
                <input type="text" placeholder="texto" value={textoP} onChange={(e) => setTexto(e.target.value)} />
                <input type="text" placeholder="texto" value={usuario} onChange={(e) => setUsuario(e.target.value)} />
                <input type="date" placeholder="01/01/2021" value={dataP} onChange={(e) => setDataProto(e.target.value)} />
                <label>Estados: 
                <select id="lista-estados">
                </select>
                </label>
                <br></br>
                <button type="submit">Cadastrar</button>
            </form>
            <Link to="/">Voltar</Link>
        </div>
    </div>
);
}

export default Cad_Protocolo;