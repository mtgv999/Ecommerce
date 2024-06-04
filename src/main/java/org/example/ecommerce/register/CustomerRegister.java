package org.example.ecommerce.register;
import jakarta.validation.constraints.*;
import lombok.*;
import org.example.ecommerce.domain.Customer;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRegister {//고객용 회원 등록
    //@NotNull @Min(1) @Max(10000000000000000L)
    private Long cPW;
    //@NotNull @Size(min =4, max=17,message = "PW길이: 1~4")
    //@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]{4,17}$",
//message = "비밀번호는 4~17자 이며, 최소 하나의 문자와 숫자가 포함되어야 합니다.")
    private String cName;//고객 이름
    //@NotNull @Min(1) @Max(10000000000000000L)
    private Long cAccountNumber;//고객 계좌 번호
    //@NotNull @Min(1) @Max(10000000000000000L)
    private Long cPhoneNumber;//고객 핸드폰 번호

    private Long userId;
    private String accountNumber;
    private LocalDateTime registeredAt;

    public static Customer cForm(CustomerRegister cRegister){
    Customer customer=Customer.builder()
            .cPW(cRegister.getCPW()).cName(cRegister.getCName())
            .cAccountNumber(cRegister.getCAccountNumber())
            .cPhoneNumber(cRegister.getCPhoneNumber())
            .build();return customer;}

        public static CustomerRegister fromEntity(Customer account){
            return CustomerRegister.builder()
                    .accountNumber(account.getAccountNumber())
                    .userId(account.getBalance())
                    .registeredAt(account.getRegisteredAt()).build();}
    }//[2][4]