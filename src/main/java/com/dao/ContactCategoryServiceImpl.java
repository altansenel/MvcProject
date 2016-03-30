package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.ContactCategory;
import com.dao.IContactCategoryDao;

@Service
public class ContactCategoryServiceImpl extends BaseServiceImpl<ContactCategory, IContactCategoryDao> implements
		IContactCategoryService {
	private static final long serialVersionUID = 1L;
}


