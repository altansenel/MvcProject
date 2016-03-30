package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.InvoiceTransTax;
import com.dao.IInvoiceTransTaxDao;

@Service
public class InvoiceTransTaxServiceImpl extends BaseServiceImpl<InvoiceTransTax, IInvoiceTransTaxDao> implements
		IInvoiceTransTaxService {
	private static final long serialVersionUID = 1L;
}


