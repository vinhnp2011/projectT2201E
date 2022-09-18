package utils;

import data.StoreData;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-12-2022 23:02
 **/
public class CommonUtils {
    public static final String PRODUCT_TYPE = "Nhom hang";
    public static final String PRODUCT = "San pham";
    public static final String ORDER = "Don hang";

    public static final String REPORT = "Bao cao";
    public static final String REPORT_ORDER = "Bao cao Don hang";

    public static final String REPORT_TOP3 = "Bao cao Top 3 san pham ban chay";


    public static final String ADD_ACTION = "ADD_ACTION";
    public static final String FIND_ALL_ACTION = "FIND_ALL_ACTION";
    public static final String SEARCH_ACTION = "SEARCH_ACTION";
    public static final String UPDATE_ACTION = "UPDATE_ACTION";


    public static String autoGenIdProduct(String idPrdType) {
        StringBuffer output = new StringBuffer();
        output.append(idPrdType);
        Integer idIdPrd = StoreData.sizePrd;
        int maxIdPrdLength = 4;
        int nowGenIdPrdLength = idIdPrd.toString().length();
        if (nowGenIdPrdLength <= maxIdPrdLength) {
            Integer x = maxIdPrdLength - nowGenIdPrdLength;

            for (int i = 0; i < x; i++) {
                output.append("0");
            }
        }
        output.append(idIdPrd);
        return output.toString();
    }

    public static String autoGenIdProdType() {
        StringBuffer output = new StringBuffer();
        output.append("NH");
        Integer idIdPrdType = StoreData.sizePrdType;
        Integer prefixIdPrdTypeLength = output.length();
        int maxIdPrdLength = 4;
        int idIdPrdTypeLength = StoreData.sizePrdType.toString().length();

        if (idIdPrdTypeLength <= (maxIdPrdLength - prefixIdPrdTypeLength)) {
            Integer x = maxIdPrdLength - idIdPrdTypeLength - prefixIdPrdTypeLength;

            for (int i = 0; i < x; i++) {
                output.append("0");
            }
        }
        output.append(idIdPrdType);
        return output.toString();
    }

    public static void errorMess(String x) {
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println(x);

        }
    }
}
