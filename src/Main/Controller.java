package Main;
import Model.*;
import Persistencia.AdministradorPersistenciaUsuario;

public class Controller {
    private static Controller Sistema;

    public static Controller getInstancia() {
        if(Sistema == null){
            Sistema = new Controller();
        }
        return Sistema;
    }

    public boolean ValidarIngreso(String legajo,String clave){
        Usuario usuario =  AdministradorPersistenciaUsuario.getInstancia().buscarCliente(legajo,clave);
        if(usuario != null)
            return true;
        else
            return false;
    }


}
