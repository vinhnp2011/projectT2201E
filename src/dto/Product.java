package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private String idPrdType;
    private String barcodePrd;
    private String idPrd;
    private String namePrd;
    private String descPrd;
    private Float imPricePrd;
    private Float exPricePrd;
    private Double vat;
    private Boolean isSuccess;
}
