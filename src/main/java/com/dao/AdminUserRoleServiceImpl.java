package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.AdminUserRole;
import com.dao.IAdminUserRoleDao;

@Service
public class AdminUserRoleServiceImpl extends BaseServiceImpl<AdminUserRole, IAdminUserRoleDao> implements
		IAdminUserRoleService {
	private static final long serialVersionUID = 1L;
}


