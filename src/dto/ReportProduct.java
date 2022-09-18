package dto;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-18-2022 22:35
 **/

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReportProduct {

    private String namePrd;
    private Float imPricePrd;
    private Float exPricePrd;
    private Double vat;
    private Integer totalQuantityPrdPurchase;
    private Double income;

}
