package org.example.ecommerce.domain;
import jakarta.persistence.*;
import lombok.*;
import org.example.ecommerce.register.CustomerRegister;
import org.example.ecommerce.register.SellerRegister;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Seller extends BaseEntity { @Id//판매자
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sellerID;//판매자 아이디
    private Long sellerPW;//판매자 비밀 번호
    private String sellerName;//판매자 이름
    private Long sellerAccountNumber;//판매자 계좌 번호
    private Long sellerPhoneNumber;//판매자 핸드폰 번호
    private String sellerUsed;//판매자: 시스템 사용 경험 여부
    private String sellerReview;//판매자 리뷰

    public void sellerUpdate(SellerRegister sellerRegister){
        this.sellerPW=sellerRegister.getSellerPW();
        this.sellerName =sellerRegister.getSellerName();
        this.sellerAccountNumber =sellerRegister.getSellerAccountNumber();
        this.sellerPhoneNumber =sellerRegister.getSellerPhoneNumber();}

    public void changeSellerUsed(SellerRegister sellerRegister){
        this.sellerUsed ="yes";}
    public void writeSellerReview(SellerRegister sellerRegister){
        this.sellerReview=sellerRegister.getSellerReview();}
}