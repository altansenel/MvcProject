package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.StockCostFactor;
import com.dao.IStockCostFactorDao;

@Service
public class StockCostFactorServiceImpl extends BaseServiceImpl<StockCostFactor, IStockCostFactorDao> implements
		IStockCostFactorService {
	private static final long serialVersionUID = 1L;
}


