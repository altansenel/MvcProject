package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.BankTrans;
import com.dao.IBankTransDao;

@Service
public class BankTransServiceImpl extends BaseServiceImpl<BankTrans, IBankTransDao> implements
		IBankTransService {
	private static final long serialVersionUID = 1L;
}


