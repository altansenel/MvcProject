package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.AdminExtraFields;
import com.dao.IAdminExtraFieldsDao;

@Service
public class AdminExtraFieldsServiceImpl extends BaseServiceImpl<AdminExtraFields, IAdminExtraFieldsDao> implements
		IAdminExtraFieldsService {
	private static final long serialVersionUID = 1L;
}


