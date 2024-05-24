package org.example.ecommerce.service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
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
        return cartRepository.save(CartRegister.cartForm(cartRegister));}

    public Cart getCart(Long cartID) {
        return cartRepository.findByCartID(cartID);}

    public Cart updateCart(Long cartID, CartRegister cartRegister) {
        Cart saved=cartRepository.findByCartID(cartID);
        saved.cartUpdate(cartRegister);return saved;}

    public void deleteCart(Long cartID) {
        cartRepository.deleteByCartID(cartID);}}