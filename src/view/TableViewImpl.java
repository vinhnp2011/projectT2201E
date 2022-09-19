package view;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestLine;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import dto.Order;
import dto.ProductType;
import dto.Product;
import dto.ReportProduct;
import service.ProductService;
import service.impl.ProductServiceImpl;
import utils.CommonUtils;

import java.lang.reflect.Method;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-13-2022 22:39
 **/
public class TableViewImpl implements TableView {
    ProductService productService = new ProductServiceImpl();

    @Override
    public void viewProductTypeTable(List<ProductType> lsInput, String action) {
        AsciiTable at = new AsciiTable();
        List<String> columns = new ArrayList<>();
        columns.addAll(Arrays.asList("Ma", "Ten", "VAT"));

        Boolean isFindAllAction = Boolean.FALSE;

        switch (action) {
            case CommonUtils.ADD_ACTION:
            case CommonUtils.SEARCH_ACTION:
                checkViewTableNullOrEmptyField(lsInput.get(0));
                break;
            case CommonUtils.FIND_ALL_ACTION:
                isFindAllAction = Boolean.TRUE;
                break;
        }

        if (!(isFindAllAction || lsInput.get(0).getIsSuccess())) {
            columns.add("IsSuccess");
        }
        at.addRule();
        at.addRow(columns);
        at.addRule();

        for (ProductType obj : lsInput) {
            List<String> ValueOfColumnLs = new ArrayList<String>();
            ValueOfColumnLs.addAll(Arrays.asList(
                    valueRow(obj.getIdPrdType()),
                    valueRow(obj.getNamePrdType()),
                    valueRow(obj.getVat().toString())
            ));
            if (!(isFindAllAction || obj.getIsSuccess())) {
                ValueOfColumnLs.add(obj.getIsSuccess().toString());
            }
            at.addRow(ValueOfColumnLs);
            at.addRule();
        }
        at.setTextAlignment(TextAlignment.CENTER);
        CWC_LongestLine cwc = new CWC_LongestLine();
        at.getRenderer().setCWC(cwc);
        System.out.println(at.render());
    }

    @Override
    public void viewProductTable(List<Product> lsInput, String action) {
        AsciiTable at = new AsciiTable();
        List<String> columns = new ArrayList<>();
        columns.addAll(Arrays.asList("MaVach", "MaSpham", "TenSpham", "MoTa", "GiaNhap", "GiaBan", "Vat"));
        Boolean isFindAllAction = Boolean.FALSE;

        switch (action) {
            case CommonUtils.ADD_ACTION:
            case CommonUtils.UPDATE_ACTION:
            case CommonUtils.SEARCH_ACTION:
                checkViewTableNullOrEmptyField(lsInput.get(0));
                break;
            case CommonUtils.FIND_ALL_ACTION:
                isFindAllAction = Boolean.TRUE;
                break;
        }

        if (!(isFindAllAction || lsInput.get(0).getIsSuccess())) {
            columns.add("IsSuccess");
        }

        at.addRule();
        at.addRow(columns);
        at.addRule();
        for (Product obj : lsInput) {
            List<String> ValueOfColumnLs = new ArrayList<>();
            ValueOfColumnLs.addAll(Arrays.asList(
                    valueRow(obj.getBarcodePrd()),
                    valueRow(obj.getIdPrd()),
                    valueRow(obj.getNamePrd()),
                    valueRow(obj.getDescPrd()),
                    valueRow(obj.getImPricePrd().toString()),
                    valueRow(obj.getExPricePrd().toString()),
                    valueRow(obj.getVat().toString())));
            if (!(isFindAllAction || obj.getIsSuccess())) {
                ValueOfColumnLs.add(obj.getIsSuccess().toString());
            }
            at.addRow(ValueOfColumnLs);
            at.addRule();
        }
        at.setTextAlignment(TextAlignment.CENTER);
        CWC_LongestLine cwc = new CWC_LongestLine();
        at.getRenderer().setCWC(cwc);
        System.out.println(at.render());
    }

