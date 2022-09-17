

import dto.ProductType;
import dto.Product;
import service.DonHangService;
import service.ProductTypeService;
import service.ProductService;
import utils.CommonUtils;
import view.TableView;
import service.impl.DonHangServiceImpl;
import service.impl.ProductTypeServiceImpl;
import service.impl.ProductServiceImpl;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-13-2022 00:30
 **/
public class GeneralAction {
    static Scanner sc = new Scanner(System.in);
    DonHangService donHangService = new DonHangServiceImpl();
    ProductTypeService productTypeService = new ProductTypeServiceImpl();
    ProductService productService = new ProductServiceImpl();
    TableView tableView = new TableView();

    void addAction(String name) {
        switch (name) {
            case CommonUtils.PRODUCT_TYPE:
                ProductType productType = inputPrdType(CommonUtils.ADD_ACTION);
                if (productType.getIsSuccess()) {
                    tableView.viewProductTypeTable(Arrays.asList(productTypeService.addPrdType(productType)),CommonUtils.ADD_ACTION);
                }
                break;
            case CommonUtils.PRODUCT:
                Product product = inputPrd(CommonUtils.ADD_ACTION);
                System.out.println(productService.addPrd(product));
                if (product.getIsSuccess()) {
                    tableView.viewProductTable(Arrays.asList(productService.addPrd(product)),CommonUtils.ADD_ACTION);
                }
                break;
            case CommonUtils.ORDER:

                break;
        }
    }

    void findAllAction(String name) {
        switch (name) {
            case CommonUtils.PRODUCT_TYPE:
                tableView.viewProductTypeTable(productTypeService.findAllByIdPrdType(),CommonUtils.FIND_ALL_ACTION);
                break;
            case CommonUtils.PRODUCT:
                tableView.viewProductTable(productService.findAllByIdPrd(), CommonUtils.FIND_ALL_ACTION);
                break;
            case CommonUtils.ORDER:
//                tableView.viewDonHangTable(donHangService.hienThi());
                break;
        }
    }

    void updateAction(String name) {
        switch (name) {
            case CommonUtils.PRODUCT_TYPE:
//                ProductType productType = inputPrdType(CommonUtils.UPDATE_ACTION);
//                ProductType updatePrdType = productTypeService.updatePrdType(productType);
//                tableView.viewProductTypeTable(Arrays.asList(updatePrdType),CommonUtils.UPDATE_ACTION);
                break;
            case CommonUtils.PRODUCT:
                Product product = inputPrd(CommonUtils.UPDATE_ACTION);
                Product updatePrd = productService.updatePrd(product);
                tableView.viewProductTable(Arrays.asList(updatePrd),CommonUtils.UPDATE_ACTION);
                break;
            case CommonUtils.ORDER:

                break;
        }
    }

    void searchAction(String name) {
        switch (name) {
            case CommonUtils.PRODUCT_TYPE:
                ProductType productType = inputPrdType(CommonUtils.SEARCH_ACTION);
                ProductType byIdPrdType = productTypeService.findByIdPrdType(productType);

                tableView.viewProductTypeTable(Arrays.asList(byIdPrdType),CommonUtils.SEARCH_ACTION);
                break;
            case CommonUtils.PRODUCT:
                Product product = inputPrd(CommonUtils.SEARCH_ACTION);
                Product byIdPrd = productService.findByIdPrd(product);
                tableView.viewProductTable(Arrays.asList(byIdPrd),CommonUtils.SEARCH_ACTION);
                break;
            case CommonUtils.ORDER:
                break;
        }
    }

