package org.example.ecommerce.loginnrequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerReviewRequest {//고객 리뷰 수정 요청
    @JsonProperty
    private Long customerID;
    @JsonProperty
    private Long customerPW;
    @JsonProperty
    private String isUsed;
}
