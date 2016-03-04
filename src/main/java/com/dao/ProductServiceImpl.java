package com.dao;import org.springframework.stereotype.Service;
import com.entity.Product;

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product, IProductDao> implements IProductService {
private static final long serialVersionUID = 1L;


}
