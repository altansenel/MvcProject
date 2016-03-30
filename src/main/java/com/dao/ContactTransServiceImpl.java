package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.ContactTrans;
import com.dao.IContactTransDao;

@Service
public class ContactTransServiceImpl extends BaseServiceImpl<ContactTrans, IContactTransDao> implements
		IContactTransService {
	private static final long serialVersionUID = 1L;
}


