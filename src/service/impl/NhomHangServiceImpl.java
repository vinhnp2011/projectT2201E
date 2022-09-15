package service.impl;

import dao.ProductTypeDAO;
import data.StoreData;
import dto.ProductType;
import mapper.NhomHangMapper;
import service.ProductTypeService;

import java.util.List;
import java.util.Optional;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-12-2022 23:24
 **/
public class NhomHangServiceImpl implements ProductTypeService {
    StoreData storeData = new StoreData();
    NhomHangMapper nhomHangMapper = new NhomHangMapper();

    @Override
    public ProductType addPrdType(ProductType input) {
        return storeData.save(nhomHangMapper.mapDtoToEntity(input));
    }

    @Override
    public List<ProductType> findAllByIdPrdType() {
        return nhomHangMapper.mapEntitiesToDtos(storeData.getNhomHang());
    }

    @Override
    public ProductType findByIdPrdType(ProductType inputSeach) {
        Optional<ProductTypeDAO> nhomHang = storeData.getNhomHang().stream().filter(
                obj -> obj.getIdProductType().equals(inputSeach.getIdPrdType())
        ).findFirst();
        if (nhomHang.isEmpty()) {
            return new ProductType();
        }
        return nhomHangMapper.mapEntityToDto(nhomHang.get());
    }

    @Override
    public ProductType updatePrdType(ProductType inputSeach) {
        storeData.getNhomHang().stream().forEach(
                obj -> {
                    if (obj.getIdProductType().equals(inputSeach.getIdPrdType())) {
                        obj.setIdProductType(inputSeach.getIdPrdType());
                        obj.setNamePrdType(inputSeach.getNamePrdType());
                        obj.setVat(inputSeach.getVat());
                    }
                }
        );
        return findByIdPrdType(inputSeach);
    }
}
