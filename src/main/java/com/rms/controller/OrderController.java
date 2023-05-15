
 package com.rms.controller;
 
 import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Controller;
 import org.springframework.ui.Model;
 import org.springframework.web.bind.annotation.RequestMapping;

 import com.rms.model.Order;
 import com.rms.service.OrderService;

 @Controller
 public class OrderController {

     @Autowired
     private OrderService orderService;
     
     public void setOrderService(OrderService orderService) {
         this.orderService = orderService;
     }

     @RequestMapping("/csp/openorders")
     public String viewOpenOrders(Model model) {
         List<Order> openOrders = orderService.getOpenOrders();
         model.addAttribute("openOrders", openOrders);
         return "open-orders";
     }
 }