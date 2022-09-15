package service.impl;

import dao.ProductDAO;
import data.StoreData;
import dto.Product;
import mapper.ProductMapper;
import service.ProductService;

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
        ProductDAO productDAO = productMapper.mapDtoToEntity(input);
        return  storeData.save(productDAO);
    }

    @Override
    public List<Product> findAllByIdPrd() {
        return productMapper.mapEntitiesToDtos(storeData.getSanPham());
    }

    @Override
    public Product findByIdPrd(Product inputSeach) {
        Optional<ProductDAO> optionalProductDAO = storeData.getSanPham().stream().filter(
                obj -> obj.getIdPrd().equals(inputSeach.getIdPrd())
        ).findFirst();
        if (optionalProductDAO.isEmpty()) {
            return new Product();
        }
        return productMapper.mapEntityToDto(optionalProductDAO.get());
    }

    @Override
    public Product updatePrd(Product inputSeach) {
        return null;
    }
}
