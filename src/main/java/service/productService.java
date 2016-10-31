package service;

import entity.ProductInfo;

import java.util.List;

/**
 * Created by Ridiculous on 2016/5/31.
 */
public interface productService {
    int addProduct(ProductInfo productInfo);
    ProductInfo getProductByProductId(String id);
    List<ProductInfo> getProductsByCpId(String id);
    int updateProductByProductId(ProductInfo productInfo);

    int deleteByProductId(String productId);
}
