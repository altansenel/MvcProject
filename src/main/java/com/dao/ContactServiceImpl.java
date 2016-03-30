package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.Contact;
import com.dao.IContactDao;

@Service
public class ContactServiceImpl extends BaseServiceImpl<Contact, IContactDao> implements
		IContactService {
	private static final long serialVersionUID = 1L;
}


