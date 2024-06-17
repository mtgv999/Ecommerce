package org.example.ecommerce.controller;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.DuplicateNameException;
import org.example.ecommerce.domain.Customer;
import org.example.ecommerce.domain.Seller;
import org.example.ecommerce.request.CustomerDeleteRequest;
import org.example.ecommerce.request.CustomerLoginRequest;
import org.example.ecommerce.register.CustomerRegister;
import org.example.ecommerce.request.SellerLoginRequest;
import org.example.ecommerce.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor

public class CustomerController {//고객
    private final CustomerService customerService;

    @PostMapping("/make")//고객 계정 만듬
public ResponseEntity<?> makeCustomer(@RequestBody CustomerRegister customerRegister){
        try{Customer customer=customerService.makeCustomer(customerRegister);
            return ResponseEntity.status(HttpStatus.CREATED).body(customer);
        }catch (DuplicateNameException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());}}//[15]

    @PostMapping("/login")//고객이 로그인을 하려고 할 때, 고객 이름, PW를 확인한 후에 로그인
    public ResponseEntity<String> loginCustomer
            (HttpSession session, @RequestBody CustomerLoginRequest CustomerLoginRequest){
        Customer customer = customerService.authenticateCustomer(CustomerLoginRequest);

        if(customer!=null) {//세션에 고객 ID 저장
            session.setAttribute("customerID", customer.getCustomerID());
            return ResponseEntity.ok("로그인 성공");
        }else{return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED).body("로그인 실패");}}

    @PostMapping("/logout")
    public ResponseEntity<String> logoutCustomer(HttpSession session){//세션 무효화
        session.invalidate();return ResponseEntity.ok("로그아웃 성공");}

    @GetMapping("/profile")
    public ResponseEntity<Customer> getProfile(HttpSession session){
        Long customerID=(Long) session.getAttribute("customerID");

if(customerID==null){return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();}
        Optional<Customer> customer=customerService.findByCustomerID(customerID);
        return customer.map(ResponseEntity::ok).orElseGet(()
                -> ResponseEntity.notFound().build());}//[16]

    @GetMapping("/get/{customerID}")//고객 정보 가져옴.
    public ResponseEntity<Customer> getCustomer(@PathVariable Long customerID){
        Customer customer= customerService.getCustomer(customerID);
        if(customer!=null) {return ResponseEntity.ok(customer);
        }else{return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);}}

    @PutMapping("/update/{customerID}")//고객 정보 수정
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerID,
    @RequestBody CustomerRegister customerRegister){
        try{Customer updatecustomer=customerService.updateCustomer(customerID,customerRegister);
        return ResponseEntity.ok(updatecustomer);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);}}

    @DeleteMapping("/delete/{customerID}")
    //고객 계정을 삭제 하려고 할 때, 고객 ID, PW를 확인한 후에 삭제.
    public ResponseEntity<String> deleteCustomer(@PathVariable Long customerID,
    @RequestBody CustomerDeleteRequest customerDeleteRequest){

        try{customerService.deleteCustomer(customerID,customerDeleteRequest);
    return ResponseEntity.ok("고객 계정 성공적 삭제");
}catch (Exception e){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).
body("고객 ID 삭제 실패 또는 발견 안 됨");}}}//[15]

    /* @PostMapping("/cLogin")//고객이 회원 가입을 했는지의 여부를
    //로그인(고객 ID, PW 확인)을 통해 확인 하려는 요청.
    public String customerLogin(@RequestBody CustomerLoginRequest customerLoginRequest){
        return customerService.cLogin(customerLoginRequest);}

    @PutMapping("/update/{customerID}/used")
    public Customer updateCustomerUsed(@PathVariable Long customerID,
    @RequestBody CustomerRegister customerRegister){
        return customerService.changeCustomerUsed(customerID,customerRegister);}

    @PutMapping("/write/{customerID}/review")
    public Customer writeCustomerReview(@PathVariable Long customerID,
    @RequestBody CustomerRegister customerRegister){
        return customerService.writeCustomerReview(customerID,customerRegister);}}//[2][4][7][8]*/