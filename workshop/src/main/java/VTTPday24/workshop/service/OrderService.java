package VTTPday24.workshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import VTTPday24.workshop.exception.OrderException;
import VTTPday24.workshop.model.Order;
import VTTPday24.workshop.repository.OrderDetailsListRepository;
import VTTPday24.workshop.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailsListRepository orderDetailsRepository;

    @Transactional(rollbackFor = OrderException.class) //rollback on OrderException, as well as RunTimeException
    public void createNewOrder(Order order){

        int orderId = orderRepository.insertNewOrder(order);

        orderDetailsRepository.insertOrderDetails(orderId, order);

    }


}
