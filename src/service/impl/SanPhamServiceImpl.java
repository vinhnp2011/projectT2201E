package service.impl;

import dao.SanPhamDao;
import data.StoreData;
import dto.SanPham;
import mapper.SanPhamMapper;
import service.SanPhamService;

import java.util.List;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-12-2022 23:24
 **/
public class SanPhamServiceImpl implements SanPhamService {
    StoreData storeData = new StoreData();
    SanPhamMapper sanPhamMapper = new SanPhamMapper();
    @Override
    public SanPham them(SanPham input) {
        SanPhamDao sanPhamDao = sanPhamMapper.mapDtoToEntity(input);
        return  storeData.save(sanPhamDao);
    }

    @Override
    public List<SanPhamDao> hienThi() {
        return null;
    }
}
