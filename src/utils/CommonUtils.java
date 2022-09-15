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
        Integer a = StoreData.sizeSanPham;
        int maxIdPrdLength = 4;
        int nowGenIdPrd = a.toString().length();

        if(nowGenIdPrd <= maxIdPrdLength){
            Integer x = maxIdPrdLength - nowGenIdPrd;

            for (int i = 0; i < x; i++) {
                output.append("0");
            }
        }
        output.append(a);
        return output.toString();
    }

    public static String autoGenIdProdType(){
        StringBuffer output = new StringBuffer();
        output.append("NH");
        Integer a = StoreData.sizeNhomHang;
        int maxIdPrdLength = 4;
        int nowGenIdPrd = a.toString().length();

        if(nowGenIdPrd <= maxIdPrdLength){
            Integer x = maxIdPrdLength - nowGenIdPrd;

            for (int i = 0; i < x; i++) {
                output.append("0");
            }
        }
        output.append(a);
        return output.toString();
    }
}
