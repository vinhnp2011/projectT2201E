package view;

import dao.DonHangDao;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestLine;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import dto.ProductType;
import dto.Product;

import java.util.List;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-13-2022 22:39
 **/
public class TableView {
    public void viewNhomHangTable(List<ProductType> lsInput) {
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow("Ma", "Ten", "VAT");
        at.addRule();
        for (ProductType obj : lsInput) {
            if (obj.isEmpty()) {
                at.addRow(
                        valueRow("N/A"),
                        valueRow("N/A"),
                        valueRow("N/A"));
                at.addRule();
            } else {
                at.addRow(valueRow(obj.getIdPrdType().toString()),
                        valueRow(obj.getNamePrdType()),
                        valueRow(obj.getVat().toString()));
                at.addRule();
            }
        }
        at.setTextAlignment(TextAlignment.CENTER);
        CWC_LongestLine cwc = new CWC_LongestLine();
        at.getRenderer().setCWC(cwc);
        System.out.println(at.render());
    }


    public void viewSanPhamTable(List<Product> lsInput) {
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow("MaVach", "MaSpham", "TenSpham", "MoTa", "GiaNhap", "GiaBan", "Vat");
        at.addRule();
        for (Product obj : lsInput) {

            if (obj.isEmpty()) {
                at.addRow(
                        valueRow("N/A"),
                        valueRow("N/A"),
                        valueRow("N/A"),
                        valueRow("N/A"),
                        valueRow("N/A"),
                        valueRow("N/A"),
                        valueRow("N/A"));
                at.addRule();
            } else {
                at.addRow(valueRow(obj.getIdPrdType()),
                        valueRow(obj.getBarcodePrd()),
                        valueRow(obj.getIdPrd()),
                        valueRow(obj.getNamePrd()),
                        valueRow(obj.getDescPrd()),
                        valueRow(obj.getImPricePrd().toString()),
                        valueRow(obj.getExPricePrd().toString()),
                        valueRow(obj.getVat().toString()));
                at.addRule();
            }
        }
        at.setTextAlignment(TextAlignment.CENTER);
        CWC_LongestLine cwc = new CWC_LongestLine();
        at.getRenderer().setCWC(cwc);
        System.out.println(at.render());
    }

    public void viewDonHangTable(List<DonHangDao> lsInput) {
    }

    public String valueRow(String output) {
        return output + " \t \t \t ";
    }
}

