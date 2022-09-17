package dto;

import java.time.LocalDateTime;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String idOrder;
    private String nameCusOrder;
    private List<Product> lstPrdOrder;
    private LocalDateTime dateOrder;

}
