package data;

import dao.DonHangDao;
import dao.NhomHangDao;
import dao.SanPhamDao;
import dto.DonHang;
import dto.NhomHang;
import dto.SanPham;
import mapper.NhomHangMapper;

import java.util.ArrayList;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-12-2022 23:57
 **/
public class StoreData {
    static ArrayList<NhomHangDao> nhomHangs  = new ArrayList<>();
    static ArrayList<DonHangDao>  donHangs = new ArrayList<>();
    static ArrayList<SanPhamDao>  sanPhams = new ArrayList<>();

    NhomHangMapper nhomHangMapper = new NhomHangMapper();
    public StoreData() {

    }

    public ArrayList<NhomHangDao> getNhomHang() {
        return nhomHangs;
    }

    public ArrayList<DonHangDao> getDonHang() {
        return donHangs;
    }

    public ArrayList<SanPhamDao> getSanPham() {
        return sanPhams;
    }

    public NhomHang save(NhomHangDao nhomHangDao) {
        this.nhomHangs.add(nhomHangDao);
        return nhomHangMapper.mapEntityToDto(nhomHangDao);
    }
//
//    public void save(DonHang donHang) {
//        this.donHangs.add(nhomHangMapper.mapDtoToEntity(donHang));
//    }
//
//    public void save(SanPham sanPham) {
//        this.sanPhams.add(sanPham);
//    }
}
