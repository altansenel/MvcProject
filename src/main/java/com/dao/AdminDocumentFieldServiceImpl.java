package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.AdminDocumentField;
import com.dao.IAdminDocumentFieldDao;

@Service
public class AdminDocumentFieldServiceImpl extends BaseServiceImpl<AdminDocumentField, IAdminDocumentFieldDao> implements
		IAdminDocumentFieldService {
	private static final long serialVersionUID = 1L;
}


