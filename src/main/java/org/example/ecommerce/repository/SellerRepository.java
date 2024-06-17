package org.example.ecommerce.repository;
import org.example.ecommerce.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface SellerRepository extends JpaRepository<Seller,Long>{//판매자
    boolean existsBySellerName(String sellerName);
    //판매자 이름으로 중복된 계정이 있는지 여부 확인[15]
    Seller findBySellerName(String sellerName);
    //판매자 이름으로 중복된 이름 계정 찾기 [16]
    Seller findBysellerID(Long sellerID);//판매자 ID로 계정 찾기
    void deleteBysellerID(Long sellerID);}//판매자 ID로 찾아 계정 삭제 [2][4][5][6][15]