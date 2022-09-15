package utils;

import data.StoreData;

import java.util.Random;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-12-2022 23:02
 **/
public class CommonUtils {
    public static final String NHOM_HANG = "Nhom hang";
    public static final String SAN_PHAM = "San pham";
    public static final String DON_HANG = "Don hang";

    public static String autoGenIdProduct(String idPrdType){
        StringBuffer output = new StringBuffer();
        output.append(idPrdType);
        Integer idIdPrd = StoreData.sizeSanPham;
        int maxIdPrdLength = 4;
        int nowGenIdPrdLength = idIdPrd.toString().length();
        if(nowGenIdPrdLength <= maxIdPrdLength){
            Integer x = maxIdPrdLength - nowGenIdPrdLength;

            for (int i = 0; i < x; i++) {
                output.append("0");
            }
        }
        output.append(idIdPrd);
        return output.toString();
    }

    public static String autoGenIdProdType(){
        StringBuffer output = new StringBuffer();
        output.append("NH");
        Integer idIdPrdType = StoreData.sizeNhomHang;
        Integer prefixIdPrdTypeLength = output.length();
        int maxIdPrdLength = 4;
        int idIdPrdTypeLength = StoreData.sizeNhomHang.toString().length();

        if(idIdPrdTypeLength <= (maxIdPrdLength - prefixIdPrdTypeLength)){
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
