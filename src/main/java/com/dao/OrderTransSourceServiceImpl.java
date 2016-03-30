package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.OrderTransSource;
import com.dao.IOrderTransSourceDao;

@Service
public class OrderTransSourceServiceImpl extends BaseServiceImpl<OrderTransSource, IOrderTransSourceDao> implements
		IOrderTransSourceService {
	private static final long serialVersionUID = 1L;
}


