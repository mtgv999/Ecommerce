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

    @PostMapping("/make")//고객 계정 만듬
    public Customer makeCustomer(@RequestBody CustomerRegister cRegister){
        return customerService.makeCustomer(cRegister);}

    @GetMapping("/get/{cID}")//고객 정보 가져옴.
    public Customer getCustomer(@PathVariable Long cID){
        return customerService.getCustomer(cID);}

    @PutMapping("/update/{cID}")//고객 정보 수정
    public Customer updateCustomer(@PathVariable Long cID,
    @RequestBody CustomerRegister cRegister){
        return customerService.updateCustomer(cID,cRegister);}

    @DeleteMapping("/delete/{cID}")//고객 계정 삭제
    public void deleteCustomer(@PathVariable Long cID){
        customerService.deleteCustomer(cID);}

    @PostMapping("/cLogin")//고객이 회원 가입을 했는지의 여부를
    //로그인(고객 ID, PW 확인)을 통해 확인 하려는 요청.
    public String cLogin(@RequestBody CustomerLoginRequest cLReq){
        return customerService.cLogin(cLReq);}}//[2][4]