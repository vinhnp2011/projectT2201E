package dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NhomHangDao {
    private String maNhomHang;
    private String tenNhomHang;
    private Double vat;
}
