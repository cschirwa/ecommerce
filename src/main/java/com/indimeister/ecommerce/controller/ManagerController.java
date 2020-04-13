package com.indimeister.ecommerce.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.indimeister.ecommerce.model.Cart;
import com.indimeister.ecommerce.model.Orders;
import com.indimeister.ecommerce.model.Product;
import com.indimeister.ecommerce.service.CartService;
import com.indimeister.ecommerce.service.OrderService;
import com.indimeister.ecommerce.service.ProductService;

@Controller
public class ManagerController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private OrderService orderService;
	
	//teste
	@RequestMapping("/")
    public String index(){
        return "index";
    }
	
	
	/***
	 * Produtos
	 */
	@RequestMapping("productList")
	public String productList(Model model){
		Iterable<Product> product = productService.findAll();		
		model.addAttribute("products", product);		
		
		Iterable<Cart> cart = cartService.findAll();		
		model.addAttribute("carts", cart);	
		return "productList";
	}
	
	@RequestMapping(value = "findProduct", method = RequestMethod.GET )
	public String findProduct(@RequestParam("name") String name, Model model){
		Iterable<Product> product = productService.findByName(name);		
		model.addAttribute("products", product);		
		
		return "productList";
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST )
	public String save(@RequestParam("name") String name, @RequestParam("price")Double price, 
			@RequestParam("available") Long available, Model model){
		
		Product prod = new Product(name, price, available);		
		productService.save(prod);
		return productList(model);
		
	}
	
	
	/***
	 * Carrinho
	 */			
	@RequestMapping(value = "addCart", method = RequestMethod.GET )
	public String addCart(@RequestParam("id")Long id, Model model){
		Product prod = controlAvailable(id,"addCart");
			
		Cart cart = new Cart(prod.getName(), prod.getId() );		
		cartService.save(cart);
		return productList(model);
		
	}
	
	@RequestMapping(value = "removeCart", method = RequestMethod.GET )
	public String removeCart(@RequestParam("id")Long id, Model model){		
		controlAvailable(id,"removeCart");		
		cartService.delete(id);
		return productList(model);		
	}
	
	//Estoque
	public Product controlAvailable(Long id, String action) {
		Optional<Product> prod = productService.findById(id);
		Long stock;
		if(action.equals("addCart") && prod.get().getAvailable() !=0) {
			stock = prod.get().getAvailable() - 1;
		}else {
			stock = prod.get().getAvailable() + 1;
		}
		//Update Estoque
		prod.get().setAvailable(stock);
		productService.save(prod.get());		
		return prod.get();
		
	}
	
	/***
	 * Pedido
	 */
	
	@RequestMapping("orderList")
	public String orderList(Model model){
		Iterable<Orders> order = orderService.findAll();		
		model.addAttribute("products", order);	
		return "orderList";
	}
	
	@RequestMapping(value = "finalOrder", method = RequestMethod.POST )
	public String finalOrder(Model model){		
		
		Iterable<Cart> carts = cartService.findAll();
		
		for (Cart cart : carts) {
			Orders prod = new Orders(cart.getNameProduct(), LocalDate.now());		
			orderService.save(prod);
		}
		
		Iterable<Orders> orders = orderService.findAll();
		model.addAttribute("orders", orders);	
		return orderList(model);
		
	}

}
