package VTTPday24.workshop.model;

import java.math.BigDecimal;

public class OrderDetails {
    private int id; //not pupulated in controller
    private int fkOrderId; //not populated in controller
    private String product;
    private BigDecimal unitPrice;
    private BigDecimal discount;
    private int quantity;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public int getFkOrderId() {return fkOrderId;}
    public void setFkOrderId(int fkOrderId) {this.fkOrderId = fkOrderId;}    
    public String getProduct() {return product;}
    public void setProduct(String product) {this.product = product;}
    public BigDecimal getUnitPrice() {return unitPrice;}
    public void setUnitPrice(BigDecimal unitPrice) {this.unitPrice = unitPrice;}
    public BigDecimal getDiscount() {return discount;}
    public void setDiscount(BigDecimal discount) {this.discount = discount;}
    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}

    public OrderDetails(String product, BigDecimal unitPrice, BigDecimal discount, int quantity) {
        this.product = product;
        this.unitPrice = unitPrice;
        this.discount = discount;
        this.quantity = quantity;
    }


    

    

}
