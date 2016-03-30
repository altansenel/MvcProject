package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.BankTransSource;
import com.dao.IBankTransSourceDao;

@Service
public class BankTransSourceServiceImpl extends BaseServiceImpl<BankTransSource, IBankTransSourceDao> implements
		IBankTransSourceService {
	private static final long serialVersionUID = 1L;
}


