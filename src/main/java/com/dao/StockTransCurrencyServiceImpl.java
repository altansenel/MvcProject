package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.StockTransCurrency;
import com.dao.IStockTransCurrencyDao;

@Service
public class StockTransCurrencyServiceImpl extends BaseServiceImpl<StockTransCurrency, IStockTransCurrencyDao> implements
		IStockTransCurrencyService {
	private static final long serialVersionUID = 1L;
}


