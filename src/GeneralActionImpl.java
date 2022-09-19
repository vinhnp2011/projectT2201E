import dto.*;
import org.apache.commons.lang3.RandomStringUtils;
import service.OrderService;
import service.ProductService;
import service.ProductTypeService;
import service.ReportService;
import service.impl.OrderServiceImpl;
import service.impl.ProductServiceImpl;
import service.impl.ProductTypeServiceImpl;
import service.impl.ReportServiceImpl;
import utils.CommonUtils;
import view.TableView;
import view.TableViewImpl;

import java.time.Instant;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-18-2022 19:47
 **/
public class GeneralActionImpl implements GeneralAction{
    static Scanner sc = new Scanner(System.in);
    ProductTypeService productTypeService = new ProductTypeServiceImpl();
    ProductService productService = new ProductServiceImpl();

    OrderService orderService = new OrderServiceImpl();
    TableView tableView = new TableViewImpl();

    @Override
    public void addAction(String name) {
        switch (name) {
            case CommonUtils.PRODUCT_TYPE:
                ProductType productType = inputPrdType(CommonUtils.ADD_ACTION);
                ProductType resultPrdType = productTypeService.addPrdType(productType);
                tableView.viewProductTypeTable(Arrays.asList(resultPrdType), CommonUtils.ADD_ACTION);
                break;
            case CommonUtils.PRODUCT:
                Product product = inputPrd(CommonUtils.ADD_ACTION);
                Product resultPrd = productService.addPrd(product);
                tableView.viewProductTable(Arrays.asList(resultPrd), CommonUtils.ADD_ACTION);
                break;
            case CommonUtils.ORDER:
                Order order = inputOrder(CommonUtils.ADD_ACTION);
                Order resultOrder = orderService.addOrder(order);

                tableView.viewOrderTable(Arrays.asList(resultOrder), CommonUtils.ADD_ACTION);
                break;
        }
    }


    @Override
    public void findAllAction(String name) {
        switch (name) {
            case CommonUtils.PRODUCT_TYPE:
                tableView.viewProductTypeTable(productTypeService.findAllByIdPrdType(), CommonUtils.FIND_ALL_ACTION);
                break;
            case CommonUtils.PRODUCT:
                tableView.viewProductTable(productService.findAllByIdPrd(), CommonUtils.FIND_ALL_ACTION);
                break;
            case CommonUtils.ORDER:
                List<Order> allOrder = orderService.findAllOrder();
                tableView.viewOrderTable(allOrder, CommonUtils.FIND_ALL_ACTION);
                break;
        }
    }
    @Override
    public void updateAction(String name) {
        switch (name) {
            case CommonUtils.PRODUCT_TYPE:
                ProductType productType = inputPrdType(CommonUtils.UPDATE_ACTION);
                ProductType updatePrdType = productTypeService.updatePrdType(productType);
                tableView.viewProductTypeTable(Arrays.asList(updatePrdType), CommonUtils.UPDATE_ACTION);
                break;
            case CommonUtils.PRODUCT:
                Product product = inputPrd(CommonUtils.UPDATE_ACTION);
                Product updatePrd = productService.updatePrd(product);
                tableView.viewProductTable(Arrays.asList(updatePrd), CommonUtils.UPDATE_ACTION);
                break;
            case CommonUtils.ORDER:
                break;
        }
    }
    @Override
    public void searchAction(String name) {
        switch (name) {
            case CommonUtils.PRODUCT_TYPE:
                ProductType productType = inputPrdType(CommonUtils.SEARCH_ACTION);
                ProductType byIdPrdType = productTypeService.findByIdPrdType(productType);

                tableView.viewProductTypeTable(Arrays.asList(byIdPrdType), CommonUtils.SEARCH_ACTION);
                break;
            case CommonUtils.PRODUCT:
                Product product = inputPrd(CommonUtils.SEARCH_ACTION);
                Product byIdPrd = productService.findByIdPrd(product);
                tableView.viewProductTable(Arrays.asList(byIdPrd), CommonUtils.SEARCH_ACTION);
                break;
            case CommonUtils.ORDER:
                break;
        }
    }
    ReportService reportService = new ReportServiceImpl();
    @Override
    public void reportAction(String namePar, String nameChil) {
        switch (nameChil) {
            case CommonUtils.REPORT_ORDER:
                List<ReportProduct> reportProducts =  reportService.getReportOrder();
                tableView.viewReportTable(reportProducts, CommonUtils.REPORT_ORDER,null);
                break;
            case CommonUtils.REPORT_TOP3:
                System.out.print("Muon lay du lieu thang nao: ");
                int month = Integer.parseInt(sc.nextLine());
//                int month = 9;
                List<ReportProduct> reportProductsTop3Month =  reportService.getTop3MonthOrder(month);
                tableView.viewReportTable(reportProductsTop3Month, CommonUtils.REPORT_TOP3,month);
                break;

        }
    }

