package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.GlobalProfile;
import com.dao.IGlobalProfileDao;

@Service
public class GlobalProfileServiceImpl extends BaseServiceImpl<GlobalProfile, IGlobalProfileDao> implements
		IGlobalProfileService {
	private static final long serialVersionUID = 1L;
}


