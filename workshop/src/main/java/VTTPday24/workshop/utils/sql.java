package VTTPday24.workshop.utils;


public class sql {
    
    public static final String sql_insertOrder = """
        insert into orders (order_date, customer_name, ship_address, notes, tax)
        values (?,?,?,?,?);
            """;

    public static final String sql_insertOrderDetails = """
            insert into order_details (order_id, product, unit_price, discount, quantity)
            values (?,?,?,?,?);
            """;



}
