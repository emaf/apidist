package dao;

import java.util.ArrayList;

import org.hibernate.Session;

import dto.MateriaPrimaDto;
import entity.MateriaPrimaEntity;
import entity.MovimientoMateriaPrimaEntity;
import hibernate.HibernateUtil;
import negocio.MateriaPrima;
import negocio.MovimientoMateriaPrima;

public class MateriaPrimaDao {
	private static MateriaPrimaDao instance;
	
	private MateriaPrimaDao() {}
	
	public static MateriaPrimaDao getInstance() {
		if (instance == null)
			instance = new MateriaPrimaDao();
		
		return instance;
	}
	
	
	public void crearMovimiento (MovimientoMateriaPrima movimiento) {
		
		MovimientoMateriaPrimaEntity movimientoEntity = new MovimientoMateriaPrimaEntity(movimiento);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		session.save(movimientoEntity);
		session.getTransaction().commit();
		session.close();
	}
	
	public MateriaPrima getById (MateriaPrimaDto materiaPrimaDto) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		MateriaPrimaEntity materiaPrimaEntity = (MateriaPrimaEntity)session.get(MateriaPrimaEntity.class, materiaPrimaDto.getCodigo());
		session.getTransaction().commit();
		session.close();
		
		if (materiaPrimaEntity == null)
			return null;
		
		return new MateriaPrima(materiaPrimaEntity);
	}
	
	public ArrayList<MateriaPrima> getMateriasPrimas () {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		ArrayList<MateriaPrimaEntity> materiasPrimasEntity = (ArrayList<MateriaPrimaEntity>) session.createQuery("from MateriaPrimaEntity").list();
		session.close();
		
		if (materiasPrimasEntity == null)
			return null;
		
		ArrayList<MateriaPrima> materiasPrima = new ArrayList<MateriaPrima>();
		
		for (MateriaPrimaEntity materiaPrimasEntity : materiasPrimasEntity) {
			materiasPrima.add(new MateriaPrima(materiaPrimasEntity));
		}
		
		return materiasPrima;
	}
}
