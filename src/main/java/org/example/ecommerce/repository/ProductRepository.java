package org.example.ecommerce.repository;
import org.example.ecommerce.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{//상품
    boolean existsByProductName(String productName);
    //상품 이름으로 중복된 상품이 있는지 여부 확인[15]
    Product findByproductID(Long productID);//상품 ID로 상품 찾기
    void deleteByproductID(Long productID);}//상품 ID로 찾아 상품 삭제