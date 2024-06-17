package org.example.ecommerce.repository;
import org.example.ecommerce.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {//장바구니
    boolean existsByCartName(String cartName);
    //장바구니 이름으로 중복된 장바구니가 있는지 여부 확인 [15]
    Cart findBycartID(Long cartID);//장바구니 ID로 장바구니 찾기
    void deleteByCartID(Long cartID);}//장바구니 ID로 찾아 장바구니 삭제 [2][4][5][6][15]