package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.OrderTransStatus;
import com.dao.IOrderTransStatusDao;

@Service
public class OrderTransStatusServiceImpl extends BaseServiceImpl<OrderTransStatus, IOrderTransStatusDao> implements
		IOrderTransStatusService {
	private static final long serialVersionUID = 1L;
}


