package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.GlobalTransPoint;
import com.dao.IGlobalTransPointDao;

@Service
public class GlobalTransPointServiceImpl extends BaseServiceImpl<GlobalTransPoint, IGlobalTransPointDao> implements
		IGlobalTransPointService {
	private static final long serialVersionUID = 1L;
}


