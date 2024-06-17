package org.example.ecommerce.register;
import lombok.*;
import org.example.ecommerce.domain.Customer;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRegister {//고객용 회원 등록
    private String customerName;//고객 이름
    private String customerPW;//고객 PW
    private Long customerAccountNumber;//고객 계좌 번호
    private Long customerPhoneNumber;//고객 핸드폰 번호
    private String customerReview;//고객 리뷰

    public static Customer customerForm(CustomerRegister customerRegister){
    return Customer.builder().customerName(customerRegister.getCustomerName())
            .customerPW(customerRegister.getCustomerPW())
            .customerAccountNumber(customerRegister.getCustomerAccountNumber())
            .customerPhoneNumber(customerRegister.getCustomerPhoneNumber())
            .customerReview(customerRegister.getCustomerReview()).build();}}//[2][4]