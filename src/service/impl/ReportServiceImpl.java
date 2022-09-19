package service.impl;

import dto.Order;
import dto.Product;
import dto.ProductOrder;
import dto.ReportProduct;
import service.OrderService;
import service.ProductService;
import service.ReportService;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-18-2022 22:15
 **/
public class ReportServiceImpl implements ReportService {

    OrderService orderService = new OrderServiceImpl();
    ProductService productService = new ProductServiceImpl();

    @Override
    public List<ReportProduct> getReportOrder() {
        List<ReportProduct> collect;
        List<Order> allOrder = orderService.findAllOrder();
        Map<String, ReportProduct> outputMap = new HashMap<>();
        for (Order order : allOrder) {
            order.getDateOrder();
            Map<String, ProductOrder> productOrderMap = order.getProductOrderMap();
            productOrderMap.entrySet()
                    .stream()
                    .forEach(stringProductOrderEntry -> {
                        String keyReport = stringProductOrderEntry.getKey();
                        String namePrd;
                        Float imPricePrd = 0f;
                        Float exPricePrd = 0f;
                        Double vat = 0.0;
                        Integer totalQuantityPrdPurchase;
                        Double totalIncomePrd = 0.0;
                        if (!outputMap.containsKey(keyReport)) {
                            Product product = productService.findByIdPrd(Product.builder().idPrd(stringProductOrderEntry.getKey()).build());
                            namePrd = product.getNamePrd();
                            imPricePrd = product.getImPricePrd();
                            exPricePrd = product.getExPricePrd();
                            vat = product.getVat();
                            totalQuantityPrdPurchase = productOrderMap.get(keyReport).getQuantityPerPrd();
                        } else {
                            ReportProduct oldReportProduct = outputMap.get(keyReport);
                            namePrd = oldReportProduct.getNamePrd();
                            imPricePrd = oldReportProduct.getImPricePrd();
                            exPricePrd = oldReportProduct.getExPricePrd();
                            vat = oldReportProduct.getVat();

                            Integer addQuantityRp = stringProductOrderEntry.getValue().getQuantityPerPrd();
                            Integer oldQuantityRp = oldReportProduct.getTotalQuantityPrdPurchase();
                            totalQuantityPrdPurchase = addQuantityRp + oldQuantityRp;
                        }

                        ReportProduct valueReport = ReportProduct.builder()
                                .namePrd(namePrd)
                                .imPricePrd(imPricePrd)
                                .exPricePrd(exPricePrd)
                                .vat(vat)
                                .totalQuantityPrdPurchase(totalQuantityPrdPurchase)
                                .income(totalIncomePrd)
                                .build();

                        outputMap.put(keyReport, valueReport);
                    });
        }
        outputMap.entrySet().stream().forEach(stringReportProductEntry -> {
            ReportProduct value = stringReportProductEntry.getValue();
            Float price = value.getExPricePrd();
            Double vat = value.getVat();
            Integer quantity = value.getTotalQuantityPrdPurchase();
            Double totalInComePerPrd = quantity * price * (1.0 + vat);
            value.setIncome(totalInComePerPrd);
            outputMap.put(stringReportProductEntry.getKey(), value);
        });

        collect = outputMap.values().stream().collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<ReportProduct> getTop3MonthOrder(Integer month) {
        List<Order> allOrder = orderService.findAllOrder()
                .stream()
                .filter( order ->
                {
                    if(month.equals(LocalDateTime.ofInstant(order.getDateOrder(), ZoneId.systemDefault()).getMonthValue())){
                        return true;
                    }
                    return false;
                }).collect(Collectors.toList());
        Map<String, ReportProduct> outputMap = new HashMap<>();
        for (Order order : allOrder) {
            order.getDateOrder();
            Map<String, ProductOrder> productOrderMap = order.getProductOrderMap();
            productOrderMap.entrySet()
                    .stream()
                    .forEach(stringProductOrderEntry -> {
                        String keyReport = stringProductOrderEntry.getKey();
                        String namePrd;
                        Float imPricePrd = 0f;
                        Float exPricePrd = 0f;
                        Double vat = 0.0;
                        Integer totalQuantityPrdPurchase;
                        Double totalIncomePrd = 0.0;
                        if (!outputMap.containsKey(keyReport)) {
                            Product product = productService.findByIdPrd(Product.builder().idPrd(stringProductOrderEntry.getKey()).build());
                            namePrd = product.getNamePrd();
                            imPricePrd = product.getImPricePrd();
                            exPricePrd = product.getExPricePrd();
                            vat = product.getVat();
                            totalQuantityPrdPurchase = productOrderMap.get(keyReport).getQuantityPerPrd();
                        } else {
                            ReportProduct oldReportProduct = outputMap.get(keyReport);
                            namePrd = oldReportProduct.getNamePrd();
                            imPricePrd = oldReportProduct.getImPricePrd();
                            exPricePrd = oldReportProduct.getExPricePrd();
                            vat = oldReportProduct.getVat();

                            Integer addQuantityRp = stringProductOrderEntry.getValue().getQuantityPerPrd();
                            Integer oldQuantityRp = oldReportProduct.getTotalQuantityPrdPurchase();
                            totalQuantityPrdPurchase = addQuantityRp + oldQuantityRp;
                        }

                        ReportProduct valueReport = ReportProduct.builder()
                                .namePrd(namePrd)
                                .imPricePrd(imPricePrd)
                                .exPricePrd(exPricePrd)
                                .vat(vat)
                                .totalQuantityPrdPurchase(totalQuantityPrdPurchase)
                                .income(totalIncomePrd)
                                .build();

                        outputMap.put(keyReport, valueReport);
                    });
        }
        outputMap.entrySet().stream().forEach(stringReportProductEntry -> {
            ReportProduct value = stringReportProductEntry.getValue();
            Float price = value.getExPricePrd();
            Double vat = value.getVat();
            Integer quantity = value.getTotalQuantityPrdPurchase();
            Double totalInComePerPrd = quantity * price * (1.0 + vat);
            value.setIncome(totalInComePerPrd);
            outputMap.put(stringReportProductEntry.getKey(), value);
        });

        List collect = outputMap.values().stream().collect(Collectors.toList());
        return buildTop(collect,3);
    }

    public List<ReportProduct> buildTop(List<ReportProduct> lstAll, int num) {
        List<ReportProduct> top = new ArrayList<>();
        lstAll = lstAll.stream().sorted(Comparator.comparing(ReportProduct::getTotalQuantityPrdPurchase).reversed()).collect(Collectors.toList());
        if (lstAll.size() < 5) {
            num = lstAll.size();
        }
        for (int idx = 0; idx < num; idx++) {
            top.add(lstAll.get(idx));
        }

        return top;
    }
}
