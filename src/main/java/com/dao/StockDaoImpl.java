package  com.dao;


import org.springframework.stereotype.Repository;

import com.entity.Stock;


@Repository
public class StockDaoImpl extends BaseDaoImpl<Stock> implements IStockDao {
	private static final long serialVersionUID = 1L;
}

