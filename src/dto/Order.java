package dto;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import dao.ProductOrderDAO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    private String idOrder;
    private String nameCusOrder;
    private Map<String,ProductOrder> productOrderMap = new HashMap<>();
    private Instant dateOrder;
    private Boolean isSuccess;
}
