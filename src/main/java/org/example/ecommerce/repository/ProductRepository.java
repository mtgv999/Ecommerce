package org.example.ecommerce.repository;
import org.example.ecommerce.domain.Product;
import org.example.ecommerce.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{//상품
    //Seller findBysellerID(Long sellerID);//판매자 아이디로 찾기
    Product findByproductID(Long productID);//상품 ID로 찾기
    void deleteByproductID(Long productID);}//상품 계정 삭제