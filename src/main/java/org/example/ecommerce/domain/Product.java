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
    private Long pID;//상품 아이디
    private Long sID;//판매자 아이디
    private String pName;//상품 이름
    private Long cost;//상품 가격
    private String category;//분류
    private String information;//정보
    private Long pNumber;//상품 번호

    public void pUpdate(ProductRegister pRegister){
        this.sID=pRegister.getSID();
        this.pName=pRegister.getPName();
        this.cost=pRegister.getCost();
        this.category=pRegister.getCategory();
        this.information=pRegister.getInformation();}}