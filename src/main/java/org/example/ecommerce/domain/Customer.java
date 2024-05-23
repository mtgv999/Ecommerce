package org.example.ecommerce.domain;
import jakarta.persistence.*;
import lombok.*;
import org.example.ecommerce.register.CustomerRegister;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Customer extends BaseEntity {@Id//고객
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cID;
    private Long cPW;
    private String cName;//고객 번호
    private Long cAccountNumber;//고객 계좌 번호
    private Long cPhoneNumber;//고객 핸드폰 번호
    public void cUpdate(CustomerRegister cRegister){
        this.cName=cRegister.getCName();
        this.cAccountNumber=cRegister.getCAccountNumber();
        this.cPhoneNumber=cRegister.getCPhoneNumber();}}//[2][4]