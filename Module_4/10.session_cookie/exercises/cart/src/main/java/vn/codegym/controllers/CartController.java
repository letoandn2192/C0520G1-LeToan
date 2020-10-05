package vn.codegym.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.codegym.model.Cart;
import vn.codegym.model.CartItems;
import vn.codegym.model.Product;
import vn.codegym.service.ProductService;

import java.util.Map;

@Controller
@RequestMapping("cart")
@SessionAttributes({"cartItems", "totalMoney"})
public class CartController {
    @Autowired
    private ProductService productService;

    @ModelAttribute("cartItems")
    public CartItems getCart() {
        return new CartItems();
    }

    @GetMapping
    public String getCartPage(@ModelAttribute("cartItems") CartItems cartItems, Model model) {
        model.addAttribute("cartItems", cartItems);
        return "cart/list";
    }

    @PostMapping("/buy")
    public String addProductIntoCart(@ModelAttribute(value = "cartItems") CartItems cartItems, @RequestParam("id") long id, Model model) {
        Product product = productService.findById(id);
        if (product != null) {
            if (cartItems.containsKey(id)) {
                Cart item =cartItems.get(id);
                item.setProduct(product);
                item.setQuantity(item.getQuantity() + 1);
                cartItems.put(id, item);
            } else {
                Cart item = new Cart();
                item.setProduct(product);
                item.setQuantity(1);
                cartItems.put(id, item);
            }
        }
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("totalMoney", totalPrice(cartItems));
        return "cart/list";
    }

    @GetMapping("/remove/{id}")
    public String removeProductFromCart(@ModelAttribute(value = "cartItems") CartItems cartItems, @PathVariable("id") long id, Model model) {
        if (cartItems.containsKey(id)) {
            cartItems.remove(id);
        }
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("totalMoney", totalPrice(cartItems));
        return "cart/list";
    }

    @GetMapping("/edit")
    public String updateCartInfo(@ModelAttribute(value = "cartItems") CartItems cartItems, @RequestParam("edit") int[] quantityList, Model model) {
        int count = 0;
        for (long key : cartItems.keySet()) {
            if (count < cartItems.size()) {
                cartItems.get(key).setQuantity(quantityList[count]);
                cartItems.put(key, cartItems.get(key));
                count++;
            }
        }
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("totalMoney", totalPrice(cartItems));
        return "cart/list";
    }

    @GetMapping("/deleteAll")
    public String deleteAllProduct(Model model) {
//        for (long key: cartItems.keySet()) {
//            cartItems.remove(key);
//        }
        model.addAttribute("cartItems", new CartItems());
        model.addAttribute("totalMoney", 0);
        return "cart/list";
    }

    public double totalPrice(Map<Long, Cart> cartItems) {
        long count = 0;
        for (Map.Entry<Long, Cart> list : cartItems.entrySet()) {
            count += list.getValue().getProduct().getProductPrice() * (100-list.getValue().getProduct().getProductDiscount())
                    /100 * list.getValue().getQuantity();
        }
        return count;
    }
}
