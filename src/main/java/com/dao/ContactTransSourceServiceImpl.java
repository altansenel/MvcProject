package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.ContactTransSource;
import com.dao.IContactTransSourceDao;

@Service
public class ContactTransSourceServiceImpl extends BaseServiceImpl<ContactTransSource, IContactTransSourceDao> implements
		IContactTransSourceService {
	private static final long serialVersionUID = 1L;
}


