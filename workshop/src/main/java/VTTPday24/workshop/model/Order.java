package VTTPday24.workshop.model;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Order {
    private int orderId; //not populated in controller
    private Date orderDate;
    private String customerName;
    private String shipAddress;
    private String notes;
    private BigDecimal tax;
    private List<OrderDetails> orderDetails = new LinkedList<OrderDetails>();

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
    public List<OrderDetails> getOrderDetails() {return orderDetails;}
    public void setOrderDetails(List<OrderDetails> orderDetails) {this.orderDetails = orderDetails;}
    
    
    

     public static Date strToDate(String date) throws ParseException{
        Date convertedDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        // Date convertedDate = new SimpleDateFormat("EEE, MM/dd/yyyy").parse(date);    

        // Use a pattern that includes both date and time
            // SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // For example: "2025-01-20 14:30:00"
        
        // If the string has milliseconds, use this pattern: "yyyy-MM-dd HH:mm:ss.SSS"
            // SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");


        //if I want to have nanosecond, need to use a mix of java.Time.Instant + java.sql.TimeStamp
            //java.time.Instant
                // Get the current instant with nanosecond precision
                    // Instant instant = Instant.now();
                // Get the epoch second and nanoseconds
                    // long epochSecond = instant.getEpochSecond(); // seconds since the Unix epoch
                    // int nanos = instant.getNano(); // nanoseconds part
            //convert to java.sql.Timestamp
                // Convert to Timestamp
                    // Timestamp timestamp = Timestamp.from(instant);
                // Print the Timestamp
                    // System.out.println("Current Timestamp: " + timestamp);
                    // Current Timestamp: 2025-01-20 14:30:00.123456789
                // You can also access the nanosecond part via getNanos()
                    // System.out.println("Nanoseconds part: " + timestamp.getNanos());
                    // Nanoseconds part: 123456789
                
        return convertedDate;
    }


}
