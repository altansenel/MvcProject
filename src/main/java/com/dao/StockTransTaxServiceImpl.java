package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.StockTransTax;
import com.dao.IStockTransTaxDao;

@Service
public class StockTransTaxServiceImpl extends BaseServiceImpl<StockTransTax, IStockTransTaxDao> implements
		IStockTransTaxService {
	private static final long serialVersionUID = 1L;
}


