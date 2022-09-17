package dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDAO {
    private String idPrdType;
    private String barcodePrd;
    private String idPrd;
    private String namePrd;
    private String descPrd;
    private Float imPricePrd;
    private Float exPricePrd;
    private Double vat;

}
