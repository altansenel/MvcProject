package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.InvoiceTransCurrency;
import com.dao.IInvoiceTransCurrencyDao;

@Service
public class InvoiceTransCurrencyServiceImpl extends BaseServiceImpl<InvoiceTransCurrency, IInvoiceTransCurrencyDao> implements
		IInvoiceTransCurrencyService {
	private static final long serialVersionUID = 1L;
}


