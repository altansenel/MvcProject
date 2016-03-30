package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.AdminWorkspace;
import com.dao.IAdminWorkspaceDao;

@Service
public class AdminWorkspaceServiceImpl extends BaseServiceImpl<AdminWorkspace, IAdminWorkspaceDao> implements
		IAdminWorkspaceService {
	private static final long serialVersionUID = 1L;
}


