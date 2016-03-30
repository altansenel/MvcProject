package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.SafeTrans;
import com.dao.ISafeTransDao;

@Service
public class SafeTransServiceImpl extends BaseServiceImpl<SafeTrans, ISafeTransDao> implements
		ISafeTransService {
	private static final long serialVersionUID = 1L;
}


