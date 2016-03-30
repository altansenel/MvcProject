package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.StockCosting;
import com.dao.IStockCostingDao;

@Service
public class StockCostingServiceImpl extends BaseServiceImpl<StockCosting, IStockCostingDao> implements
		IStockCostingService {
	private static final long serialVersionUID = 1L;
}


