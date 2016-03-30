package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.BankExpense;
import com.dao.IBankExpenseDao;

@Service
public class BankExpenseServiceImpl extends BaseServiceImpl<BankExpense, IBankExpenseDao> implements
		IBankExpenseService {
	private static final long serialVersionUID = 1L;
}