    private Product inputPrd(String inputType) {
        System.out.print("Danh sach nhom hang: ");
        System.out.println();
        Product product = null;

        switch (inputType){
            case CommonUtils.ADD_ACTION:
                List<ProductType> lsInput = productTypeService.findAllByIdPrdType();
                tableView.viewProductTypeTable(lsInput,CommonUtils.FIND_ALL_ACTION);
                System.out.print("nhom hang:(Ghi ma so Nhom hang): ");
                String idPrdType = sc.nextLine();
                System.out.print("Ma vach: ");
                String barcodePrd = sc.nextLine();
                System.out.print("Ten san pham: ");
                String namePrd = sc.nextLine();
                System.out.print("Mo ta: ");
                String descPrd = sc.nextLine();
                System.out.print("Gia Nhap: ");
                Float imPricePrd = Float.parseFloat(sc.nextLine());
                System.out.print("Gia xuat: ");
                Float exPricePrd = Float.parseFloat(sc.nextLine());
                System.out.print("VAT: ");
                Double vat = Double.parseDouble( sc.nextLine());
                String idPrd = CommonUtils.autoGenIdProduct(idPrdType);
                Boolean isSuccess = Boolean.TRUE;
                product = Product.builder()
                        .idPrdType(idPrdType)
                        .barcodePrd(barcodePrd)
                        .idPrd(idPrd)
                        .namePrd(namePrd)
                        .descPrd(descPrd)
                        .imPricePrd(imPricePrd)
                        .exPricePrd(exPricePrd)
                        .vat(vat)
                        .isSuccess(isSuccess)
                        .build();
                break;
            case CommonUtils.SEARCH_ACTION:
                System.out.print("Ma san pham: ");
                String idPrdTypeSearch = sc.nextLine();
                product = Product.builder()
                        .idPrdType(idPrdTypeSearch)
                        .build();
                break;
        }

        validatePrd(product);
        return product;
    }

    private ProductType inputPrdType(String inputType) {
        ProductType productType = new ProductType();
        String idPrdType;
        String getTenNhomHang = "";
        double getVat = 0.0;

//        getIdPrdType = CommonUtils.autoGenIdProdType();

        System.out.print("Ma nhom hang: ");
        idPrdType = sc.nextLine();

        switch (inputType){
            case CommonUtils.ADD_ACTION:
                System.out.print("Ten nhom hang: ");
                getTenNhomHang = sc.nextLine();

                System.out.print("VAT: ");
                try {
                    getVat = Double.parseDouble(sc.nextLine());
                } catch (RuntimeException e) {
                    System.out.println("error.input.vat: VAT chi duoc phep dien so!");
                    productType.setIsSuccess(Boolean.FALSE);
                    return productType;
                }
                break;
            case CommonUtils.SEARCH_ACTION:
                break;
        }

        productType = ProductType.builder()
                .idPrdType(idPrdType)
                .namePrdType(getTenNhomHang)
                .vat(getVat)
                .isSuccess(Boolean.TRUE)
                .build();

        validatePrdType(productType, CommonUtils.ADD_ACTION);

        return productType;
    }

    void validatePrdType(ProductType productType,String action) {
        int countError = 0;

        if (!action.equals(CommonUtils.SEARCH_ACTION)){
                for (ProductType obj : productTypeService.findAllByIdPrdType()) {
                    if (obj.getIdPrdType().equals(productType.getIdPrdType())) {
                        CommonUtils.errorMess("error.input.idPrdType: Dau vao \"Ma nhom hang\" bi trung! Nhap lai!!");
                        countError++;
                    }
                }

            if (!(productType.getVat() >= 0) || !(productType.getVat() <= 1)) {
                CommonUtils.errorMess("error.input.vat: Dau vao \"VAT\" chi nam trong pham vi tu 0 -> 1!");
                countError++;
            }

            if (Pattern.compile(" ").matcher(productType.getNamePrdType()).find()) {
                CommonUtils.errorMess("error.input.namePrdType: Dau vao \"Ten nhom hang\" Khong duoc co khoang trang!");
                countError++;
            }
        }

        if (countError > 0) {
            productType.setIsSuccess(Boolean.FALSE);
        }
    }

    void validatePrd(Product product) {
        int countError = 0;
        //TODO: tao validate tai day


        if (countError > 0) {
            product.setIsSuccess(Boolean.FALSE);
        }
    }
}