    private Order inputOrder(String addAction) {

        Map<String,ProductOrder> productOrderMap = new HashMap<>();
        String idPrd;
        int quantityPerPrd;
        int countPurchasePrd = 0;
        Double totalCash;
        List<Product> lsInput = productService.findAllByIdPrd();
        tableView.viewProductTable(lsInput, CommonUtils.FIND_ALL_ACTION);

        System.out.print("Ban muon lay san pham nao: ");
        System.out.print("** Chu y: ghi ma hang hoa de mua hang!!!");
        while(true){
            System.out.print("Ma hang hoa: ");
            idPrd = sc.nextLine();
            System.out.print("So luong: ");
            quantityPerPrd = Integer.parseInt(sc.nextLine());
            if(productOrderMap.containsKey(idPrd)){
                productOrderMap.get(idPrd).setQuantityPerPrd(productOrderMap.get(idPrd).getQuantityPerPrd() + quantityPerPrd);
            } else {
                ProductOrder productOrder = ProductOrder.builder().idPrd(idPrd).quantityPerPrd(quantityPerPrd).build();
                productOrderMap.put(idPrd,productOrder);
            }
            Boolean isStopPurchase = Boolean.TRUE;
            System.out.print("Ban muon mua gi nua ko (Y/N): ");
            String isStillBuy = sc.nextLine();
            if(isStillBuy.equals("y") || isStillBuy.equals("Y")){
                isStopPurchase = Boolean.FALSE;
            } else if (isStillBuy.equals("n") || isStillBuy.equals("N")) {
            }
            countPurchasePrd++;
            if(Boolean.TRUE.equals(isStopPurchase)){
                break;
            }
        }
        totalCash = productOrderMap.entrySet().stream().mapToDouble(obj -> {
            Product product = productService.findByIdPrd(Product.builder().idPrd(obj.getKey()).build());
            Float price = product.getExPricePrd();
            Float totalCashPerPrd = Float.parseFloat (String.valueOf(obj.getValue().getQuantityPerPrd() * price * (1.0 + product.getVat())));
            return totalCashPerPrd;
        }).sum();
        System.out.println("Ban da mua " + countPurchasePrd + " san pham cua chung toi. Tong tien phai tra la: " + totalCash + " VND ");
        System.out.println("cho xin cai ten: ");
//        String nameCusOrder = "Nguyen Van A";
        String nameCusOrder = sc.nextLine();
        Random random = new Random();
        String idOrder = RandomStringUtils.randomNumeric(5);
        Instant dateOrder = Instant.now();
        Boolean isSuccess = Boolean.TRUE;

        Order order = Order.builder()
                .idOrder(idOrder)
                .nameCusOrder(nameCusOrder)
                .productOrderMap(productOrderMap)
                .dateOrder(dateOrder)
                .isSuccess(isSuccess)
                .build();
        return order;
    }

    private Product inputPrd(String inputType) {
        System.out.print("Danh sach nhom hang: ");
        System.out.println();
        Product product = null;
        String idPrdSearch;
        if (inputType.equals(CommonUtils.SEARCH_ACTION)) {
            System.out.print("Ma san pham: ");
            idPrdSearch = sc.nextLine();
            product = Product.builder().idPrd(idPrdSearch).build();
        } else if (inputType.equals(CommonUtils.ADD_ACTION) || inputType.equals(CommonUtils.UPDATE_ACTION)) {
            String idPrdType = null;
            String idPrd = null;
            if (inputType.equals(CommonUtils.ADD_ACTION)) {
                List<ProductType> lsInput = productTypeService.findAllByIdPrdType();
                tableView.viewProductTypeTable(lsInput, CommonUtils.FIND_ALL_ACTION);
                System.out.print("nhom hang:(Ghi ma so Nhom hang): ");
                idPrdType = sc.nextLine();
                idPrd = CommonUtils.autoGenIdProduct(idPrdType);
            } else {
                System.out.print("Nhap ma san pham: ");
                idPrd = sc.nextLine();
            }
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
            Double vat = Double.parseDouble(sc.nextLine());

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
        }
        validatePrd(product);
        return product;
    }

    private ProductType inputPrdType(String actionType) {
        ProductType productType = new ProductType();
        String idPrdType;
        String getTenNhomHang = "";
        double getVat = 0.0;

//        getIdPrdType = CommonUtils.autoGenIdProdType();

        System.out.print("Ma nhom hang: ");
        idPrdType = sc.nextLine();

        switch (actionType) {
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

        validatePrdType(productType, actionType);

        return productType;
    }

    void validatePrdType(ProductType productType, String action) {
        int countError = 0;

        if (!action.equals(CommonUtils.SEARCH_ACTION)) {
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
