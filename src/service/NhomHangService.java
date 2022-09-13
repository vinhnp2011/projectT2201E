package service;

import dto.NhomHang;

import java.util.List;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-12-2022 23:24
 **/
public interface NhomHangService {
    NhomHang them(NhomHang input);

    List<NhomHang> hienThi();

    NhomHang timKiem(NhomHang inputSeach);

    NhomHang capNhat(NhomHang inputSeach);

}