    @Override
    public void viewReportTable(List<ReportProduct> lsInput, String action, Integer Month) {
        AsciiTable at = new AsciiTable();
        List<String> columns = new ArrayList<>();


        switch (action){
            case CommonUtils.REPORT_ORDER:
                columns.addAll(Arrays.asList("Ten San pham", "Gia dau vao", "Gia dau ra", "So luong da ban", "Doanh thu"));
                break;
            case CommonUtils.REPORT_TOP3:
                System.out.println("TOP 3 So luong san pham Thang " + Month);
                columns.addAll(Arrays.asList(" Top ","Ten San pham", " So luong ban ra  ", "Doanh thu"));
                break;
        }


        at.addRule();
        at.addRow(columns);
        at.addRule();
        int sttTop = 1;
        for (ReportProduct obj : lsInput) {
            List<String> ValueOfColumnLs = new ArrayList<>();

            switch (action){
                case CommonUtils.REPORT_ORDER:
                    ValueOfColumnLs.addAll(Arrays.asList(
                                    valueRow(obj.getNamePrd()),
                                    valueRow(obj.getImPricePrd().toString()),
                                    valueRow(obj.getExPricePrd().toString()),
                                    valueRow(obj.getTotalQuantityPrdPurchase().toString()),
                                    valueRow(obj.getIncome().toString())
                            )
                    );
                    break;
                case CommonUtils.REPORT_TOP3:
                    ValueOfColumnLs.addAll(Arrays.asList(
                                    valueRow(" Top " + sttTop + " "),
                                    valueRow(obj.getNamePrd()),
                                    valueRow(obj.getTotalQuantityPrdPurchase().toString()),
                                    valueRow(obj.getIncome().toString())
                            )
                    );
                    break;
            }
            at.addRow(ValueOfColumnLs);
            at.addRule();
            sttTop++;
        }
        at.setTextAlignment(TextAlignment.CENTER);
        CWC_LongestLine cwc = new CWC_LongestLine();
        at.getRenderer().setCWC(cwc);
        System.out.println(at.render());
    }

    @Override
    public void viewOrderTable(List<Order> lsInput, String action) {
        AsciiTable at = new AsciiTable();
        List<String> columns = new ArrayList<>();
        columns.addAll(Arrays.asList(
                "Id order",
                "  ten khach hang  ",
                "  Ten san pham da dat  ",
                "  thoi gian don hang  "
        ));
        Boolean isFindAllAction = Boolean.FALSE;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")
                .withZone(ZoneId.systemDefault());


        lsInput.stream().forEach(this::checkViewTableNullOrEmptyField);

        switch (action) {
            case CommonUtils.ADD_ACTION:
            case CommonUtils.UPDATE_ACTION:
            case CommonUtils.SEARCH_ACTION:
                checkViewTableNullOrEmptyField(lsInput.get(0));
                break;
            case CommonUtils.FIND_ALL_ACTION:
                isFindAllAction = Boolean.TRUE;
                break;
        }

        if (!(isFindAllAction || lsInput.get(0).getIsSuccess())) {
            columns.add("IsSuccess");
        }

        at.addRule();
        at.addRow(columns);
        at.addRule();
        for (Order obj : lsInput) {
            List<String> valueOfColumnLs = new ArrayList<>();

            valueOfColumnLs.addAll(Arrays.asList(
                    valueRow(obj.getIdOrder()),
                    valueRow(obj.getNameCusOrder()),
                    valueRow(obj.getProductOrderMap().entrySet()
                            .stream().map(stringProductOrderEntry -> {
                                Product byIdPrd = productService.findByIdPrd(Product.builder().idPrd(stringProductOrderEntry.getKey()).build());
                                return byIdPrd.getNamePrd();
                            })
                            .collect(Collectors.joining(", "))
                    ),
                    valueRow(formatter.format(obj.getDateOrder())))
            );
            if (!(isFindAllAction || obj.getIsSuccess())) {
                valueOfColumnLs.add(obj.getIsSuccess().toString());
            }
            at.addRow(valueOfColumnLs);
            at.addRule();
        }
        at.setTextAlignment(TextAlignment.CENTER);
        CWC_LongestLine cwc = new CWC_LongestLine();
        at.getRenderer().setCWC(cwc);
        System.out.println(at.render());
    }

    public String valueRow(String output) {
        return output + "\t \t \t";
    }

    void checkViewTableNullOrEmptyField(Object obj) {
        for (Method method : obj.getClass().getDeclaredMethods()) {
            try {
                obj.getClass().getDeclaredFields();
                boolean set = method.getName().matches("get(.*)");
                if (set) {
                    String typeMethodStr = method.getReturnType().getSimpleName();
                    String getMethodStr = method.getName();
                    if (Objects.isNull(method.invoke(obj))) {
                        switch (typeMethodStr) {
                            case "String":
                                method = obj.getClass().getMethod(getMethodStr.replaceAll("get", "set"), String.class);
                                method.invoke(obj, "N/A");
                                break;
                            case "Double":
                                method = obj.getClass().getMethod(getMethodStr.replaceAll("get", "set"), Double.class);
                                method.invoke(obj, 0.0);
                                break;
                            case "Float":
                                method = obj.getClass().getMethod(getMethodStr.replaceAll("get", "set"), Float.class);
                                method.invoke(obj, 0.0f);
                                break;
                            case "Long":
                                method = obj.getClass().getMethod(getMethodStr.replaceAll("get", "set"), Long.class);
                                method.invoke(obj, 0l);
                                break;
                            case "Boolean":
                                method = obj.getClass().getMethod(getMethodStr.replaceAll("get", "set"), Boolean.class);
                                method.invoke(obj, Boolean.FALSE);
                                break;
                            case "Instant":
                                method = obj.getClass().getMethod(getMethodStr.replaceAll("get", "set"), Instant.class);
                                method.invoke(obj, Instant.parse("1900-01-15T18:35:24.00Z"));
                                break;
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

