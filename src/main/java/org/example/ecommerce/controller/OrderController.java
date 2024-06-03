package org.example.ecommerce.controller;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.domain.Order;
import org.example.ecommerce.register.OrderRegister;
import org.example.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController{//주문
    private final OrderService orderService;
    @PostMapping ("/make0")public Order makeOrder0
     (@RequestParam Long pID, @RequestParam int orderPCount){
        return orderService.makeOrder0(pID,orderPCount);}

    @PostMapping("/make")//주문 만듬
public Order makeOrder(@RequestBody OrderRegister oRegister){
        return orderService.makeOrder(oRegister);}

    @GetMapping("/get/{oNumber}")//주문 정보 가져옴.
    public Order getOrder(@PathVariable Long oNumber){
        return orderService.getOrder(oNumber);}

    @PutMapping("/update/{oNumber}")//주문 정보 수정
    public Order updateOrder(@PathVariable Long oNumber,
    @RequestBody OrderRegister oRegister){
        return orderService.updateOrder(oNumber,oRegister);}

    @DeleteMapping("/delete/{oNumber}")//주문 삭제
    public void deleteOrder(@PathVariable Long oNumber){
        orderService.deleteOrder(oNumber);}}