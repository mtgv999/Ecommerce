package org.example.ecommerce.domain;
import jakarta.persistence.*;
import lombok.*;
import org.example.ecommerce.register.ProductRegister;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Product extends BaseEntity{@Id//상품
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productID;//상품 아이디
    private Long sellerID;//판매자 아이디
    private String productName;//상품 이름
    private double cost;//상품 가격
    private String category;//분류
    private String information;//정보
    private Long productNumber;//상품 번호
    private int stock;//상품(재고) 개수

    public void pUpdate(ProductRegister productRegister){
        this.sellerID =productRegister.getSellerID();
        this.productName =productRegister.getProductName();
        this.cost=productRegister.getCost();
        this.category=productRegister.getCategory();
        this.information=productRegister.getInformation();
        this.productNumber =productRegister.getProductNumber();
        this.stock =productRegister.getStock();}}