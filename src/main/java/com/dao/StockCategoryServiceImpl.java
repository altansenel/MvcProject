package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.StockCategory;
import com.dao.IStockCategoryDao;

@Service
public class StockCategoryServiceImpl extends BaseServiceImpl<StockCategory, IStockCategoryDao> implements
		IStockCategoryService {
	private static final long serialVersionUID = 1L;
}


