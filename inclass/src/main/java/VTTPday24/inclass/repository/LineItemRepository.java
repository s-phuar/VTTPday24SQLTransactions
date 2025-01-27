package VTTPday24.inclass.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import VTTPday24.inclass.model.LineItem;
import VTTPday24.inclass.model.PurchaseOrder;
import VTTPday24.inclass.utils.sql;

@Repository
public class LineItemRepository {
    @Autowired
    private JdbcTemplate template;


    public void addLineItems(PurchaseOrder po){
        addLineItems(po.getLineItems(), po.getOrderId());
    }

    public void addLineItems(List<LineItem> lineItems, String orderId){
        List<Object[]> data = lineItems.stream()
            .map(i -> {
                Object[] obj = new Object[3];
                obj[0] = i.getDescription();
                obj[1] = i.getQuantity();
                obj[2] = orderId;
                return obj;
            }).toList();
            template.batchUpdate(sql.sqlInsertLineItem, data);
    }



}
