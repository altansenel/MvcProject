package com.dao;
import org.springframework.stereotype.Repository;
import com.entity.PaymentMethod;

@Repository
public class PaymentMethodDaoImpl extends BaseDaoImpl<PaymentMethod> implements IPaymentMethodDao {
private static final long serialVersionUID = 1L;
}
