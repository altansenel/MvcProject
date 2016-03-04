package com.dao;
import org.springframework.stereotype.Repository;
import com.entity.Payment;

@Repository
public class PaymentDaoImpl extends BaseDaoImpl<Payment> implements IPaymentDao {
private static final long serialVersionUID = 1L;
}
