package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.AdminSetting;
import com.dao.IAdminSettingDao;

@Service
public class AdminSettingServiceImpl extends BaseServiceImpl<AdminSetting, IAdminSettingDao> implements
		IAdminSettingService {
	private static final long serialVersionUID = 1L;
}


