package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.InvoiceTransSource;
import com.dao.IInvoiceTransSourceDao;

@Service
public class InvoiceTransSourceServiceImpl extends BaseServiceImpl<InvoiceTransSource, IInvoiceTransSourceDao> implements
		IInvoiceTransSourceService {
	private static final long serialVersionUID = 1L;
}


