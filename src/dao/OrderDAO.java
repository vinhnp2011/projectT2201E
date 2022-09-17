package dao;

import dto.Product;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDAO {
    private String idOrder;
    private String nameCusOrder;
    private List<Product> lstPrdOrder;
    private Instant dateOrder;
}
