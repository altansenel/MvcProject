package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.StockTransDetail;
import com.dao.IStockTransDetailDao;

@Service
public class StockTransDetailServiceImpl extends BaseServiceImpl<StockTransDetail, IStockTransDetailDao> implements
		IStockTransDetailService {
	private static final long serialVersionUID = 1L;
}


