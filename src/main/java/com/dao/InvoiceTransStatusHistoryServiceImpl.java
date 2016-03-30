package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.InvoiceTransStatusHistory;
import com.dao.IInvoiceTransStatusHistoryDao;

@Service
public class InvoiceTransStatusHistoryServiceImpl extends BaseServiceImpl<InvoiceTransStatusHistory, IInvoiceTransStatusHistoryDao> implements
		IInvoiceTransStatusHistoryService {
	private static final long serialVersionUID = 1L;
}


