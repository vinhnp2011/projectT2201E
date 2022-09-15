package service.impl;

import dao.ProductDAO;
import data.StoreData;
import dto.Product;
import mapper.SanPhamMapper;
import service.ProductService;

import java.util.List;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-12-2022 23:24
 **/
public class SanPhamServiceImpl implements ProductService {
    StoreData storeData = new StoreData();
    SanPhamMapper sanPhamMapper = new SanPhamMapper();
    @Override
    public Product addPrd(Product input) {
        ProductDAO productDAO = sanPhamMapper.mapDtoToEntity(input);
        return  storeData.save(productDAO);
    }

    @Override
    public List<Product> findAllByIdPrd() {
        return null;
    }
}
