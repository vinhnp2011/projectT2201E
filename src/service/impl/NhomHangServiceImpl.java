package service.impl;

import data.StoreData;
import dto.NhomHang;
import mapper.NhomHangMapper;
import service.NhomHangService;

import java.util.List;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-12-2022 23:24
 **/
public class NhomHangServiceImpl implements NhomHangService {
    StoreData storeData = new StoreData();
    NhomHangMapper nhomHangMapper = new NhomHangMapper();
    @Override
    public NhomHang them(NhomHang input) {
        return storeData.save(nhomHangMapper.mapDtoToEntity(input));
    }

    @Override
    public List<NhomHang> hienThi() {
        return nhomHangMapper.mapEntitiesToDtos(storeData.getNhomHang());
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
