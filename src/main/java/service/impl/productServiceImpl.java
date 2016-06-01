package service.impl;

import dao.ProductInfoMapper;
import entity.ProductInfo;
import service.productService;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
/**
 * Created by Ridiculous on 2016/5/31.
 */
@Service
public class productServiceImpl implements productService {
    @Resource
    private ProductInfoMapper mapper;

    public int addProduct(ProductInfo productInfo) {
        return mapper.insert(productInfo);
    }

    public ProductInfo getProductByProductId(String id) {
        return mapper.selectByProductId(id);
    }
}
