package data;

import dao.NhomHangDao;
import dto.NhomHang;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-12-2022 23:58
 **/
public class FakeData {
    StoreData storeData = new StoreData();

    public FakeData() {
        createFakeDataNhomHangDao();
    }

    public void createFakeDataNhomHangDao() {
        int fakeSzDataDefault = 5;
        for (int i = 0; i < fakeSzDataDefault; i++) {
            NhomHangDao nhomHangDao = new NhomHangDao(Long.valueOf(i), "Ten nhom hang " + i, 5.0 + Double.valueOf(i));
            storeData.save(nhomHangDao);
        }
    }
}
