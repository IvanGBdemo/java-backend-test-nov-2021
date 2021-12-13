package com.geekbrains.mybatis;


import java.util.List;

public class Test {
    public static void main(String[] args) {

MyBatisDbService dbService = new MyBatisDbService();
        ProductsMapper mapper = dbService.getProductsMapper();

        Products product = mapper.selectByPrimaryKey(1L);
        System.out.println(product);

        ProductsExample example = new ProductsExample();
        example.createCriteria()
// Условное название категории, так как не имею подключения к БД
                .andPriceLessThan(1000);

        List<Products> products = mapper.selectByExample(example);
        System.out.println(products);

        ProductsExample example2 = new ProductsExample();
        example2.createCriteria()
// Условное название категории, так как не имею подключения к БД
                .andProductsСategories(1);

        List<Products> products2 = mapper.selectByExample(example2);
        System.out.println(products2);

        ProductsExample example3 = new ProductsExample();
        example3.createCriteria()
// Условное название категории, так как не имею подключения к БД
                .andTitleBeginsWith(a, h);

        List<Products> products3 = mapper.selectByExample(example3);
        System.out.println(products3);
    }
}
