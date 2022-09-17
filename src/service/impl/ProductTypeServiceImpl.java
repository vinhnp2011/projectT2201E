package service.impl;

import dao.ProductTypeDAO;
import data.StoreData;
import dto.ProductType;
import mapper.ProductTypeMapper;
import service.ProductTypeService;

import java.util.List;
import java.util.Optional;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-12-2022 23:24
 **/
public class ProductTypeServiceImpl implements ProductTypeService {
    StoreData storeData = new StoreData();
    ProductTypeMapper productTypeMapper = new ProductTypeMapper();

    @Override
    public ProductType addPrdType(ProductType input) {
        ProductType result = storeData.save(productTypeMapper.mapDtoToEntity(input));
        result.setIsSuccess(Boolean.TRUE);
        return result;
    }

    @Override
    public List<ProductType> findAllByIdPrdType() {
        return productTypeMapper.mapEntitiesToDtos(storeData.getNhomHang());
    }

    @Override
    public ProductType findByIdPrdType(ProductType inputSeach) {
        Optional<ProductTypeDAO> nhomHang = storeData.getNhomHang().stream().filter(
                obj -> obj.getIdProductType().equals(inputSeach.getIdPrdType())
        ).findFirst();
        if (nhomHang.isEmpty()) {
            return new ProductType();
        }
        return productTypeMapper.mapEntityToDto(nhomHang.get());
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
