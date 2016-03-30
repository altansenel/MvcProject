package  com.dao;


import org.springframework.stereotype.Repository;

import com.entity.Contact;


@Repository
public class ContactDaoImpl extends BaseDaoImpl<Contact> implements IContactDao {
	private static final long serialVersionUID = 1L;
}

