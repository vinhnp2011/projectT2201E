package service.impl;

import data.StoreData;
import dto.ProductType;
import mapper.OrderMapper;
import mapper.ProductMapper;
import mapper.ProductTypeMapper;
import service.OrderService;
import service.ProductService;
import service.ProductTypeService;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-18-2022 22:18
 **/
public class CommonServiceImpl {
     StoreData storeData = new StoreData();
     OrderMapper orderMapper = new OrderMapper();
     ProductMapper productMapper = new ProductMapper();
     ProductTypeMapper productTypeMapper = new ProductTypeMapper();
     OrderService orderService = new OrderServiceImpl();

     ProductService productService = new ProductServiceImpl();
}
