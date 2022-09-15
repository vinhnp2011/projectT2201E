package data;

import dto.ProductType;
import mapper.ProductTypeMapper;
import mapper.ProductMapper;
import utils.CommonUtils;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-12-2022 23:58
 **/
public class FakeData {
    StoreData storeData = new StoreData();
    ProductTypeMapper productTypeMapper = new ProductTypeMapper();
    ProductMapper productMapper = new ProductMapper();
    public FakeData() {
        createFakeDataNhomHangDao();
//        createFakeDataSanPhamDao();
    }

    public void createFakeDataNhomHangDao() {
        int fakeSzDataDefault = 5;
        for (int i = 0; i < fakeSzDataDefault; i++) {
            ProductType nhomHang = new ProductType(
                    CommonUtils.autoGenIdProdType(),
                    "Ten nhom hang " + i,
                    5.0 + Double.valueOf(i),Boolean.TRUE);
            storeData.save(productTypeMapper.mapDtoToEntity(nhomHang));
        }
    }

//    public void createFakeDataSanPhamDao() {
//        int fakeSzDataDefault = 5;
//        for (int i = 0; i < fakeSzDataDefault; i++) {
//            SanPham sanPham = new SanPham();
//            sanPham.setIdPrdType(0L);
//            sanPham.setBarcodePrd(0L);
//            sanPham.setIdPrd(0L);
//            sanPham.setNamePrd(0L);
//            sanPham.setDescPrd("");
//            sanPham.setImPricePrd(0L);
//            sanPham.setExPricePrd(0L);
//            sanPham.setVat(0.0D);
//            storeData.save(sanPhamMapper.mapDtoToEntity(sanPham));
//        }
//    }
}
//Long.valueOf(i)
//Long.valueOf(i)
//"ma Spham" + i
//"ten Spham" + i
//"mo Ta" + i
//"gia Nhap" +
//"gia Ban"
//"vat"