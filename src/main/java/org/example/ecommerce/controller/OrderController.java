package org.example.ecommerce.controller;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.domain.Order;
import org.example.ecommerce.register.OrderRegister;
import org.example.ecommerce.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController{//주문
    private final OrderService orderService;
    /* @PostMapping ("/make0")public Order makeOrder0
     (@RequestParam Long productID, @RequestParam int orderStock){
        return orderService.makeOrder0(productID, orderStock);}*/

    @PostMapping("/make")//주문 만듬
public Order makeOrder(@RequestBody OrderRegister orderRegister){
        return orderService.makeOrder(orderRegister);}

    @GetMapping("/get/{oNumber}")//주문 정보 가져옴.
    public Order getOrder(@PathVariable Long orderNumber){
        return orderService.getOrder(orderNumber);}

    @PutMapping("/update/{oNumber}")//주문 정보 수정
    public Order updateOrder(@PathVariable Long orderNumber,
    @RequestBody OrderRegister orderRegister){
        return orderService.updateOrder(orderNumber,orderRegister);}

    @DeleteMapping("/delete/{oNumber}")//주문 삭제
    public void deleteOrder(@PathVariable Long orderNumber){
        orderService.deleteOrder(orderNumber);}}