package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.SaleSeller;
import com.dao.ISaleSellerDao;

@Service
public class SaleSellerServiceImpl extends BaseServiceImpl<SaleSeller, ISaleSellerDao> implements
		ISaleSellerService {
	private static final long serialVersionUID = 1L;
}


