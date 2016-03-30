package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.StockPriceUpdateDetail;
import com.dao.IStockPriceUpdateDetailDao;

@Service
public class StockPriceUpdateDetailServiceImpl extends BaseServiceImpl<StockPriceUpdateDetail, IStockPriceUpdateDetailDao> implements
		IStockPriceUpdateDetailService {
	private static final long serialVersionUID = 1L;
}


