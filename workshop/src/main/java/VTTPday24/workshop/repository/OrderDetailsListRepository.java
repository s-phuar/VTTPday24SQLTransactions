package VTTPday24.workshop.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import VTTPday24.workshop.model.Order;
import VTTPday24.workshop.model.OrderDetails;
import VTTPday24.workshop.utils.sql;

@Repository
public class OrderDetailsListRepository {
    
    @Autowired
    JdbcTemplate template;

    public void insertOrderDetails(int orderId, Order order){
        insertOrderDetails(order.getOrderDetails(), orderId);
    }

    public void insertOrderDetails(List<OrderDetails> orderDetails, int orderId){
        //batch update

        List<Object[]> data = orderDetails.stream()
            .map( od -> {
                Object[] obj = new Object[5];
                obj[0] = orderId;
                obj[1] = od.getProduct();
                obj[2] = od.getUnitPrice();
                obj[3] = od.getDiscount();
                obj[4] = od.getQuantity();
                return obj;
            }).toList();

            template.batchUpdate(sql.sql_insertOrderDetails, data);
    }


}
