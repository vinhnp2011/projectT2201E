package service;

import dto.ProductType;

import java.util.List;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-12-2022 23:24
 **/
public interface ProductTypeService {
    ProductType addPrdType(ProductType input);

    List<ProductType> findAllByIdPrdType();

    ProductType findByIdPrdType(ProductType inputSeach);

    ProductType updatePrdType(ProductType inputSeach);

}
