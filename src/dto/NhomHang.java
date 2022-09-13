package dto;

public class NhomHang {
    private Long maNhomHang;
    private String tenNhomHang;
    private Double vat;

    public Long getMaNhomHang() {
        return maNhomHang;
    }

    public void setMaNhomHang(Long maNhomHang) {
        this.maNhomHang = maNhomHang;
    }

    public String getTenNhomHang() {
        return tenNhomHang;
    }

    public void setTenNhomHang(String tenNhomHang) {
        this.tenNhomHang = tenNhomHang;
    }

    public Double getVat() {
        return vat;
    }

    public void setVat(Double vat) {
        this.vat = vat;
    }

    public NhomHang() {
    }

    public NhomHang(Long maNhomHang, String tenNhomHang, Double vat) {
        this.maNhomHang = maNhomHang;
        this.tenNhomHang = tenNhomHang;
        this.vat = vat;
    }
}
