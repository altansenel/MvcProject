package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.WaybillTransStatusHistory;
import com.dao.IWaybillTransStatusHistoryDao;

@Service
public class WaybillTransStatusHistoryServiceImpl extends BaseServiceImpl<WaybillTransStatusHistory, IWaybillTransStatusHistoryDao> implements
		IWaybillTransStatusHistoryService {
	private static final long serialVersionUID = 1L;
}


