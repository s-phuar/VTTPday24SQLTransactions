package VTTPday24.workshop.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import VTTPday24.workshop.exception.OrderException;
import VTTPday24.workshop.model.Order;
import VTTPday24.workshop.utils.sql;

@Repository
public class OrderRepository {

    @Autowired
    private JdbcTemplate template;

    public int insertNewOrder(Order order){
        if(order.getCustomerName().equals("fred")){
            throw new OrderException("no freds allowed");
        }

        template.update(sql.sql_insertOrder, order.getOrderDate(), order.getCustomerName(), order.getShipAddress(), order.getNotes(), order.getTax());

        return template.queryForObject(sql.sql_getLatestId, Integer.class);
    }



    
}
