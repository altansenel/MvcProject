package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.entity.Menu;

@Repository
public class MenuDaoImpl extends BaseDaoImpl<Menu> implements IMenuDao {
	
	private static final long serialVersionUID = 1L;
	
    @Override
    public Menu getMenuByLink(String link) {
        Session session = this.getSessionFactory().getCurrentSession();      
        Menu p = (Menu) session.createQuery("from Menu where link=:link").setParameter("link", link).uniqueResult();
        getLogger().info("Menu loaded successfully, Menu details="+p);
        return p;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Menu> listParentMenu() {
        Criteria criteria = this.getSessionFactory().getCurrentSession().createCriteria(Menu.class);
        criteria.add(Restrictions.isNull("link"));
        criteria.addOrder(Order.asc("id"));
        List<Menu> menuList = criteria.list();
        for(Menu p : menuList){
        	getLogger().info("Menu List::"+p);
        }
        return menuList;
    }

}
    
    

