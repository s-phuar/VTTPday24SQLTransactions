package VTTPday24.inclass.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import VTTPday24.inclass.model.LineItem;
import VTTPday24.inclass.model.PurchaseOrder;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(path="/cart")
public class CartController {
    @PostMapping
    public String postCart(@RequestBody MultiValueMap<String, String> form, Model model, HttpSession sess){
        //even if the user navigates away from this page or refreshes the page
        //the session will remember the "cart" (the List<LineItem>) until the session expires or is cleared
        List<LineItem> lineItems = (List<LineItem>) sess.getAttribute("cart");
        //You retrieve the lineItems list from the session with sess.getAttribute("cart")
        //This gives you a reference to the list stored in the session.
        //When you add a new LineItem to the list with lineItems.add(...)
        //you're modifying the same list that was initially saved in the session
        //(because Java stores references to objects, not copies of them).

        if(null == lineItems){
            lineItems = new LinkedList<>();
            sess.setAttribute("cart", lineItems);
        }

        //Line items creation section
        String item = form.getFirst("item");
        Integer qty = Integer.parseInt(form.getFirst("quantity"));
        lineItems.add(new LineItem(item, qty));

        PurchaseOrder po = new PurchaseOrder();
        po.setName(form.getFirst("name")); //takes the latest name input
        po.setLineItems(lineItems);//all we are missing at this point is itemId, orderId and orderDate

        for(LineItem li: lineItems){
            System.out.printf("Item: %s, Quantity: %d", li.getDescription(), li.getQuantity());
        }

        sess.setAttribute("checkoutCart", po);
        model.addAttribute("lineItems", lineItems);
    
        return "cart_template";
    }



    
}
