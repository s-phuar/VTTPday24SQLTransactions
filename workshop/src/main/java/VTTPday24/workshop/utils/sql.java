package VTTPday24.workshop.utils;


public class sql {
    
    public static final String sql_insertOrder = """
        INSERT INTO orders (order_date, customer_name, ship_address, notes, tax) 
        VALUES (?, ?, ?, ?, ?)
            """;

    public static final String sql_getLatestId = """
        SELECT LAST_INSERT_ID()
            """;

    

    public static final String sql_insertOrderDetails = """
            insert into order_details (order_id, product, unit_price, discount, quantity)
            values (?,?,?,?,?)
            """;



}
