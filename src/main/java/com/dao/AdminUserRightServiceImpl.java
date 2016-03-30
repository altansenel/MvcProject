package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.AdminUserRight;
import com.dao.IAdminUserRightDao;

@Service
public class AdminUserRightServiceImpl extends BaseServiceImpl<AdminUserRight, IAdminUserRightDao> implements
		IAdminUserRightService {
	private static final long serialVersionUID = 1L;
}


