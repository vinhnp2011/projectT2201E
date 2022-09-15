

import dto.NhomHang;
import service.DonHangService;
import service.NhomHangService;
import service.SanPhamService;
import utils.CommonUtils;
import view.TableView;
import service.impl.DonHangServiceImpl;
import service.impl.NhomHangServiceImpl;
import service.impl.SanPhamServiceImpl;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-13-2022 00:30
 **/
public class GeneralAction {
    static Scanner sc = new Scanner(System.in);
    DonHangService donHangService = new DonHangServiceImpl();
    NhomHangService nhomHangService = new NhomHangServiceImpl();
    SanPhamService sanPhamService = new SanPhamServiceImpl();
    TableView tableView = new TableView();

    public GeneralAction() {

    }

    void addAction(String name) {
        switch (name) {
            case CommonUtils.NHOM_HANG:
                NhomHang nhomHang = inputNhomHang("add");

                tableView.viewNhomHangTable(Arrays.asList(nhomHangService.them(nhomHang)));
                break;
            case CommonUtils.SAN_PHAM:

                break;
            case CommonUtils.DON_HANG:

                break;
        }
    }

    private NhomHang inputNhomHang(String inputType) {
        Long getMaNhomHang;
        String getTenNhomHang;
        Double getVat;
        System.out.print("Ma nhom hang: ");
         getMaNhomHang = sc.nextLong();
        if(!inputType.equals("search")) {
            System.out.print("Ten nhom hang: ");
            getTenNhomHang = sc.next();

            System.out.print("vat: ");
            getVat = sc.nextDouble();
        }else {
            getTenNhomHang ="";
            getVat = 0.0;
        }
        System.out.println();

        return new NhomHang(getMaNhomHang,getTenNhomHang,getVat);
    }

    void showAction(String name) {
        switch (name) {
            case CommonUtils.NHOM_HANG:
                tableView.viewNhomHangTable(nhomHangService.hienThi());
                break;
            case CommonUtils.SAN_PHAM:
                tableView.viewSanPhamTable(sanPhamService.hienThi());
                break;
            case CommonUtils.DON_HANG:
                tableView.viewDonHangTable(donHangService.hienThi());
                break;
        }
    }

    void updateAction(String name) {
        switch (name) {
            case CommonUtils.NHOM_HANG:
                NhomHang nhomHang = inputNhomHang("update");
                tableView.viewNhomHangTable(Arrays.asList(nhomHangService.capNhat(nhomHang)));
                break;
            case CommonUtils.SAN_PHAM:

                break;
            case CommonUtils.DON_HANG:

                break;
        }
    }

    void searchAction(String name) {
        switch (name) {
            case CommonUtils.NHOM_HANG:
                NhomHang nhomHang = inputNhomHang("search");
                tableView.viewNhomHangTable(Arrays.asList(nhomHangService.timKiem(nhomHang)));
                break;
            case CommonUtils.SAN_PHAM:
                break;
            case CommonUtils.DON_HANG:
                break;
        }
    }
}
