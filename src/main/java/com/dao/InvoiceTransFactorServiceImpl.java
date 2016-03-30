package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.InvoiceTransFactor;
import com.dao.IInvoiceTransFactorDao;

@Service
public class InvoiceTransFactorServiceImpl extends BaseServiceImpl<InvoiceTransFactor, IInvoiceTransFactorDao> implements
		IInvoiceTransFactorService {
	private static final long serialVersionUID = 1L;
}


