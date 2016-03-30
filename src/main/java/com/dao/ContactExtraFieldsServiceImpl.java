package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.ContactExtraFields;
import com.dao.IContactExtraFieldsDao;

@Service
public class ContactExtraFieldsServiceImpl extends BaseServiceImpl<ContactExtraFields, IContactExtraFieldsDao> implements
		IContactExtraFieldsService {
	private static final long serialVersionUID = 1L;
}


