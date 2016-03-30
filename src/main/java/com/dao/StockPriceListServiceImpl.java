package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.StockPriceList;
import com.dao.IStockPriceListDao;

@Service
public class StockPriceListServiceImpl extends BaseServiceImpl<StockPriceList, IStockPriceListDao> implements
		IStockPriceListService {
	private static final long serialVersionUID = 1L;
}


