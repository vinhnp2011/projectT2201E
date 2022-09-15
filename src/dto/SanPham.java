package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SanPham {
    private String maNhomHang;
    private Long maVach;
    private Long maSpham;
    private String maSphamStr;
    private Long tenSpham;
    private String moTa;
    private Long giaNhap;
    private Long giaBan;
    private Double vat;

}
