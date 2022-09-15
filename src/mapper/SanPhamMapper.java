package mapper;

import dao.ProductDAO;
import dto.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-13-2022 23:25
 **/
public class SanPhamMapper {

    public Product mapEntityToDto(ProductDAO productDAO) {
        Product product = new Product();
        product.setIdPrdType(productDAO.getIdPrdType());
        product.setBarcodePrd(productDAO.getBarcodePrd());
        product.setIdPrd(productDAO.getIdPrd());
        product.setNamePrd(productDAO.getNamePrd());
        product.setDescPrd(productDAO.getDescPrd());
        product.setImPricePrd(productDAO.getImPricePrd());
        product.setExPricePrd(productDAO.getExPricePrd());
        product.setVat(productDAO.getVat());
        return product;
    }

    public ProductDAO mapDtoToEntity(Product product) {
        ProductDAO productDAO = new ProductDAO();
        productDAO.setIdPrdType(product.getIdPrdType());
        productDAO.setBarcodePrd(product.getBarcodePrd());
        productDAO.setIdPrd(product.getIdPrd());
        productDAO.setNamePrd(product.getNamePrd());
        productDAO.setDescPrd(product.getDescPrd());
        productDAO.setImPricePrd(product.getImPricePrd());
        productDAO.setExPricePrd(product.getExPricePrd());
        productDAO.setVat(product.getVat());
        return productDAO;
    }

    public List<Product> mapEntitiesToDtos(List<ProductDAO> productDAOS) {
        List<Product> sanPhamlist = new ArrayList<>();
        for (ProductDAO productDAO : productDAOS) {
            sanPhamlist.add(mapEntityToDto(productDAO));
        }
        return sanPhamlist;
    }

    public List<ProductDAO> mapDtosToEntities(List<Product> productList) {
        List<ProductDAO> sanPhamDaolist = new ArrayList<>();
        for (Product product : productList) {
            sanPhamDaolist.add(mapDtoToEntity(product));
        }
        return sanPhamDaolist;

    }


}
