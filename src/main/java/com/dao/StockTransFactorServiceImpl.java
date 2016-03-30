package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.StockTransFactor;
import com.dao.IStockTransFactorDao;

@Service
public class StockTransFactorServiceImpl extends BaseServiceImpl<StockTransFactor, IStockTransFactorDao> implements
		IStockTransFactorService {
	private static final long serialVersionUID = 1L;
}


