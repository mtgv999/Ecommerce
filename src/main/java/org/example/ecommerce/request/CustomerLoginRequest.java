package org.example.ecommerce.request;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerLoginRequest {//고객 로그인 확인 요청
    @JsonProperty
    private String customerName;
    @JsonProperty
    private String customerPW;}