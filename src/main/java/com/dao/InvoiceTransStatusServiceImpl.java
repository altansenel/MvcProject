package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.InvoiceTransStatus;
import com.dao.IInvoiceTransStatusDao;

@Service
public class InvoiceTransStatusServiceImpl extends BaseServiceImpl<InvoiceTransStatus, IInvoiceTransStatusDao> implements
		IInvoiceTransStatusService {
	private static final long serialVersionUID = 1L;
}


