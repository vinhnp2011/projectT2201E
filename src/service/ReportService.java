package service;

import dto.ReportProduct;

import java.util.List;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-18-2022 19:12
 **/
public interface ReportService {
    List<ReportProduct> getReportOrder();

    List<ReportProduct> getTop3MonthOrder(Integer month);
}
