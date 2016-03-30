package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.OrderTrans;
import com.dao.IOrderTransDao;

@Service
public class OrderTransServiceImpl extends BaseServiceImpl<OrderTrans, IOrderTransDao> implements
		IOrderTransService {
	private static final long serialVersionUID = 1L;
}


