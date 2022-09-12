import java.util.ArrayList;
import java.util.stream.Stream;

public class NhomHangDao {
    private Long maNhomHang;

    private String tenNhomHang;
    private Double vat;
    ArrayList<NhomHang> nhomHangs = new ArrayList<>();

    public NhomHangDao() {
    }

    public NhomHangDao(Long maNhomHang, String tenNhomHang, Double vat) {
        this.maNhomHang = maNhomHang;
        this.tenNhomHang = tenNhomHang;
        this.vat = vat;
    }

    void createFakeDataNhomHangDao() {
        int fakeSzDataDefault = 5;
        for (int i = 0; i < fakeSzDataDefault; i++) {
            NhomHang nhomHang = new NhomHang(Long.valueOf(i), "ten nhom hang " + i, 5.0 + Double.valueOf(i));
            nhomHangs.add(nhomHang);
        }
    }
}
