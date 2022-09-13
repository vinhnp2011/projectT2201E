

import dao.NhomHangDao;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestLine;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import dto.NhomHang;
import dto.SanPham;
import service.DonHangService;
import service.NhomHangService;
import service.SanPhamService;
import service.ShowTable;
import service.impl.DonHangServiceImpl;
import service.impl.NhomHangServiceImpl;
import service.impl.SanPhamServiceImpl;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-13-2022 00:30
 **/
public class Aaction {

    DonHangService donHangService = new DonHangServiceImpl();
    NhomHangService nhomHangService = new NhomHangServiceImpl();
    SanPhamService sanPhamService = new SanPhamServiceImpl();
    ShowTable showTable = new ShowTable();

    public Aaction() {

    }




    void addAction(String name) {
        switch (name) {
            case utils.NHOM_HANG:
                Scanner sc = new Scanner(System.in);
                NhomHang nhomHang = new NhomHang();

                System.out.print("Ma nhom hang: ");
                Long getMaNhomHang = sc.nextLong();

                System.out.print("Ten nhom hang: ");
                String getTenNhomHang = sc.next();

                System.out.print("vat: ");
                Double getVat = sc.nextDouble();

                nhomHang.setMaNhomHang(getMaNhomHang);
                nhomHang.setTenNhomHang(getTenNhomHang);
                nhomHang.setVat(getVat);
                System.out.println();
//                nhomHangService.them(nhomHang);
                showTable.showNhomHangTable(Arrays.asList(nhomHangService.them(nhomHang)));
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
                showTable.showNhomHangTable(nhomHangService.hienThi());
                break;
            case utils.SAN_PHAM:
                showTable.showSanPhamTable(sanPhamService.hienThi());
                break;
            case utils.DON_HANG:
                showTable.showDonHangTable(donHangService.hienThi());
                break;
        }
    }

    void updateAction(String name) {
        switch (name) {
            case utils.NHOM_HANG:

                break;
            case utils.SAN_PHAM:

                break;
            case utils.DON_HANG:

                break;
        }
    }

    void searchAction(String name) {
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
