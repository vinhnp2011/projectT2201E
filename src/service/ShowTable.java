package service;

import dao.DonHangDao;
import dao.NhomHangDao;
import dao.SanPhamDao;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestLine;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import dto.DonHang;
import dto.NhomHang;
import dto.SanPham;

import java.util.List;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-13-2022 22:39
 **/
public class ShowTable {
    public void showNhomHangTable(List<NhomHang> lsInput) {
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow("Ma", "Ten", "VAT");
        at.addRule();
        for (NhomHang obj : lsInput) {
            at.addRow(valueRow(obj.getMaNhomHang().toString()),
                      valueRow(obj.getTenNhomHang()),
                      valueRow(obj.getVat().toString()));
            at.addRule();
        }
        at.setTextAlignment(TextAlignment.CENTER);
        CWC_LongestLine cwc = new CWC_LongestLine();
        at.getRenderer().setCWC(cwc);
        System.out.println(at.render());
    }


    public void showSanPhamTable(List<SanPhamDao> lsInput) {
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow("Ma", "Ten", "VAT");
        at.addRule();
        for (SanPhamDao obj : lsInput) {
            at.addRow(valueRow(obj.getMaNhomHang().toString()),
                      valueRow(obj.getMaVach().toString()),
                      valueRow(obj.getMaSpham().toString()),
                      valueRow(obj.getTenSpham().toString()),
                      valueRow(obj.getMoTa()),
                      valueRow(obj.getGiaNhap().toString()),
                      valueRow(obj.getGiaBan().toString()),
                      valueRow(obj.getVat().toString()));
            at.addRule();
        }
        at.setTextAlignment(TextAlignment.CENTER);
        CWC_LongestLine cwc = new CWC_LongestLine();
        at.getRenderer().setCWC(cwc);
        System.out.println(at.render());
    }

    public void showDonHangTable(List<DonHangDao> lsInput) {
    }

    public String valueRow(String output) {
        return output + " \t \t \t ";
    }
}

