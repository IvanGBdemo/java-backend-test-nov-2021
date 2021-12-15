package com.geekbrains.mybatis;


import com.geekbrains.db.dao.ProductsMapper;
import com.geekbrains.db.model.Products;
import com.geekbrains.db.model.ProductsExample;

import java.util.List;


public class Test {
    public static void main(String[] args) {

MyBatisDbService dbService = new MyBatisDbService();
        ProductsMapper mapper = dbService.getProductsMapper();

        Products product = mapper.selectByPrimaryKey(1L);
        System.out.println(product);

        ProductsExample example = new ProductsExample();
        example.createCriteria().andPriceLessThan(1000);

        List<Products> products = mapper.selectByExample(example);
        System.out.println(products);

        ProductsExample example2 = new ProductsExample();
        example2.createCriteria().andCategoryIdEqualTo(1L);

        List<Products> products2 = mapper.selectByExample(example2);
        System.out.println(products2);

        ProductsExample example3 = new ProductsExample();
        example3.createCriteria().andTitleBetween("a", "h");

        List<Products> products3 = mapper.selectByExample(example3);
        System.out.println(products3);
    }
}
