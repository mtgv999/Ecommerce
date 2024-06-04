package org.example.ecommerce.service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.domain.Customer;
import org.example.ecommerce.loginnrequest.CustomerLoginRequest;
import org.example.ecommerce.register.CustomerRegister;
import org.example.ecommerce.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerService {//고객
    private final CustomerRepository customerRepository;

    public CustomerRegister createAccount(Long userId, Long initialBalance) {
        String newAccountNumber = customerRepository.findFirstByOrderByIdDesc()
.map(account -> (Integer.parseInt(account.getAccountNumber()))+1+"").orElse("1000000000");

        return CustomerRegister.fromEntity(
                customerRepository.save(Customer.builder()
                        .accountNumber(newAccountNumber)
                        .balance(initialBalance)
                        .registeredAt(LocalDateTime.now()).build()));}


    public Customer makeCustomer(CustomerRegister cRegister) {
        return customerRepository.save(CustomerRegister.cForm(cRegister));}

    public Customer getCustomer(Long cID) {
        return customerRepository.findBycID(cID);}

    public Customer updateCustomer(Long cID, CustomerRegister cRegister) {
        Customer saved=customerRepository.findBycID(cID);
        saved.cUpdate(cRegister);return saved;}

    public void deleteCustomer(Long cID) {
        customerRepository.deleteBycID(cID);}

    public String cLogin(CustomerLoginRequest cLReq) {
        Customer reqCo=customerRepository.findBycID(cLReq.getCID());
        if(reqCo.getCPW().longValue()==cLReq.getCPW())
            //고객 인지 여부를 고객 ID, PW 통해 확인
        {return "OK!";}else return "Fail!";}}//[2][4]