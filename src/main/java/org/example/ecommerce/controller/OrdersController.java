package org.example.ecommerce.controller;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.domain.Orders;
import org.example.ecommerce.register.OrdersRegister;
import org.example.ecommerce.service.OrdersService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrdersController{//주문
    private final OrdersService ordersService;
    @PostMapping ("/make0/{productID}/{ordersCount}")
    public Orders makeOrder0
     (@RequestParam Long productID, @RequestParam int ordersCount){
        return ordersService.makeOrders0(productID, ordersCount);}

    @PostMapping("/make")//주문 만듬
public Orders makeOrders(@RequestBody OrdersRegister orderRegister){
        return ordersService.makeOrders(orderRegister);}

    @GetMapping("/get/{oNumber}")//주문 정보 가져옴.
    public Orders getOrders(@PathVariable Long ordersNumber){
        return ordersService.getOrders(ordersNumber);}

    @PutMapping("/update/{oNumber}")//주문 정보 수정
    public Orders updateOrders(@PathVariable Long ordersNumber,
    @RequestBody OrdersRegister ordersRegister){
        return ordersService.updateOrders(ordersNumber,ordersRegister);}

    @DeleteMapping("/delete/{oNumber}")//주문 삭제
    public void deleteOrders(@PathVariable Long ordersNumber){
        ordersService.deleteOrders(ordersNumber);}}