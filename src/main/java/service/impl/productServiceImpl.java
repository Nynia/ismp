package service.impl;

import dao.ChargePointMapper;
import dao.ProductInfoMapper;
import entity.ChargePoint;
import entity.ProductInfo;
import service.productService;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ridiculous on 2016/5/31.
 */
@Service
public class productServiceImpl implements productService {
    @Resource
    private ProductInfoMapper productInfoMapper;

    public int addProduct(ProductInfo productInfo) {
        return productInfoMapper.insert(productInfo);
    }

    public ProductInfo getProductByProductId(String id) {
        return productInfoMapper.selectByProductId(id);
    }

    public List<ProductInfo> getProductsByCpId(String id) {
        return productInfoMapper.selectByCpId(id);
    }

    public int updateProductByProductId(ProductInfo productInfo) {
        return productInfoMapper.updateByProductId(productInfo);
    }

    public int deleteByProductId(String productId) {
        return productInfoMapper.deleteByProductId(productId);
    }
}
