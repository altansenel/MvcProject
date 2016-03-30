package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.TempContactAging;
import com.dao.ITempContactAgingDao;

@Service
public class TempContactAgingServiceImpl extends BaseServiceImpl<TempContactAging, ITempContactAgingDao> implements
		ITempContactAgingService {
	private static final long serialVersionUID = 1L;
}


