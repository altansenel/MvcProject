package com.dao;
import org.springframework.stereotype.Repository;
import com.entity.Order;

@Repository
public class OrderDaoImpl extends BaseDaoImpl<Order> implements IOrderDao {
private static final long serialVersionUID = 1L;
}
