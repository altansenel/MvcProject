package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.AdminDocument;

@Service("adminDocumentService")
public class AdminDocumentServiceImpl extends BaseServiceImpl<AdminDocument, IAdminDocumentDao> implements
		IAdminDocumentService {
	private static final long serialVersionUID = 1L;
}


