package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.AdminUserGroup;
import com.dao.IAdminUserGroupDao;

@Service
public class AdminUserGroupServiceImpl extends BaseServiceImpl<AdminUserGroup, IAdminUserGroupDao> implements
		IAdminUserGroupService {
	private static final long serialVersionUID = 1L;
}


