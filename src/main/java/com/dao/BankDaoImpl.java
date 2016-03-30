package  com.dao;


import org.springframework.stereotype.Repository;

import com.entity.Bank;


@Repository
public class BankDaoImpl extends BaseDaoImpl<Bank> implements IBankDao {
	private static final long serialVersionUID = 1L;
}

