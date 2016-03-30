package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.SafeExpense;
import com.dao.ISafeExpenseDao;

@Service
public class SafeExpenseServiceImpl extends BaseServiceImpl<SafeExpense, ISafeExpenseDao> implements
		ISafeExpenseService {
	private static final long serialVersionUID = 1L;
}


