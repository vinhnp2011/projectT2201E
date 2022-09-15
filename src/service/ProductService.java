package service;

import dto.Product;

import java.util.List;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-12-2022 23:24
 **/
public interface ProductService {

    Product addPrd(Product input);
    List<Product> findAllByIdPrd();

}
