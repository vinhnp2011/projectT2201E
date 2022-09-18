package service;

import dto.Order;

import java.util.List;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-12-2022 23:24
 **/
public interface OrderService {
    Order addOrder(Order input);
    List<Order> findAllOrder();
}
