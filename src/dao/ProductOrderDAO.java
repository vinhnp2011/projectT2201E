package dao;

import dto.ProductOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductOrderDAO {
    private String idPrd;
    private Integer quantityPerPrd;
}
