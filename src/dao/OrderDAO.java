package dao;

import dto.Product;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dto.ProductOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDAO {
    private String idOrder;
    private String nameCusOrder;
    private Map<String,ProductOrder> productOrderMap = new HashMap<>();
    private Instant dateOrder;
}
