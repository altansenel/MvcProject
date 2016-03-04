package com.dao;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Menu;

@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu, IMenuDao> implements IMenuService {

	private static final long serialVersionUID = 1L;
	
	@Override
	@Transactional
	public Menu getMenuByLink(String link) {
		return this.getEntityDAO().getMenuByLink(link);
	}
    
    @Override
    @Transactional
    public List<Menu> listParentMenu() {
        return this.getEntityDAO().listParentMenu();
    }
}

