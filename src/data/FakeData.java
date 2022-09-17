package data;

import dto.Product;
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
        createFakeDataSanPhamDao();
    }

    public void createFakeDataNhomHangDao() {
        int fakeSzDataDefault = 5;
        for (int i = 0; i < fakeSzDataDefault; i++) {
            ProductType nhomHang = ProductType.builder()
                    .idPrdType(CommonUtils.autoGenIdProdType())
                    .namePrdType("Ten nhom hang " + i)
                    .vat( 1 - Double.valueOf(i) * 0.1)
                    .isSuccess(Boolean.TRUE).build();
            storeData.save(productTypeMapper.mapDtoToEntity(nhomHang));
        }
    }

    public void createFakeDataSanPhamDao() {
        int fakeSzDataDefault = 5;
        for (int i = 0; i < fakeSzDataDefault; i++) {
            Product sanPham =dto.Product.builder()
                    .idPrdType("idPrdType test " + i)
                    .barcodePrd("barcodePrd test" + i)
                    .idPrd(CommonUtils.autoGenIdProduct(""))
                    .namePrd("namePrd test " + i)
                    .descPrd("descPrd test " + i)
                    .imPricePrd(1f + i)
                    .exPricePrd(2f + i)
                    .vat( 1 - Double.valueOf(i) * 0.1)
                    .isSuccess(Boolean.TRUE)
                    .build();

            storeData.save(productMapper.mapDtoToEntity(sanPham));
        }
    }
}
