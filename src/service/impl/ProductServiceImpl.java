package service.impl;

import dao.ProductDAO;
import data.StoreData;
import dto.Product;
import mapper.OrderMapper;
import mapper.ProductMapper;
import mapper.ProductTypeMapper;
import service.OrderService;
import service.ProductService;
import service.ProductTypeService;

import java.util.List;
import java.util.Optional;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-12-2022 23:24
 **/
public class ProductServiceImpl implements ProductService {

    StoreData storeData = new StoreData();
    ProductMapper productMapper = new ProductMapper();
    @Override
    public Product addPrd(Product input) {
        Product result = storeData.save(productMapper.mapDtoToEntity(input));
        result.setIsSuccess(Boolean.TRUE);
        return result;
    }

    @Override
    public List<Product> findAllByIdPrd() {
        return productMapper.mapEntitiesToDtos(storeData.getValuePrd());
    }

    @Override
    public Product findByIdPrd(Product inputSeach) {
        Optional<ProductDAO> optionalProductDAO = storeData.getValuePrd().stream().filter(
                obj -> obj.getIdPrd().equals(inputSeach.getIdPrd())
        ).findFirst();
        if (optionalProductDAO.isEmpty()) {
            return new Product();
        }
        Product product = productMapper.mapEntityToDto(optionalProductDAO.get());
        product.setIsSuccess(Boolean.TRUE);
        return product;
    }

    @Override
    public Product updatePrd(Product inputSeach) {
        storeData.getValuePrd().stream().forEach(
                obj -> {
                    if (obj.getIdPrd().equals(inputSeach.getIdPrd())) {
                                obj.setBarcodePrd(inputSeach.getBarcodePrd());
                                obj.setNamePrd(inputSeach.getNamePrd());
                                obj.setDescPrd(inputSeach.getDescPrd());
                                obj.setImPricePrd(inputSeach.getImPricePrd());
                                obj.setExPricePrd(inputSeach.getExPricePrd());
                                obj.setVat(inputSeach.getVat());
                    }
                }
        );
        return findByIdPrd(inputSeach);
    }
}
