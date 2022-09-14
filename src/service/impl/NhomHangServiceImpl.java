package service.impl;

import dao.NhomHangDao;
import data.StoreData;
import dto.NhomHang;
import mapper.NhomHangMapper;
import service.NhomHangService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

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
        Optional<NhomHangDao> nhomHang = storeData.getNhomHang().stream().filter(
                obj -> obj.getMaNhomHang().equals(inputSeach.getMaNhomHang())
        ).findFirst();
        if (nhomHang.isEmpty()) {
            return new NhomHang();
        }
        return nhomHangMapper.mapEntityToDto(nhomHang.get());
    }

    @Override
    public NhomHang capNhat(NhomHang inputSeach) {
        storeData.getNhomHang().stream().forEach(
                obj -> {
                    if (obj.getMaNhomHang().equals(inputSeach.getMaNhomHang())) {
                        obj.setMaNhomHang(inputSeach.getMaNhomHang());
                        obj.setTenNhomHang(inputSeach.getTenNhomHang());
                        obj.setVat(inputSeach.getVat());
                    }
                }
        );
        return timKiem(inputSeach);
    }
}
