package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.StockPriceUpdate;
import com.dao.IStockPriceUpdateDao;

@Service
public class StockPriceUpdateServiceImpl extends BaseServiceImpl<StockPriceUpdate, IStockPriceUpdateDao> implements
		IStockPriceUpdateService {
	private static final long serialVersionUID = 1L;
}


