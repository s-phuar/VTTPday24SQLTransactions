package VTTPday24.workshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import VTTPday24.workshop.model.Order;
import VTTPday24.workshop.model.OrderDetails;
import VTTPday24.workshop.service.OrderService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    private OrderService orderService;
    
    @PostMapping
    public String postCheckOut(Model model, HttpSession sess){
        List<OrderDetails> orderDetailsList = (List<OrderDetails>) sess.getAttribute("order");

        Order order = (Order) sess.getAttribute("orderObj");

        orderService.createNewOrder(order); //order objects contains up to date orderDetailsList
        model.addAttribute("total", orderDetailsList.size());
        sess.invalidate();

        return "checkout";
    }


}
