package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.StockBarcode;
import com.dao.IStockBarcodeDao;

@Service
public class StockBarcodeServiceImpl extends BaseServiceImpl<StockBarcode, IStockBarcodeDao> implements
		IStockBarcodeService {
	private static final long serialVersionUID = 1L;
}


