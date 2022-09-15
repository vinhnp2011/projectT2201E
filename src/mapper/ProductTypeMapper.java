package mapper;
import java.util.ArrayList;

import dao.ProductTypeDAO;
import dto.ProductType;

import java.util.List;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-13-2022 23:25
 **/
public class ProductTypeMapper {
    public ProductType mapEntityToDto(ProductTypeDAO nhomHangDao){
        ProductType nhomHang = new ProductType();
        nhomHang.setIdPrdType(nhomHangDao.getIdProductType());
        nhomHang.setNamePrdType(nhomHangDao.getNamePrdType());
        nhomHang.setVat(nhomHangDao.getVat());
        return nhomHang;
    }

    public List<ProductType> mapEntitiesToDtos(List<ProductTypeDAO> nhomHangDaos){
        List<ProductType> nhomHanglist=new ArrayList<>();
        for (ProductTypeDAO nhomHangDao :nhomHangDaos) {
        	nhomHanglist.add(convertFromNhomHangDao(nhomHangDao));
        }
        return nhomHanglist;

    }

    private ProductType convertFromNhomHangDao(ProductTypeDAO nhomHangDao) {
        ProductType nhomHang = new ProductType();
        nhomHang.setIdPrdType(nhomHangDao.getIdProductType());
        nhomHang.setNamePrdType(nhomHangDao.getNamePrdType());
        nhomHang.setVat(nhomHangDao.getVat());
        return nhomHang;
    }

    public ProductTypeDAO mapDtoToEntity(ProductType nhomHang){
        ProductTypeDAO nhomHangDao = new ProductTypeDAO();
        nhomHangDao.setIdProductType(nhomHang.getIdPrdType());
        nhomHangDao.setNamePrdType(nhomHang.getNamePrdType());
        nhomHangDao.setVat(nhomHang.getVat());
        return nhomHangDao;
    }

    public List<ProductTypeDAO> mapDtosToEntities(List<ProductType> nhomHangDaos){
        List<ProductTypeDAO> nhomHangDaolist=new ArrayList<>();
        for (ProductType nhomHang :nhomHangDaos) {
        	nhomHangDaolist.add(convertFromNhomHang(nhomHang));
        }
        return nhomHangDaolist;
    }

    private ProductTypeDAO convertFromNhomHang(ProductType nhomHang) {
        ProductTypeDAO nhomHangDao = new ProductTypeDAO();
        nhomHangDao.setIdProductType(nhomHang.getIdPrdType());
        nhomHangDao.setNamePrdType(nhomHang.getNamePrdType());
        nhomHangDao.setVat(nhomHang.getVat());
        return nhomHangDao;
    }
}
