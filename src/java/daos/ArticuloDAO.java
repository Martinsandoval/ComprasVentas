package daos;

import javax.persistence.EntityManager;
import model.Articulos;

public class ArticuloDAO extends AbstractDAO<Articulos>{

    public ArticuloDAO(Class classType) {
        super(classType);
    }

    @Override
    protected EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
