package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.OrderTransFactor;
import com.dao.IOrderTransFactorDao;

@Service
public class OrderTransFactorServiceImpl extends BaseServiceImpl<OrderTransFactor, IOrderTransFactorDao> implements
		IOrderTransFactorService {
	private static final long serialVersionUID = 1L;
}


