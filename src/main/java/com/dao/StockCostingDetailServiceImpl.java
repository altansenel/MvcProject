package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.StockCostingDetail;
import com.dao.IStockCostingDetailDao;

@Service
public class StockCostingDetailServiceImpl extends BaseServiceImpl<StockCostingDetail, IStockCostingDetailDao> implements
		IStockCostingDetailService {
	private static final long serialVersionUID = 1L;
}


