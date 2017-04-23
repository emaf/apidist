package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.ClienteEntity;
import entity.ItemPrendaEntity;
import entity.MateriaPrimaEntity;
import entity.OrdenDeProduccionEntity;
import entity.PedidoPrendasEntity;
import entity.PrendaEntity;
import entity.SucursalEntity;

 
public class HibernateUtil{
	
    private static final SessionFactory sessionFactory;

    static{
        try{
        	
        	 Configuration config = new Configuration();
        	 config.addAnnotatedClass(ClienteEntity.class);
        	 config.addAnnotatedClass(PedidoPrendasEntity.class);
        	 config.addAnnotatedClass(SucursalEntity.class);
        	 config.addAnnotatedClass(OrdenDeProduccionEntity.class);
        	 config.addAnnotatedClass(ItemPrendaEntity.class);
        	 config.addAnnotatedClass(PrendaEntity.class);
        	 config.addAnnotatedClass(MateriaPrimaEntity.class);
        	 
             sessionFactory = config.buildSessionFactory();
             
        }catch (Throwable ex){
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory(){
    	
        return sessionFactory;
    }
    public static void main(String[] args) {
    	SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
	}

}