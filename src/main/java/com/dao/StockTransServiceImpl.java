package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.StockTrans;
import com.dao.IStockTransDao;

@Service
public class StockTransServiceImpl extends BaseServiceImpl<StockTrans, IStockTransDao> implements
		IStockTransService {
	private static final long serialVersionUID = 1L;
}


