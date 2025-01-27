package VTTPday24.inclass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import VTTPday24.inclass.model.LineItem;
import VTTPday24.inclass.model.PurchaseOrder;
import VTTPday24.inclass.model.exception.OrderException;
import VTTPday24.inclass.service.OrderService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(path="/checkout")
public class CheckOutController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public String postCheckout(Model model, HttpSession sess) throws OrderException{
        List<LineItem> lineItems = (List<LineItem>)sess.getAttribute("cart");

        PurchaseOrder po = (PurchaseOrder) sess.getAttribute(("checkoutCart"));
        System.out.println(po);

        orderService.createNewOrder(po);
        sess.invalidate();
        model.addAttribute("total", lineItems.size());

        return "checkout";

    }



}
