package com.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.entity.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {
	
	private static final long serialVersionUID = 1L;

	
//	private static final long serialVersionUID = 1L;
//	
//    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
//    
//    private SessionFactory sessionFactory;
//     
//    public void setSessionFactory(SessionFactory sf){
//        this.sessionFactory = sf;
//    }
// 
//    @Override
//    public Long addUser(User p) {
//        Session session = this.sessionFactory.getCurrentSession();
//        session.persist(p);
//        logger.info("User saved successfully, User Details="+p);
//        return p.getId();
//    }
//
//    @Override
//    public void updateUser(User p) {
//        Session session = this.sessionFactory.getCurrentSession();
//        session.merge(p);
//        logger.info("User updated successfully, User Details="+p);
//    }
// 
//    @SuppressWarnings("unchecked")
//    @Override
//    public List<User> listUser() {
//        Session session = this.sessionFactory.getCurrentSession();
//        List<User> UserList = session.createQuery("from User").list();
//        //.setCacheable(true)
//        for(User p : UserList){
//            logger.info("User List::"+p);
//        }
//        return UserList;
//    }
//    
//    
//    @SuppressWarnings("unchecked")
//    public List<User> listUser(User user) {    	
//    	Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(User.class);
//    	if(user.getUsername()!=null && !user.getUsername().isEmpty()){
//    		criteria.add(Restrictions.ilike("username",
//    				user.getUsername(), MatchMode.ANYWHERE));
//    	}
//
//    	List<User> userList = criteria.list();
//        for(User p : userList){
//            logger.info("Person List::"+p);
//        }
//        return userList;
//    }
//    
// 
//    @SuppressWarnings("unchecked")
//	@Override
//    public User getUserById(Long id) {
//        Session session = this.sessionFactory.getCurrentSession();      
//        //User p = (User) session.get(User.class, new Long(id));
//        List<User> UserList = session.createQuery("from User where id=:id").setParameter("id", id).list();
//        
//        //load metodunda aşağıdaki kullanılır
////        if (p instanceof HibernateProxy) {
////            p = (User) ((HibernateProxy) p).getHibernateLazyInitializer()
////                    .getImplementation();
////        }
//        logger.info("User loaded successfully, User details="+UserList.get(0));
//        //Hibernate.initialize(UserList.get(0).getRoleUserList());
//        
//        return UserList.get(0);
//    }
    
	//@Secured("hasRole('ROLE_BASKA')")
//	@Secured("ROLE_BASKA")
    @Override
    public User getUserByUsername(String username) {
        Session session = this.getSessionFactory().getCurrentSession();      
        User p = (User) session.createQuery("from User where username=:username").setParameter("username", username).uniqueResult();
        getLogger().info("User loaded successfully, User details="+p);
        return p;
    }
 
    
//    @Override
//    public void removeUser(Long id) {
//        Session session = this.sessionFactory.getCurrentSession();
//        User p = (User) session.load(User.class, new Long(id));
//        if(null != p){
//            session.delete(p);
//        }
//        logger.info("User deleted successfully, User details="+p);
//    }

}
