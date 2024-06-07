package org.example.ecommerce.register;
import lombok.*;
import org.example.ecommerce.domain.Customer;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRegister {//고객용 회원 등록

    private Long customerPW;
    private String customerName;//고객 이름

    private Long customerAccountNumber;//고객 계좌 번호
    private Long customerPhoneNumber;//고객 핸드폰 번호
    private String customerUsed;//고객: 구매 경험 여부
    private String customerReview;//고객 리뷰

    //private Long userId;
    //private String accountNumber;
    //private LocalDateTime registeredAt;

    public static Customer customerForm(CustomerRegister customerRegister){
    return Customer.builder().customerPW(customerRegister.getCustomerPW())
            .customerName(customerRegister.getCustomerName())
            .customerAccountNumber(customerRegister.getCustomerAccountNumber())
            .customerPhoneNumber(customerRegister.getCustomerPhoneNumber()).build();}}//[2][4]

        //public static CustomerRegister fromEntity(Customer account){
        //    return CustomerRegister.builder()
        //.accountNumber(account.getAccountNumber())
        //.userId(account.getBalance())
        //.registeredAt(account.getRegisteredAt()).build();}[2][4]