package service;

import dao.DonHangDao;
import dto.DonHang;

import java.util.List;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-12-2022 23:24
 **/
public interface DonHangService{
    DonHang them(DonHang input);
    List<DonHangDao> hienThi();
    DonHang timKiem(DonHang inputSeach);
    DonHang capNhat(String name);
}
