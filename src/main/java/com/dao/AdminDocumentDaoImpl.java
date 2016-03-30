package  com.dao;


import org.springframework.stereotype.Repository;

import com.entity.AdminDocument;


@Repository("adminDocumentDao")
public class AdminDocumentDaoImpl extends BaseDaoImpl<AdminDocument> implements IAdminDocumentDao {
	private static final long serialVersionUID = 1L;
}

