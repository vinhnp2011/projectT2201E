package data;

import dao.OrderDAO;
import dao.ProductTypeDAO;
import dao.ProductDAO;
import dto.ProductType;
import dto.Product;
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
    static ArrayList<OrderDAO>  donHangs = new ArrayList<>();

    public static Integer sizeNhomHang = productTypeDAOS.size();
    public static Integer sizeSanPham  = productDAOS.size();
    public static Integer sizeDonHang  = donHangs.size();


    ProductTypeMapper productTypeMapper = new ProductTypeMapper();
    ProductMapper productMapper = new ProductMapper();
    public StoreData() {

    }

    public ArrayList<ProductTypeDAO> getNhomHang() {
        return productTypeDAOS;
    }

    public ArrayList<OrderDAO> getDonHang() {
        return donHangs;
    }

    public ArrayList<ProductDAO> getSanPham() {
        return productDAOS;
    }

    public ProductType save(ProductTypeDAO nhomHangDao) {
        this.productTypeDAOS.add(nhomHangDao);
        sizeNhomHang = productTypeDAOS.size();
        return productTypeMapper.mapEntityToDto(nhomHangDao);
    }
//
//    public void save(DonHang donHang) {
//        this.donHangs.add(nhomHangMapper.mapDtoToEntity(donHang));
//    }

    public Product save(ProductDAO productDAO) {
        this.productDAOS.add(productDAO);
        sizeSanPham = productDAOS.size();
        return productMapper.mapEntityToDto(productDAO);

    }
}
