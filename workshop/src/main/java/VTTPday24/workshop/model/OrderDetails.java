package VTTPday24.workshop.model;

import java.math.BigDecimal;

public class OrderDetails {
    private int id;
    private int orderId;
    private String product;
    private BigDecimal unitPrice;
    private BigDecimal discount;
    private int quantity;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public int getOrderId() {return orderId;}
    public void setOrderId(int orderId) {this.orderId = orderId;}
    public String getProduct() {return product;}
    public void setProduct(String product) {this.product = product;}
    public BigDecimal getUnitPrice() {return unitPrice;}
    public void setUnitPrice(BigDecimal unitPrice) {this.unitPrice = unitPrice;}
    public BigDecimal getDiscount() {return discount;}
    public void setDiscount(BigDecimal discount) {this.discount = discount;}
    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}


    

}
