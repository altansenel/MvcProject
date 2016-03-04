package com.dao;
import org.springframework.stereotype.Repository;
import com.entity.Product;

@Repository
public class ProductDaoImpl extends BaseDaoImpl<Product> implements IProductDao {
private static final long serialVersionUID = 1L;
}
