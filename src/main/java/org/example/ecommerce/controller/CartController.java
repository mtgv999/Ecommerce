package org.example.ecommerce.controller;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.domain.Cart;
import org.example.ecommerce.register.CartRegister;
import org.example.ecommerce.service.CartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController{//장바구니
    private final CartService cartService;

    @PostMapping("/make")//장바구니 계정 만듬
    public Cart makeCart(@RequestBody CartRegister cartRegister){
        return cartService.makeCart(cartRegister);}

    @GetMapping("/get/{cartID}")//장바구니 정보 가져옴.
    public Cart getCart(@PathVariable Long cartID){
        return  cartService.getCart(cartID);}

    @PutMapping("/update/{cartID}")//장바구니 정보 수정
    public Cart updateCart(@PathVariable Long cartID,
    @RequestBody CartRegister cartRegister){
        return cartService.updateCart(cartID,cartRegister);}

    @DeleteMapping("/delete/{cartID}")//장바구니 계정 삭제
    public void deleteCart(@PathVariable Long cartID){
        cartService.deleteCart(cartID);}}