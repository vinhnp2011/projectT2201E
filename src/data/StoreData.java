package data;

import dao.DonHangDao;
import dao.NhomHangDao;
import dao.SanPhamDao;

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

    public void save(NhomHangDao nhomHang) {
        this.nhomHangs.add(nhomHang);
    }

    public void save(DonHangDao donHang) {
        this.donHangs.add(donHang);
    }

    public void save(SanPhamDao sanPham) {
        this.sanPhams.add(sanPham);
    }
}
