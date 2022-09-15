package data;

import dao.DonHangDao;
import dao.ProductTypeDAO;
import dao.ProductDAO;
import dto.ProductType;
import dto.Product;
import mapper.NhomHangMapper;
import mapper.SanPhamMapper;

import java.util.ArrayList;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-12-2022 23:57
 **/
public class StoreData {
    static ArrayList<ProductTypeDAO> nhomHangs  = new ArrayList<>();
    static ArrayList<ProductDAO>  sanPhams = new ArrayList<>();
    static ArrayList<DonHangDao>  donHangs = new ArrayList<>();

    public static Integer sizeNhomHang = nhomHangs.size();
    public static Integer sizeSanPham  = sanPhams.size();
    public static Integer sizeDonHang  = donHangs.size();


    NhomHangMapper nhomHangMapper = new NhomHangMapper();
    SanPhamMapper sanPhamMapper = new SanPhamMapper();
    public StoreData() {

    }

    public ArrayList<ProductTypeDAO> getNhomHang() {
        return nhomHangs;
    }

    public ArrayList<DonHangDao> getDonHang() {
        return donHangs;
    }

    public ArrayList<ProductDAO> getSanPham() {
        return sanPhams;
    }

    public ProductType save(ProductTypeDAO nhomHangDao) {
        this.nhomHangs.add(nhomHangDao);
        sizeNhomHang =nhomHangs.size();
        return nhomHangMapper.mapEntityToDto(nhomHangDao);
    }
//
//    public void save(DonHang donHang) {
//        this.donHangs.add(nhomHangMapper.mapDtoToEntity(donHang));
//    }

    public Product save(ProductDAO productDAO) {
        this.sanPhams.add(productDAO);
        sizeSanPham =sanPhams.size();
        return sanPhamMapper.mapEntityToDto(productDAO);

    }
}
