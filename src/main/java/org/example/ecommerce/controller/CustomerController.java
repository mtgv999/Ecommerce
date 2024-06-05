package org.example.ecommerce.controller;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.domain.Customer;
import org.example.ecommerce.loginnrequest.CustomerLoginRequest;
import org.example.ecommerce.register.CustomerRegister;
import org.example.ecommerce.service.CustomerService;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor

public class CustomerController {//고객
    private final CustomerService customerService;

    /* @PostMapping("/account")
    public CreateAccount.Response createAccount(
            @RequestBody @Valid CreateAccount.Request request) {
        return CreateAccount.Response.from(
                customerService.createAccount(
request.getUserId(),8request.getInitialBalance()));}*/

    @PostMapping("/make")//고객 계정 만듬
public Customer makeCustomer(@RequestBody CustomerRegister customerRegister){
        return customerService.makeCustomer(customerRegister);}

    @GetMapping("/get/{customerID}")//고객 정보 가져옴.
    public Customer getCustomer(@PathVariable Long customerID){
        return customerService.getCustomer(customerID);}

    @PutMapping("/update/{customerID}")//고객 정보 수정
    public Customer updateCustomer(@PathVariable Long customerID,
    @RequestBody CustomerRegister customerRegister){
        return customerService.updateCustomer(customerID,customerRegister);}

    @DeleteMapping("/delete/{customerID}")
    //고객 계정을 삭제 하려고 할 때, 고객 ID, PW를 확인한 후에 삭제.
    public void deleteCustomer(@PathVariable Long customerID,
    @RequestBody CustomerLoginRequest customerLoginRequest){
        customerService.deleteCustomer(customerID,customerLoginRequest);}

    @PostMapping("/cLogin")//고객이 회원 가입을 했는지의 여부를
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
        return customerService.writeCustomerReview(customerID,customerRegister);}}//[2][4][7][8]