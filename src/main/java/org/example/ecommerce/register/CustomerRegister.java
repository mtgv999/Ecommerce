package org.example.ecommerce.register;
import lombok.*;
import org.example.ecommerce.domain.Customer;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRegister {//고객용 회원 등록
    private Long cPW;
    private String cName;//고객 번호
    private Long cAccountNumber;//고객 계좌 번호
    private Long cPhoneNumber;//고객 핸드폰 번호

    public static Customer cForm(CustomerRegister cRegister){
    Customer customer=Customer.builder()
            .cPW(cRegister.getCPW()).cName(cRegister.getCName())
            .cAccountNumber(cRegister.getCAccountNumber())
            .cPhoneNumber(cRegister.getCPhoneNumber())
            .build();return customer;}}//[2][4]