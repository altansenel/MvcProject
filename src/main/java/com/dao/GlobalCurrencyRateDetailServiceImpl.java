package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.GlobalCurrencyRateDetail;
import com.dao.IGlobalCurrencyRateDetailDao;

@Service
public class GlobalCurrencyRateDetailServiceImpl extends BaseServiceImpl<GlobalCurrencyRateDetail, IGlobalCurrencyRateDetailDao> implements
		IGlobalCurrencyRateDetailService {
	private static final long serialVersionUID = 1L;
}


