package org.example.ecommerce.repository;
import org.example.ecommerce.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {//장바구니
    Cart findByCartID(Long cartID);//장바구니 아이디로 찾기
    void deleteByCartID(Long cartID);}//장바구니 계정 삭제