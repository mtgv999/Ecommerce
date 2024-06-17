package org.example.ecommerce.service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.DuplicateNameException;
import org.example.ecommerce.domain.Cart;
import org.example.ecommerce.register.CartRegister;
import org.example.ecommerce.repository.CartRepository;
import org.springframework.stereotype.Service;
@Service
@Transactional
@RequiredArgsConstructor
public class CartService {//장바구니
    private final CartRepository cartRepository;

    public Cart makeCart(CartRegister cartRegister) {
        if(cartRepository.existsByCartName(cartRegister.getCartName())){
            throw new DuplicateNameException("장바구니 이름 이미 있음");}
        return cartRepository.save(CartRegister.cartForm(cartRegister));}

    public Cart getCart(Long cartID) {
        return cartRepository.findById(cartID).orElse(null);}

    public Cart updateCart(Long cartID, CartRegister cartRegister) {
        Cart saved=cartRepository.findById(cartID)
.orElseThrow(()->new RuntimeException("장바구니 없음"));
        saved.cartUpdate(cartRegister);return saved;}//[16]

    public void deleteCart(Long cartID) {
        cartRepository.deleteByCartID(cartID);}}//[2][4][5][6][15]