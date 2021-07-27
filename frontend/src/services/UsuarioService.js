import axios from 'axios'

const USERS_REST_API_URL="/api/v1/";

class UsuarioService{
    getUsuario(){
        axios.get(USERS_REST_API_URL);
    }
}
export default new UsuarioService();