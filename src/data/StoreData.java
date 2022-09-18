package data;

import dao.OrderDAO;
import dao.ProductTypeDAO;
import dao.ProductDAO;
import dto.Order;
import dto.ProductType;
import dto.Product;
import mapper.OrderMapper;
import mapper.ProductTypeMapper;
import mapper.ProductMapper;

import java.util.ArrayList;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-12-2022 23:57
 **/
public class StoreData {
    static ArrayList<ProductTypeDAO> productTypeDAOS = new ArrayList<>();
    static ArrayList<ProductDAO> productDAOS = new ArrayList<>();
    static ArrayList<OrderDAO>  orderDAOSs = new ArrayList<>();

    public static Integer sizePrdType = productTypeDAOS.size();
    public static Integer sizePrd = productDAOS.size();
    public static Integer sizeOrder = orderDAOSs.size();


    ProductTypeMapper productTypeMapper = new ProductTypeMapper();
    ProductMapper productMapper = new ProductMapper();

    OrderMapper orderMapper = new OrderMapper();
    public StoreData() {

    }

    public ArrayList<ProductTypeDAO> getValuePrdType() {
        return productTypeDAOS;
    }

    public ArrayList<OrderDAO> getValueOrder() {
        return orderDAOSs;
    }

    public ArrayList<ProductDAO> getValuePrd() {
        return productDAOS;
    }

    public ProductType save(ProductTypeDAO nhomHangDao) {
        this.productTypeDAOS.add(nhomHangDao);
        sizePrdType = productTypeDAOS.size();
        return productTypeMapper.mapEntityToDto(nhomHangDao);
    }

    public Order save(OrderDAO orderDAO) {
        this.orderDAOSs.add(orderDAO);
        sizeOrder = productTypeDAOS.size();
        return orderMapper.mapEntityToDto(orderDAO);
    }

    public Product save(ProductDAO productDAO) {
        this.productDAOS.add(productDAO);
        sizePrd = productDAOS.size();
        return productMapper.mapEntityToDto(productDAO);

    }
}
