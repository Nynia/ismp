package service;

import entity.ProductInfo;

/**
 * Created by Ridiculous on 2016/5/31.
 */
public interface productService {
    int addProduct(ProductInfo productInfo);
    ProductInfo getProductByProductId(String id);
}
