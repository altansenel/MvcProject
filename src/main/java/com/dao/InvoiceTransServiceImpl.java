package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.InvoiceTrans;
import com.dao.IInvoiceTransDao;

@Service
public class InvoiceTransServiceImpl extends BaseServiceImpl<InvoiceTrans, IInvoiceTransDao> implements
		IInvoiceTransService {
	private static final long serialVersionUID = 1L;
}


