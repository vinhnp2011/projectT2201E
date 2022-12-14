package data;

import dto.Order;
import dto.Product;
import dto.ProductOrder;
import dto.ProductType;
import mapper.OrderMapper;
import mapper.ProductTypeMapper;
import mapper.ProductMapper;
import service.OrderService;
import service.ProductService;
import service.impl.CommonServiceImpl;
import service.impl.OrderServiceImpl;
import service.impl.ProductServiceImpl;
import utils.CommonUtils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.MonthDay;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-12-2022 23:58
 **/
public class FakeData {
    StoreData storeData = new StoreData();
    OrderMapper orderMapper = new OrderMapper();
    ProductMapper productMapper = new ProductMapper();
    ProductTypeMapper productTypeMapper = new ProductTypeMapper();

    OrderService orderService = new OrderServiceImpl();
    ProductService productService = new ProductServiceImpl();
    public FakeData() {
        createFakeDataNhomHangDao();
        createFakeDataSanPhamDao();
        createFakeDataOrderDao();
    }

    public void createFakeDataNhomHangDao() {
        int fakeSzDataDefault = 5;
        for (int i = 0; i < fakeSzDataDefault; i++) {
            ProductType nhomHang = ProductType.builder()
                    .idPrdType(CommonUtils.autoGenIdProdType())
                    .namePrdType("Ten nhom hang " + i)
                    .vat(0.1)
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
                    .vat(0.1)
                    .isSuccess(Boolean.TRUE)
                    .build();

            storeData.save(productMapper.mapDtoToEntity(sanPham));
        }
    }

    public void createFakeDataOrderDao() {
        Map<String, ProductOrder> map = new HashMap<>();
        map.put("0000", ProductOrder.builder().idPrd("0000").quantityPerPrd(3).build() );
        map.put("0001", ProductOrder.builder().idPrd("0001").quantityPerPrd(2).build() );
        map.put("0002", ProductOrder.builder().idPrd("0002").quantityPerPrd(1).build() );
        map.put("0003", ProductOrder.builder().idPrd("0003").quantityPerPrd(4).build() );
        map.put("0004", ProductOrder.builder().idPrd("0004").quantityPerPrd(5).build() );

        map.put("0000", ProductOrder.builder().idPrd("0000").quantityPerPrd(9).build() );
        map.put("0001", ProductOrder.builder().idPrd("0001").quantityPerPrd(6).build() );
        map.put("0002", ProductOrder.builder().idPrd("0002").quantityPerPrd(7).build() );
        map.put("0003", ProductOrder.builder().idPrd("0003").quantityPerPrd(8).build() );
        map.put("0004", ProductOrder.builder().idPrd("0004").quantityPerPrd(11).build() );

        int fakeSzDataDefault = 7;
        for (int i = 0; i < fakeSzDataDefault; i++) {
            Order order = Order.builder()
                    .idOrder("idPrdType test " + i)
                    .dateOrder(Instant.parse("2022-09-15T18:35:24.00Z"))
                    .productOrderMap(map)
                    .isSuccess(Boolean.TRUE)
                    .build();
            storeData.save(orderMapper.mapDtoToEntity(order));
        }
    }

        public static void main(String[] args) {

            Instant instant = Instant.parse("2022-09-15T18:35:24.00Z");

            Date myDate = Date.from(instant);
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String formattedDate = formatter.format(myDate);
            System.out.println(formattedDate);

            LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
            int month = localDateTime.getMonthValue();
            System.out.println(month);



        }
}
