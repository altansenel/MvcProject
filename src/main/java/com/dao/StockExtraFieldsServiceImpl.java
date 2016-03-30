package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.StockExtraFields;
import com.dao.IStockExtraFieldsDao;

@Service
public class StockExtraFieldsServiceImpl extends BaseServiceImpl<StockExtraFields, IStockExtraFieldsDao> implements
		IStockExtraFieldsService {
	private static final long serialVersionUID = 1L;
}


