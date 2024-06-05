package org.example.ecommerce.register;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.example.ecommerce.domain.Customer;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRegister {@Id//고객용 회원 등록
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerID;
    //@NotNull @Min(1) @Max(10000000000000000L)
    private Long customerPW;
    //@NotNull @Size(min =4, max=17,message = "PW길이: 1~4")
    //@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]{4,17}$",
    //message = "비밀번호는 4~17자 이며, 최소 하나의 문자와 숫자가 포함되어야 합니다.")
    private String customerName;//고객 이름
    //@NotNull @Min(1) @Max(10000000000000000L)

    private Long customerAccountNumber;//고객 계좌 번호
    //@NotNull @Min(1) @Max(10000000000000000L)
    private Long customerPhoneNumber;//고객 핸드폰 번호
    private String customerUsed;//고객: 구매 경험 여부
    private String customerReview;//고객 리뷰

    //private Long userId;
    //private String accountNumber;
    //private LocalDateTime registeredAt;

    public static Customer customerForm(CustomerRegister customerRegister){
    Customer customer=Customer.builder()
            .customerPW(customerRegister.getCustomerPW())
            .customerName(customerRegister.getCustomerName())
            .customerAccountNumber(customerRegister.getCustomerAccountNumber())
            .customerPhoneNumber(customerRegister.getCustomerPhoneNumber())
            //.customerUsed(customerRegister.getCustomerUsed())
            //.customerReview(customerRegister.customerReview)
            .build();return customer;}

        //public static CustomerRegister fromEntity(Customer account){
        //    return CustomerRegister.builder()
        //.accountNumber(account.getAccountNumber())
        //.userId(account.getBalance())
        //.registeredAt(account.getRegisteredAt()).build();}
    }//[2][4]