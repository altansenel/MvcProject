package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.SafeTransSource;
import com.dao.ISafeTransSourceDao;

@Service
public class SafeTransSourceServiceImpl extends BaseServiceImpl<SafeTransSource, ISafeTransSourceDao> implements
		ISafeTransSourceService {
	private static final long serialVersionUID = 1L;
}


