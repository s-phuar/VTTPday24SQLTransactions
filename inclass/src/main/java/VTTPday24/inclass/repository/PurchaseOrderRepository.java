package VTTPday24.inclass.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import VTTPday24.inclass.model.PurchaseOrder;
import VTTPday24.inclass.utils.sql;


//https://canvas.nus.edu.sg/courses/69096/discussion_topics/285920

@Repository
public class PurchaseOrderRepository {
    @Autowired
    private JdbcTemplate template;

    public boolean insertPurchaseOrder(PurchaseOrder po){
        return template.update(sql.sqlInsertPO, po.getOrderId(), po.getName()) > 0;
    }

}
