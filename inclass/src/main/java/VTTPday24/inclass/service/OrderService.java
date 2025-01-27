package VTTPday24.inclass.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import VTTPday24.inclass.model.PurchaseOrder;
import VTTPday24.inclass.model.exception.OrderException;
import VTTPday24.inclass.repository.LineItemRepository;
import VTTPday24.inclass.repository.PurchaseOrderRepository;

@Service
public class OrderService {
    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;
    
    @Autowired
    private LineItemRepository lineItemRepository;

    @Transactional(rollbackFor = OrderException.class)
    public void createNewOrder(PurchaseOrder po) throws OrderException{
        String orderId= UUID.randomUUID().toString().substring(0, 8);
        System.out.println("Order ID >>>>> %s".formatted(orderId));
        System.out.println(po);
        po.setOrderId(orderId);
        purchaseOrderRepository.insertPurchaseOrder(po);
        
        if(po.getLineItems().size() > 5){
            throw new OrderException("Maximum 5 items allows in an order");
        }

        lineItemRepository.addLineItems(po);

    }   





}
