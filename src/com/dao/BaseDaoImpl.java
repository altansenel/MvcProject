package com.dao;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.MappedSuperclass;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.entity.BaseEntity;

@MappedSuperclass
@Repository
public abstract class BaseDaoImpl<E extends BaseEntity> implements IBaseDao<E>,
		Serializable {

	private static final long serialVersionUID = 1L;
	protected static final String DOT = "\\.";

	private static final Logger logger = LoggerFactory.getLogger(BaseDaoImpl.class);
	

//    @Autowired(required=true)
//    @Qualifier(value="hibernate4AnnotatedSessionFactory")
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
        setEntityClass(((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]));
    }
	
	private SessionFactory sessionFactory;

	public static Logger getLogger() {
		return logger;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	protected BaseDaoImpl() {
//		setEntityClass(((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]));
//		if (FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance()) != null) {
//			ApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
//			setSessionFactory((SessionFactory)ctx.getBean("hibernate4AnnotatedSessionFactory"));
//		}
//	}

	public Class<E> entityClass;

	public Class<E> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<E> entityClass) {
		this.entityClass = entityClass;
	}


	@Override
	public Long add(E p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Entity saved successfully, Details=" + p);
		return p.getId();
	}

	@Override
	public void update(E p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(p);
		logger.info("Entity updated successfully, Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> list() {
		Session session = this.sessionFactory.getCurrentSession();
		List<E> UserList = session.createQuery(
				"from " + getEntityClass().getName().split(DOT)[getEntityClass().getName().split(DOT).length-1])
				.list();
		for (E p : UserList) {
			logger.info("User List::" + p);
		}
		return UserList;
	}

	@SuppressWarnings("unchecked")
	// burada complex tipleri de düşün önceden yapmıştım benzerini
	public List<E> list(E entity) {
		Criteria criteria = this.sessionFactory.getCurrentSession()
				.createCriteria(getEntityClass());
		Field[] fieldArray = getEntityClass().getDeclaredFields();
		for (Field f : fieldArray) {
			if (!f.getName().equals("serialVersionUID") && !f.getType().equals(List.class)) {
				if (f.getType().equals(String.class)){
					if (get(entity, f.getName()) != null
							&& !get(entity, f.getName()).equals("")) {
						criteria.add(Restrictions.ilike(f.getName(),
								get(entity, f.getName()).toString(),
								MatchMode.ANYWHERE));
					}
				} else if (f.getType().equals(Integer.class)) {
					if (get(entity, f.getName()) != null) {
						criteria.add(Restrictions.eq("this." + f.getName(), ((Integer)(get(entity, f.getName())))));
					}
				} else if (f.getType().equals(Long.class)) {
					if (get(entity, f.getName()) != null) {
						criteria.add(Restrictions.eq("this." +f.getName(), ((Long)(get(entity, f.getName())))));
					}
				} else if (f.getType().equals(BigDecimal.class)) {
					if (get(entity, f.getName()) != null) {
						criteria.add(Restrictions.eq("this." +f.getName(), ((BigDecimal)
								(get(entity, f.getName())))));
					}
				} else if (f.getType().equals(Boolean.class)) {
					if (get(entity, f.getName()) != null) {
						criteria.add(Restrictions.eq("this." +f.getName(), ((Boolean)(get(entity, f.getName())))));
					}
				} else if (f.getType().equals(Date.class)) {
					if (get(entity, f.getName()) != null && (f.getName().substring(0,3).equals("ilk")||f.getName().substring(0,3).equals("son"))) {
						if(f.getName().substring(0,3).equals("ilk")){
							criteria.add(Restrictions.ge("this." +f.getName().substring(3).substring(0,1).toLowerCase() +f.getName().substring(3).substring(1), ((Date)
									(get(entity, f.getName())))));
						}else if(f.getName().substring(0,3).equals("son")){
							criteria.add(Restrictions.le("this." +f.getName().substring(3).substring(0,1).toLowerCase() +f.getName().substring(3).substring(1), ((Date)
									(get(entity, f.getName())))));
						}
					}else if(get(entity, f.getName()) != null){
						criteria.add(Restrictions.eq("this." +f.getName(), ((Date)
								(get(entity, f.getName())))));
					}
				} else {
					if (get(entity, f.getName()) != null) {
						criteria.add(Restrictions.eq("this." +f.getName(), (
								get(entity, f.getName()))));
					}
				}
			}
		}

		List<E> entityList = criteria.list();
		for (E obj : entityList) {
			logger.info("Person List::" + obj);
		}
		return entityList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E getEntityById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<E> entityList = session
				.createQuery(
						"from "
								+ getEntityClass().getName().split(DOT)[getEntityClass().getName().split(DOT).length-1]
								+ " where id=:id").setParameter("id", id)
				.list();
		if (!entityList.isEmpty()) {
			logger.info("Entity loaded successfully, details=" + entityList.get(0));
			return entityList.get(0);
		} else {
			return null;
		}

	}

	@Override
	public void remove(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		E entity = (E) session.load(getEntityClass(), new Long(id));
		if (null != entity) {
			session.delete(entity);
		}
		logger.info("Entity deleted successfully, Entity details=" + entity);
	}


	@SuppressWarnings("unchecked")
	public <T> T get(Object object, String fieldName) {
		Class<?> clazz = object.getClass();
		while (clazz != null) {
			try {
				Field field = clazz.getDeclaredField(fieldName);
				field.setAccessible(true);
				return (T) field.get(object);
			} catch (NoSuchFieldException e) {
				clazz = clazz.getSuperclass();
			} catch (Exception e) {
				throw new IllegalStateException(e);
			}
		}
		return null;
	}

}
