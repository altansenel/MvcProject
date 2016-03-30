package  com.dao;

import org.springframework.stereotype.Service;

import com.entity.WaybillTrans;
import com.dao.IWaybillTransDao;

@Service
public class WaybillTransServiceImpl extends BaseServiceImpl<WaybillTrans, IWaybillTransDao> implements
		IWaybillTransService {
	private static final long serialVersionUID = 1L;
}


