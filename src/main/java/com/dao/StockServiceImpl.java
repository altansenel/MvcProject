package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.Stock;
import com.dao.IStockDao;

@Service
public class StockServiceImpl extends BaseServiceImpl<Stock, IStockDao> implements
		IStockService {
	private static final long serialVersionUID = 1L;
}


