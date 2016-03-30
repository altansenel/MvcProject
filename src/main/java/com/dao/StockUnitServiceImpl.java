package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.StockUnit;
import com.dao.IStockUnitDao;

@Service
public class StockUnitServiceImpl extends BaseServiceImpl<StockUnit, IStockUnitDao> implements
		IStockUnitService {
	private static final long serialVersionUID = 1L;
}


