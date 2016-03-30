package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.GlobalPrivateCode;
import com.dao.IGlobalPrivateCodeDao;

@Service
public class GlobalPrivateCodeServiceImpl extends BaseServiceImpl<GlobalPrivateCode, IGlobalPrivateCodeDao> implements
		IGlobalPrivateCodeService {
	private static final long serialVersionUID = 1L;
}


