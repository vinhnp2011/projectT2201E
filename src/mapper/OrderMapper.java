package mapper;

import dao.OrderDAO;
import dto.Order;
import dto.Product;
import dto.ProductOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-18-2022 18:06
 **/
public class OrderMapper {

    public Order mapEntityToDto(OrderDAO orderDAO) {
        Order order = new Order();
        order.setIdOrder(orderDAO.getIdOrder());
        order.setNameCusOrder(orderDAO.getNameCusOrder());
        order.setProductOrderMap(orderDAO.getProductOrderMap());
        order.setDateOrder(orderDAO.getDateOrder());
        return order;

    }


    public OrderDAO mapDtoToEntity(Order order) {
        OrderDAO orderDAO = new OrderDAO();
        orderDAO.setIdOrder(order.getIdOrder());
        orderDAO.setNameCusOrder(order.getNameCusOrder());
        orderDAO.setProductOrderMap(order.getProductOrderMap());
        orderDAO.setDateOrder(order.getDateOrder());
        return orderDAO;

    }

    public List<Order> mapEntitiesToDtos(List<OrderDAO> orderDAOList) {
        List<Order> orderlist=new ArrayList<>();
        for (OrderDAO orderDAO :orderDAOList) {
        	orderlist.add(mapEntityToDto(orderDAO));
        }
        return orderlist;
    }

    public List<OrderDAO> mapDtosToEntities(List<Order> orderList) {
        List<OrderDAO> orderDAOlist=new ArrayList<>();
        for (Order order :orderList) {
        	orderDAOlist.add(mapDtoToEntity(order));
        }
        return orderDAOlist;
    }


}
