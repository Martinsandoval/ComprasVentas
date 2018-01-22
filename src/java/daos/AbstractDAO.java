package daos;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
 
public abstract class  AbstractDAO <T> {
    
   @PersistenceContext(name="SistemaComprasVentasPU") 
   protected  EntityManager em;
   final Class<T> entityClass;
 
    public AbstractDAO(Class classType) {
        this.entityClass = classType;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        
        em.persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T t) {
       em.remove( em.merge(t));
    }

    public T buscar(int id) {
        return em.find(entityClass, id);
    }
    
    

}

