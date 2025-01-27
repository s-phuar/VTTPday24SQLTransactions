package VTTPday24.inclass.utils;

public class sql {

    public static String sqlInsertPO = """
            insert into purchase_order (order_id, name, order_date) 
            values (?, ?, SYSDATE())
            """;
    

    public static String sqlInsertLineItem = """
            insert into line_item (description, quantity, order_id) 
            values (?, ?, ?)
            """;


}
