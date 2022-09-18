package service.impl;

import data.StoreData;
import dto.Order;
import mapper.OrderMapper;

import service.OrderService;


import java.util.List;


/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-12-2022 23:24
 **/
public class OrderServiceImpl implements OrderService {
    StoreData storeData = new StoreData();
    OrderMapper orderMapper = new OrderMapper();


    @Override
    public Order addOrder(Order input) {
        Order result = storeData.save(orderMapper.mapDtoToEntity(input));
        result.setIsSuccess(Boolean.TRUE);
        return result;
    }

    @Override
    public List<Order> findAllOrder() {
        return orderMapper.mapEntitiesToDtos(storeData.getValueOrder());
    }
}
