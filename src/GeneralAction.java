

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
            case CommonUtils.NHOM_HANG:
                ProductType productType = inputPrdType("add");
                if (productType.getIsSuccess()) {
                    tableView.viewNhomHangTable(Arrays.asList(productTypeService.addPrdType(productType)));
                }
                break;
            case CommonUtils.SAN_PHAM:
                Product product = inputPrd("add");

                System.out.println(productService.addPrd(product));
                break;
            case CommonUtils.DON_HANG:

                break;
        }
    }

    void showAction(String name) {
        switch (name) {
            case CommonUtils.NHOM_HANG:
                tableView.viewNhomHangTable(productTypeService.findAllByIdPrdType());
                break;
            case CommonUtils.SAN_PHAM:
                tableView.viewSanPhamTable(productService.findAllByIdPrd());
                break;
            case CommonUtils.DON_HANG:
                tableView.viewDonHangTable(donHangService.hienThi());
                break;
        }
    }

    void updateAction(String name) {
        switch (name) {
            case CommonUtils.NHOM_HANG:
                ProductType nhomHang = inputPrdType("update");
                tableView.viewNhomHangTable(Arrays.asList(productTypeService.updatePrdType(nhomHang)));
                break;
            case CommonUtils.SAN_PHAM:

                break;
            case CommonUtils.DON_HANG:

                break;
        }
    }

    void searchAction(String name) {
        switch (name) {
            case CommonUtils.NHOM_HANG:
                ProductType nhomHang = inputPrdType("search");
                tableView.viewNhomHangTable(Arrays.asList(productTypeService.findByIdPrdType(nhomHang)));
                break;
            case CommonUtils.SAN_PHAM:
                break;
            case CommonUtils.DON_HANG:
                break;
        }
    }

    private Product inputPrd(String inputType) {
        Product product = new Product();

        System.out.print("Danh sach nhom hang:");
        System.out.println();
        List<ProductType> lsInput = productTypeService.findAllByIdPrdType();
        tableView.viewNhomHangTable(lsInput);
        System.out.print("san pham nay thuoc nhom hang nao(Ghi ma so Nhom hang): ");
        String idPrdType = sc.next();

        product.setIdPrdType(idPrdType);

        String idPrd = CommonUtils.autoGenIdProduct(idPrdType);
        product.setIdPrd(idPrd);
        return product;
    }

    private ProductType inputPrdType(String inputType) {
        ProductType productType = new ProductType();
        String idPrdType;
//        getIdPrdType = CommonUtils.autoGenIdProdType();
        System.out.print("Ma nhom hang: ");
        idPrdType = sc.nextLine();
        String getTenNhomHang = "";
        Double getVat = 0.0;
        if (!inputType.equals("search")) {

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
        } else {
            System.out.print("Ma nhom hang: ");
            idPrdType = sc.nextLine();
        }
        productType = new ProductType(idPrdType, getTenNhomHang, getVat, Boolean.TRUE);

        validatePrdType(productType);

        return productType;
    }

    void validatePrdType(ProductType nhomHang) {
        int countError = 0;
        for (ProductType obj : productTypeService.findAllByIdPrdType()) {
            if (obj.getIdPrdType().equals(nhomHang.getIdPrdType())) {
                CommonUtils.errorMess("error.input.idPrdType: Dau vao \"Ma nhom hang\" bi trung! Nhap lai!!");
                countError++;
            }
        }
        if (!(nhomHang.getVat() >= 0) || !(nhomHang.getVat() <= 1)) {
            CommonUtils.errorMess("error.input.vat: Dau vao \"VAT\" chi nam trong pham vi tu 0 -> 1!");
            countError++;
        }
        if (Pattern.compile(" ").matcher(nhomHang.getNamePrdType()).find()) {
            CommonUtils.errorMess("error.input.namePrdType: Dau vao \"Ten nhom hang\" Khong duoc co khoang trang!");
            countError++;
        }
        if (countError > 0) {
            nhomHang.setIsSuccess(Boolean.FALSE);
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
