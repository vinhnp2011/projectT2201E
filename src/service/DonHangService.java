package service;

import dao.OrderDAO;
import dto.Order;

import java.util.List;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-12-2022 23:24
 **/
public interface DonHangService{
    Order them(Order input);
    List<OrderDAO> hienThi();
    Order timKiem(Order inputSeach);
    Order capNhat(String name);
}
