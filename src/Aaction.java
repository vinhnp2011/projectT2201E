import com.bethecoder.ascii_table.impl.CollectionASCIITableAware;
import com.bethecoder.ascii_table.spec.IASCIITableAware;
import dao.NhomHangDao;
import service.DonHangService;
import service.NhomHangService;
import service.SanPhamService;
import service.impl.DonHangServiceImpl;
import service.impl.NhomHangServiceImpl;
import service.impl.SanPhamServiceImpl;

import com.bethecoder.ascii_table.ASCIITable;

import java.util.Arrays;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-13-2022 00:30
 **/
public class Aaction {

    DonHangService donHangService = new DonHangServiceImpl();
    NhomHangService nhomHangService = new NhomHangServiceImpl();
    SanPhamService sanPhamService = new SanPhamServiceImpl();

    public Aaction() {

    }


    void addAction(String name) {
        switch (name) {
            case utils.NHOM_HANG:

                break;
            case utils.SAN_PHAM:

                break;
            case utils.DON_HANG:

                break;
        }
    }

     void showAction(String name) {
        switch (name) {
            case utils.NHOM_HANG:


                IASCIITableAware      asciiTableAware =
                        new CollectionASCIITableAware<NhomHangDao>(nhomHangService.hienThi(),
                                "ma", "ten", "VAT");
                ASCIITable.getInstance().printTable(asciiTableAware);
                break;
            case utils.SAN_PHAM:
                sanPhamService.hienThi();
                break;
            case utils.DON_HANG:
                donHangService.hienThi();
                break;
        }
    }

    static void updateAction(String name) {
        switch (name) {
            case utils.NHOM_HANG:

                break;
            case utils.SAN_PHAM:

                break;
            case utils.DON_HANG:

                break;
        }
    }

    static void searchAction(String name) {
        switch (name) {
            case utils.NHOM_HANG:

                break;
            case utils.SAN_PHAM:

                break;
            case utils.DON_HANG:

                break;
        }
    }
}
