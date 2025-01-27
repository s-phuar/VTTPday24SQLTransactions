package VTTPday24.workshop.model;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private int orderId;
    private Date orderDate;
    private String customerName;
    private String shipAddress;
    private String notes;
    private BigDecimal tax;

    public int getOrderId() {return orderId;}
    public void setOrderId(int orderId) {this.orderId = orderId;}
    public Date getOrderDate() {return orderDate;}
    public void setOrderDate(Date orderDate) {this.orderDate = orderDate;}
    public String getCustomerName() {return customerName;}
    public void setCustomerName(String customerName) {this.customerName = customerName;}
    public String getShipAddress() {return shipAddress;}
    public void setShipAddress(String shipAddress) {this.shipAddress = shipAddress;}
    public String getNotes() {return notes;}
    public void setNotes(String notes) {this.notes = notes;}
    public BigDecimal getTax() {return tax;}
    public void setTax(BigDecimal tax) {this.tax = tax;}
    
    
    

}
