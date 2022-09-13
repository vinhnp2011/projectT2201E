package dao;

public class NhomHangDao {

    private String ma;

    private String ten;

    private String va;
    private Long maNhomHang;
    private String tenNhomHang;
    private Double vat;




    public NhomHangDao() {
    }

    public NhomHangDao(Long maNhomHang, String tenNhomHang, Double vat) {
        this.maNhomHang = maNhomHang;
        this.ma = String.valueOf(maNhomHang);
        this.tenNhomHang = tenNhomHang;
        this.ten = tenNhomHang;
        this.vat = vat;
        this.va = String.valueOf(vat);
    }

    public Long getMaNhomHang() {
        return maNhomHang;
    }

    public String getTenNhomHang() {
        return tenNhomHang;
    }

    public Double getVat() {
        return vat;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getVa() {
        return va;
    }

    public void setMaNhomHang(Long maNhomHang) {
        this.maNhomHang = maNhomHang;
        this.ma = String.valueOf(maNhomHang);
    }

    public void setTenNhomHang(String tenNhomHang) {
        this.tenNhomHang = tenNhomHang;
        this.ten = tenNhomHang;
    }

    public void setVat(Double vat) {
        this.vat = vat;
        this.va = String.valueOf(vat);
    }
}
