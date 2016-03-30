package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.GlobalCurrencyRate;
import com.dao.IGlobalCurrencyRateDao;

@Service
public class GlobalCurrencyRateServiceImpl extends BaseServiceImpl<GlobalCurrencyRate, IGlobalCurrencyRateDao> implements
		IGlobalCurrencyRateService {
	private static final long serialVersionUID = 1L;
}


