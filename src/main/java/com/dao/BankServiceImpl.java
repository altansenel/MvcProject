package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.Bank;
import com.dao.IBankDao;

@Service
public class BankServiceImpl extends BaseServiceImpl<Bank, IBankDao> implements
		IBankService {
	private static final long serialVersionUID = 1L;
}


