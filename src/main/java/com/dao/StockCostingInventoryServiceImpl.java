package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.StockCostingInventory;
import com.dao.IStockCostingInventoryDao;

@Service
public class StockCostingInventoryServiceImpl extends BaseServiceImpl<StockCostingInventory, IStockCostingInventoryDao> implements
		IStockCostingInventoryService {
	private static final long serialVersionUID = 1L;
}


