package service.impl;

import dao.NhomHangDao;
import data.StoreData;
import dto.DonHang;
import dto.NhomHang;
import service.DonHangService;
import service.NhomHangService;

import java.util.List;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-12-2022 23:24
 **/
public class NhomHangServiceImpl implements NhomHangService {
    StoreData storeData = new StoreData();

    @Override
    public NhomHang them(NhomHang input) {
        return null;
    }

    @Override
    public List<NhomHangDao> hienThi() {
        return storeData.getNhomHang();
    }

    @Override
    public NhomHang timKiem(NhomHang inputSeach) {
        return null;
    }

    @Override
    public NhomHang capNhat(NhomHang inputSeach) {
        return null;
    }
}
