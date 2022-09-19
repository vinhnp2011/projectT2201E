package view;

import dto.Order;
import dto.Product;
import dto.ProductType;
import dto.ReportProduct;

import java.util.List;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-18-2022 19:18
 **/
public interface TableView {
    void viewProductTypeTable(List<ProductType> lsInput, String action);

    void viewProductTable(List<Product> lsInput, String action);

    void viewOrderTable(List<Order> lsInput, String action);
    void viewReportTable(List<ReportProduct> lsInput, String action, Integer Month);
}
