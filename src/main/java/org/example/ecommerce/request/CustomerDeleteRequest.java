package org.example.ecommerce.request;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDeleteRequest {//고객 계정 삭제 요청
    @JsonProperty
    private Long customerID;
    @JsonProperty
    private String customerPW;}