package  com.dao;


import org.springframework.stereotype.Repository;

import com.entity.AdminUser;


@Repository
public class AdminUserDaoImpl extends BaseDaoImpl<AdminUser> implements IAdminUserDao {
	private static final long serialVersionUID = 1L;
}

