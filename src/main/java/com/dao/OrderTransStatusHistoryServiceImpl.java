package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.OrderTransStatusHistory;
import com.dao.IOrderTransStatusHistoryDao;

@Service
public class OrderTransStatusHistoryServiceImpl extends BaseServiceImpl<OrderTransStatusHistory, IOrderTransStatusHistoryDao> implements
		IOrderTransStatusHistoryService {
	private static final long serialVersionUID = 1L;
}


