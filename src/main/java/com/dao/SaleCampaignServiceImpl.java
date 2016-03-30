package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.SaleCampaign;
import com.dao.ISaleCampaignDao;

@Service
public class SaleCampaignServiceImpl extends BaseServiceImpl<SaleCampaign, ISaleCampaignDao> implements
		ISaleCampaignService {
	private static final long serialVersionUID = 1L;
}


