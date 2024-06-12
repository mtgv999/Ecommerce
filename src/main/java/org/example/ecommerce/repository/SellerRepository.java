package org.example.ecommerce.repository;
import org.example.ecommerce.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface SellerRepository extends JpaRepository<Seller,Long>{//판매자
    boolean existsBySellerName(String sellerName);
    Optional<Seller> findBySellerName(String sellerName);
    Seller findBysellerID(Long sellerID);//판매자 아이디로 찾기
    void deleteBysellerID(Long sellerID);}//판매자 계정 삭제