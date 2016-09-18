package Persistencia;

import Model.Usuario;
import Model.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdministradorPersistenciaUsuario {
    private static AdministradorPersistenciaUsuario pool;

    private AdministradorPersistenciaUsuario() {
    }

    public static AdministradorPersistenciaUsuario getInstancia() {
        if (pool == null)
            pool = new AdministradorPersistenciaUsuario();
        return pool;
    }

    public Usuario buscarCliente(String legajo,String clave){
        Connection con = PoolConnection.getPoolConnection().getConnection();
        Usuario usuario = new Usuario();
        try
        {
            String query = "select * from Roles r INNER JOIN Usuarios_Roles ur on r.Id = ur.role_id Inner Join " +
                    "Usuarios u on u.Id = ur.usuario_id where legajo = ? and clave = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, legajo);
            ps.setString(2, clave);
            ResultSet result = ps.executeQuery();

            if (result.isBeforeFirst()){
                usuario.setLegajo(legajo);
                usuario.setClave(clave);
                ArrayList<Role> roles = new ArrayList<Role>();
                while (result.next()){
                    roles.add(new Role(result.getString("nombreRole")));
                }
                usuario.setRoles(roles);
            }
            else
                usuario = null;

        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            PoolConnection.getPoolConnection().realeaseConnection(con);
            return usuario;
        }
    }
}
