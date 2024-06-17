package org.example.ecommerce.controller;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.DuplicateNameException;
import org.example.ecommerce.domain.Cart;
import org.example.ecommerce.register.CartRegister;
import org.example.ecommerce.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController{//장바구니
    private final CartService cartService;

    @PostMapping("/make")//장바구니 만듬
    public ResponseEntity<?> makeCart(@RequestBody CartRegister cartRegister){
        try{Cart cart=cartService.makeCart(cartRegister);
            return ResponseEntity.status(HttpStatus.CREATED).body(cart);
        }catch (DuplicateNameException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());}}//[15]

    @GetMapping("/get/{cartID}")//장바구니 정보 가져옴.
    public ResponseEntity<Cart> getCart(@PathVariable Long cartID){
        Cart cart= cartService.getCart(cartID);
        if(cart!=null) {return ResponseEntity.ok(cart);
        }else{return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);}}

    @PutMapping("/update/{cartID}")//장바구니 정보 수정
    public ResponseEntity<Cart> updateCart(@PathVariable Long cartID,
    @RequestBody CartRegister cartRegister){
        try{Cart updatecart=cartService.updateCart(cartID,cartRegister);
            return ResponseEntity.ok(updatecart);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);}}

    @DeleteMapping("/delete/{cartID}")//장바구니 삭제
    public void deleteCart(@PathVariable Long cartID){
        cartService.deleteCart(cartID);}}