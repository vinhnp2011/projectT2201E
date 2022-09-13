package dao;

public class SanPhamDao {
    private Long      maNhomHang;
    private Long      maVach;
    private Long      maSpham;
    private Long      tenSpham;
    private String    moTa;
    private Long      giaNhap;
    private Long      giaBan;
    private Double    vat;

    public SanPhamDao() {
    }

    public SanPhamDao(Long maNhomHang, Long maVach, Long maSpham, Long tenSpham, String moTa, Long giaNhap, Long giaBan, Double vat) {
        this.maNhomHang = maNhomHang;
        this.maVach = maVach;
        this.maSpham = maSpham;
        this.tenSpham = tenSpham;
        this.moTa = moTa;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.vat = vat;
    }

    public Long getMaNhomHang() {
        return maNhomHang;
    }

    public void setMaNhomHang(Long maNhomHang) {
        this.maNhomHang = maNhomHang;
    }

    public Long getMaVach() {
        return maVach;
    }

    public void setMaVach(Long maVach) {
        this.maVach = maVach;
    }

    public Long getMaSpham() {
        return maSpham;
    }

    public void setMaSpham(Long maSpham) {
        this.maSpham = maSpham;
    }

    public Long getTenSpham() {
        return tenSpham;
    }

    public void setTenSpham(Long tenSpham) {
        this.tenSpham = tenSpham;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Long getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Long giaNhap) {
        this.giaNhap = giaNhap;
    }

    public Long getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Long giaBan) {
        this.giaBan = giaBan;
    }

    public Double getVat() {
        return vat;
    }

    public void setVat(Double vat) {
        this.vat = vat;
    }
}
