package com.dao;

import org.springframework.stereotype.Service;

import com.entity.Adam;

@Service
public class AdamServiceImpl extends BaseServiceImpl<Adam, IAdamDao> implements
		IAdamService {
	private static final long serialVersionUID = 1L;
}
