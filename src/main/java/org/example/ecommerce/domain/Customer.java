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
    private Long customerID;//고객 아이디
    private Long customerPW;//고객 비밀 번호
    private String customerName;//고객 이름
    private Long customerAccountNumber;//고객 계좌 번호
    private Long customerPhoneNumber;//고객 핸드폰 번호

    //private String accountNumber;
    //private Long balance;
    //private LocalDateTime registeredAt;

    public void customerUpdate(CustomerRegister customerRegister){
        this.customerPW=customerRegister.getCustomerPW();
        this.customerName =customerRegister.getCustomerName();
        this.customerAccountNumber =customerRegister.getCustomerAccountNumber();
        this.customerPhoneNumber =customerRegister.getCustomerPhoneNumber();}}//[2][4]