package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.StockDepot;
import com.dao.IStockDepotDao;

@Service
public class StockDepotServiceImpl extends BaseServiceImpl<StockDepot, IStockDepotDao> implements
		IStockDepotService {
	private static final long serialVersionUID = 1L;
}


