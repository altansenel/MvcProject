package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.AdminUserAudit;
import com.dao.IAdminUserAuditDao;

@Service
public class AdminUserAuditServiceImpl extends BaseServiceImpl<AdminUserAudit, IAdminUserAuditDao> implements
		IAdminUserAuditService {
	private static final long serialVersionUID = 1L;
}


