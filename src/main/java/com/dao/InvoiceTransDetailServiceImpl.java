package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.InvoiceTransDetail;
import com.dao.IInvoiceTransDetailDao;

@Service
public class InvoiceTransDetailServiceImpl extends BaseServiceImpl<InvoiceTransDetail, IInvoiceTransDetailDao> implements
		IInvoiceTransDetailService {
	private static final long serialVersionUID = 1L;
}


