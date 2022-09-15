package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

    public boolean isEmpty() {
        for (Field field : this.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                if (field.get(this) != null) {
                    return false;
                }
            } catch (Exception e) {
                System.out.println("ERROR SanPham.isEmpty()");
            }
        }
        return true;
    }

}
