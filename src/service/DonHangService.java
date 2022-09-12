package service;

import dto.DonHang;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-12-2022 23:24
 **/
public interface DonHangService{
    DonHang them(DonHang input);
    DonHang hienThi();
    DonHang timKiem(DonHang inputSeach);
    DonHang capNhat(String name);
}
