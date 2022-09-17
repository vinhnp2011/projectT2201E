package view;

import dao.OrderDAO;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestLine;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import dto.ProductType;
import dto.Product;
import utils.CommonUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-13-2022 22:39
 **/
public class TableView {
    public void viewProductTypeTable(List<ProductType> lsInput,String action) {
        AsciiTable at = new AsciiTable();
        List<String> columns = new ArrayList<>();
        columns.addAll(Arrays.asList("Ma", "Ten", "VAT"));

        Boolean isFindAllAction = Boolean.FALSE;

        switch (action){
            case CommonUtils.ADD_ACTION:
            case CommonUtils.SEARCH_ACTION:
                CheckViewTableNullOrEmptyField(lsInput.get(0));
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
            List ValueOfColumnLs = new ArrayList();
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


    public void viewProductTable(List<Product> lsInput, String action) {
        AsciiTable at = new AsciiTable();
        List<String> columns = new ArrayList<>();
        columns.addAll(Arrays.asList("MaVach", "MaSpham", "TenSpham", "MoTa", "GiaNhap", "GiaBan", "Vat"));
        Boolean isFindAllAction = Boolean.FALSE;

        if (action.equals(CommonUtils.ADD_ACTION)) {
            CheckViewTableNullOrEmptyField(lsInput.get(0));
        }

        if (action.equals(CommonUtils.FIND_ALL_ACTION)) {
            isFindAllAction = Boolean.TRUE;
        }

        if (!(isFindAllAction || lsInput.get(0).getIsSuccess())) {
            columns.add("IsSuccess");
        }

        at.addRule();
        at.addRow(columns);
        at.addRule();
        for (Product obj : lsInput) {
            List ValueOfColumnLs = new ArrayList();
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

    public void viewOrderTable(List<OrderDAO> lsInput) {
//        AsciiTable at = new AsciiTable();
//        at.addRule();
//        at.addRow("MaNhomHang", "MaVach", "MaSpham", "TenSpham", "MoTa", "GiaNhap", "GiaBan", "Vat");
//        at.addRule();
//        for (Product obj : lsInput) {
//            CheckNullFieldProduct(obj);
//            at.addRow(valueRow(obj.getIdPrdType()),
//                    valueRow(obj.getBarcodePrd()),
//                    valueRow(obj.getIdPrd()),
//                    valueRow(obj.getNamePrd()),
//                    valueRow(obj.getDescPrd()),
//                    valueRow(obj.getImPricePrd().toString()),
//                    valueRow(obj.getExPricePrd().toString()),
//                    valueRow(obj.getVat().toString()));
//            at.addRule();
//        }
//        at.setTextAlignment(TextAlignment.CENTER);
//        CWC_LongestLine cwc = new CWC_LongestLine();
//        at.getRenderer().setCWC(cwc);
//        System.out.println(at.render());
    }

    public String valueRow(String output) {
        return output + "\t \t \t";
    }

    void CheckViewTableNullOrEmptyField(Object obj) {
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
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

