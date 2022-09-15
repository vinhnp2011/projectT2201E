package dao;

import dto.Product;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonHangDao {
    private String tenKH;
    private List<Product> dsSpham;
    private LocalDateTime ngayMuahang;
}
