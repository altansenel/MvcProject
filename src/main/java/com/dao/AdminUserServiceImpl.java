package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.AdminUser;
import com.dao.IAdminUserDao;

@Service
public class AdminUserServiceImpl extends BaseServiceImpl<AdminUser, IAdminUserDao> implements
		IAdminUserService {
	private static final long serialVersionUID = 1L;
}


