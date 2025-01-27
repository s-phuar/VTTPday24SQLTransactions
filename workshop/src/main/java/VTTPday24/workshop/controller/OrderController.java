package VTTPday24.workshop.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import VTTPday24.workshop.model.Order;
import VTTPday24.workshop.model.OrderDetails;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping
public class OrderController {

    //invalidates sess if you choose to
    @GetMapping("/")
    public String newOrder(HttpSession sess){
        sess.invalidate();
        return "index";
    }
    

    @PostMapping("/order")
    public String postOrder(@RequestBody MultiValueMap<String, String> form, Model model, HttpSession sess) throws ParseException{
        List<OrderDetails> orderDetailsList = (List<OrderDetails>) sess.getAttribute("order");
        
        if(null == orderDetailsList){
            orderDetailsList = new LinkedList<>();
            sess.setAttribute("order", orderDetailsList);
        }

        //create orderDetails first
        String product = form.getFirst("product");
        BigDecimal price = new BigDecimal(form.getFirst("price"));
        BigDecimal discount = new BigDecimal(form.getFirst("discount"));
        int quantity = Integer.parseInt(form.getFirst("quantity"));
        orderDetailsList.add(new OrderDetails(product, price, discount, quantity));

        Order order = new Order();
        order.setOrderDate(Order.strToDate(form.getFirst("date")));
        order.setCustomerName(form.getFirst("name"));
        order.setShipAddress(form.getFirst("address"));
        order.setNotes(form.getFirst("comments"));
        order.setTax(new BigDecimal(form.getFirst("tax")));
        order.setOrderDetails(orderDetailsList); //list gets updated automatically

        for(OrderDetails od: orderDetailsList){
            System.out.printf("Product: %s, Price: %f, Discount: %f, Qty: %d", od.getProduct(), od.getUnitPrice(), od.getDiscount(), od.getQuantity());
        }

        sess.setAttribute("orderObj", order);
        model.addAttribute("orderDetailsList", orderDetailsList);

        return "order_details_template";
    }



}
