package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.Safe;
import com.dao.ISafeDao;

@Service
public class SafeServiceImpl extends BaseServiceImpl<Safe, ISafeDao> implements
		ISafeService {
	private static final long serialVersionUID = 1L;
}


