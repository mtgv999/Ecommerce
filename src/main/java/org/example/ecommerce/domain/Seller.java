package org.example.ecommerce.domain;
import jakarta.persistence.*;
import lombok.*;
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
    private Long sID;//판매자 아이디
    private Long sPW;//판매자 비밀 번호
    private String sName;//판매자 이름
    private Long sAccountNumber;//판매자 계좌 번호
    private Long sPhoneNumber;//판매자 핸드폰 번호

    public void sUpdate(SellerRegister sRegister){
        this.sName=sRegister.getSName();
        this.sAccountNumber=sRegister.getSAccountNumber();
        this.sPhoneNumber=sRegister.getSPhoneNumber();}}