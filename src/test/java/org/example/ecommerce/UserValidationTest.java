//package org.example.ecommerce;
//
//import jakarta.validation.ConstraintViolation;
//import jakarta.validation.Validation;
//import jakarta.validation.Validator;
//import jakarta.validation.ValidatorFactory;
//import org.example.ecommerce.register.UserCreateRequestDto;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.util.Set;
//
//import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
//
//class UserValidationTest {
//    private static ValidatorFactory factory;
//    private static Validator validator;
//
//    @BeforeAll
//    public static void init() {
//        factory = Validation.buildDefaultValidatorFactory();
//        validator = factory.getValidator();
//    }
//
//    @AfterAll
//    public static void close() {
//        factory.close();
//    }
//
//    @DisplayName("빈문자열 전송 시 에러 발생")
//    @Test
//    void blank_validation_test() {
//        // given
//        UserCreateRequestDto userCreateRequestDto = new UserCreateRequestDto("", "test","email@naver.com");
//        // when
//        Set<ConstraintViolation<UserCreateRequestDto>> violations = validator.validate(userCreateRequestDto); // 유효하지 않은 경우 violations 값을 가지고 있다.
//        // then
//        assertThat(violations).isNotEmpty();
//        violations
//                .forEach(error -> {
//                    assertThat(error.getMessage()).isEqualTo("NAME_IS_MANDATORY");
//                });
//    }
//
//    @DisplayName("이메일 형식 아닌 경우 에러 발생")
//    @Test
//    void email_validation_test() {
//        // given
//        UserCreateRequestDto userCreateRequestDto = new UserCreateRequestDto("name", "test","email");
//        // when
//        Set<ConstraintViolation<UserCreateRequestDto>> violations = validator.validate(userCreateRequestDto);
//        // then
//        assertThat(violations).isNotEmpty();
//        violations
//                .forEach(error -> {
//                    assertThat(error.getMessage()).isEqualTo("NOT_VALID_EMAIL");
//                });
//    }
//
//    @DisplayName("유효성 검사 성공")
//    @Test
//    void validation_success_test() {
//        // given
//        UserCreateRequestDto userCreateRequestDto = new UserCreateRequestDto("name", "test","email@naver.com");
//        // when
//        Set<ConstraintViolation<UserCreateRequestDto>> violations = validator.validate(userCreateRequestDto);
//        // then
//        assertThat(violations).isEmpty(); // 유효한 경우
//    }}