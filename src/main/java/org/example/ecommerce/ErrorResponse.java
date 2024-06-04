//package org.example.ecommerce;
//
//import jakarta.validation.ConstraintViolationException;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ErrorResponse {
//
//        private String statusCode;
//        private String errorContent;
//        private List<String> messages;
//
//        public ErrorResponse(String statusCode, String errorContent, String messages) {
//            this.statusCode = statusCode;
//            this.errorContent = errorContent;
//            this.messages = new ArrayList<>();
//            this.messages.add(messages);}
//
//        public ErrorResponse(String statusCode, String errorContent, List<String> messages) {
//            this.statusCode = statusCode;
//            this.errorContent = errorContent;
//            this.messages = messages;}
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(ConstraintViolationException.class)
//    public Object exception(Exception e) {return e.getMessage();}
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
//        log.error("MethodArgumentNotValidException : " + e.getMessage());
//        final ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE, e.getBindingResult());
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }
//}