package org.example.ecommerce.repository;
import org.example.ecommerce.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{//상품
    Product findBypID(Long pID);//상품 ID로 찾기
    void deleteBypID(Long pID);}//상품 계정 삭제