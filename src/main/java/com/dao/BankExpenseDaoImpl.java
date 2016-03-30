package  com.dao;


import org.springframework.stereotype.Repository;

import com.entity.BankExpense;


@Repository
public class BankExpenseDaoImpl extends BaseDaoImpl<BankExpense> implements IBankExpenseDao {
	private static final long serialVersionUID = 1L;
}

