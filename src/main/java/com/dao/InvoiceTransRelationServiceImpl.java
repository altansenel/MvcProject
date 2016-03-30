package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.InvoiceTransRelation;
import com.dao.IInvoiceTransRelationDao;

@Service
public class InvoiceTransRelationServiceImpl extends BaseServiceImpl<InvoiceTransRelation, IInvoiceTransRelationDao> implements
		IInvoiceTransRelationService {
	private static final long serialVersionUID = 1L;
}


