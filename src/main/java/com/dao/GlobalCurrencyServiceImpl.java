package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.GlobalCurrency;
import com.dao.IGlobalCurrencyDao;

@Service
public class GlobalCurrencyServiceImpl extends BaseServiceImpl<GlobalCurrency, IGlobalCurrencyDao> implements
		IGlobalCurrencyService {
	private static final long serialVersionUID = 1L;
}


