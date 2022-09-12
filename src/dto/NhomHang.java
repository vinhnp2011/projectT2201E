package dto;

public class NhomHang {
    private Long maNhomHang;
    private String tenNhomHang;
    private Double vat;

    public NhomHang(Long maNhomHang, String tenNhomHang, Double vat) {
        this.maNhomHang = maNhomHang;
        this.tenNhomHang = tenNhomHang;
        this.vat = vat;
    }
}
