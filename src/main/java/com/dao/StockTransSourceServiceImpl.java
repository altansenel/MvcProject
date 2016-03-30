package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.StockTransSource;
import com.dao.IStockTransSourceDao;

@Service
public class StockTransSourceServiceImpl extends BaseServiceImpl<StockTransSource, IStockTransSourceDao> implements
		IStockTransSourceService {
	private static final long serialVersionUID = 1L;
}


