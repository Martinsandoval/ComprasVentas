/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Usuarios;

/**
 *
 * @author marti
 */
public class UsuarioDAO extends AbstractDAO<Usuarios>{

    public UsuarioDAO() {
        super(Usuarios.class);
    }

  @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Usuarios> getAll() {
        Query query = em.createNamedQuery("Usuarios.findAll");
        List<Usuarios> usuario = query.getResultList();
        return usuario;

    }

    public boolean login(String user, String pass) {
       // User usuario = new User();
       // usuario.setUsername(user);
       // usuario.setPassword(pass);
        Query query = em.createNamedQuery("Usuarios.findByUsuarioAndContrasenia");
        query.setParameter("usuario", user);
        query.setParameter("contrasenia", pass);
        List<Usuarios> usuarios = query.getResultList();
        return !usuarios.isEmpty();

    }
    
}
