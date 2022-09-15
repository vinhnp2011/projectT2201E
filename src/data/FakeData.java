package data;

import dao.NhomHangDao;
import dto.DonHang;
import dto.NhomHang;
import dto.SanPham;
import mapper.NhomHangMapper;
import mapper.SanPhamMapper;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-12-2022 23:58
 **/
public class FakeData {
    StoreData storeData = new StoreData();
    NhomHangMapper nhomHangMapper = new NhomHangMapper();
    SanPhamMapper sanPhamMapper = new SanPhamMapper();
    public FakeData() {
        createFakeDataNhomHangDao();
    }

    public void createFakeDataNhomHangDao() {
        int fakeSzDataDefault = 5;
        for (int i = 0; i < fakeSzDataDefault; i++) {
            NhomHang nhomHang = new NhomHang(Long.valueOf(i), "Ten nhom hang " + i, 5.0 + Double.valueOf(i));
            storeData.save(nhomHangMapper.mapDtoToEntity(nhomHang));
        }
    }

    public void createFakeDataSanPhamDao() {
        int fakeSzDataDefault = 5;
        for (int i = 0; i < fakeSzDataDefault; i++) {
            SanPham sanPham = new SanPham();
            sanPham.setMaNhomHang(0L);
            sanPham.setMaVach(0L);
            sanPham.setMaSpham(0L);
            sanPham.setTenSpham(0L);
            sanPham.setMoTa("");
            sanPham.setGiaNhap(0L);
            sanPham.setGiaBan(0L);
            sanPham.setVat(0.0D);
            storeData.save(sanPhamMapper.mapDtoToEntity(sanPham));
        }
    }
}
//Long.valueOf(i)
//Long.valueOf(i)
//"ma Spham" + i
//"ten Spham" + i
//"mo Ta" + i
//"gia Nhap" +
//"gia Ban"
//"vat"