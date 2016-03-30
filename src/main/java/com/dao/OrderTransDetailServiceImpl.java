package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.OrderTransDetail;
import com.dao.IOrderTransDetailDao;

@Service
public class OrderTransDetailServiceImpl extends BaseServiceImpl<OrderTransDetail, IOrderTransDetailDao> implements
		IOrderTransDetailService {
	private static final long serialVersionUID = 1L;
}


