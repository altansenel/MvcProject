package com.dao;import org.springframework.stereotype.Service;
import com.entity.Order;

@Service
public class OrderServiceImpl extends BaseServiceImpl<Order, IOrderDao> implements IOrderService {
private static final long serialVersionUID = 1L;


}
