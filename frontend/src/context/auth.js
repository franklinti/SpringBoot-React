import{useState,createContext,useEffect} from 'react';

export const AuthContext = createContext({});

function AuthProvider({children}){
    const[usuario,setUsuario] = useState(null);
    const[loadingAuth, setLoadingAuth]= useState(false);
    const [loading,setLoading] = useState(true);


    useEffect(()=>{

        function loadStorage(){
            const storageUser = localStorage.getItem('testeUser');
            if(storageUser){
                setUsuario(JSON.parse(storageUser));
                setLoading(false);
            }
            setLoading(false);
        }
        loadStorage();
        
    },[])
    return(
        <AuthContext.Provider value={{signed: !! usuario,usuario,loading}}>
            {children}
        </AuthContext.Provider>
    )
}
export default AuthProvider;