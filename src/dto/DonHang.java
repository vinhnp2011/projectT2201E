package dto;

import java.time.LocalDateTime;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonHang {

    private Long maKH;
    private String tenKH;
    private List<SanPham> dsSpham;
    private LocalDateTime ngayMuahang;

}
