package org.example.ecommerce.service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.domain.Customer;
import org.example.ecommerce.loginnrequest.CustomerLoginRequest;
import org.example.ecommerce.register.CustomerRegister;
import org.example.ecommerce.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerService {//고객
    private final CustomerRepository customerRepository;

    /* public CustomerRegister createAccount(Long userId, Long initialBalance) {
        String newAccountNumber = customerRepository.findFirstByOrderByIdDesc()
.map(account -> (Integer.parseInt(account.getAccountNumber()))+1+"").orElse("1000000000");

        return CustomerRegister.fromEntity(
                customerRepository.save(Customer.builder()
.accountNumber(newAccountNumber).balance(initialBalance)
                        .registeredAt(LocalDateTime.now()).build()));}*/

    public Customer makeCustomer(CustomerRegister customerRegister) {
        return customerRepository.save(CustomerRegister.customerForm(customerRegister));}

    public Customer getCustomer(Long customerID) {
        return customerRepository.findBycustomerID(customerID);}

    public Customer updateCustomer(Long customerID, CustomerRegister customerRegister) {
        Customer saved=customerRepository.findBycustomerID(customerID);
        saved.customerUpdate(customerRegister);return saved;}

    public void deleteCustomer(Long customerID, CustomerLoginRequest customerLoginRequest) {
        Customer customerRequest=customerRepository.findBycustomerID(customerLoginRequest.getCustomerID());
        if(customerRequest.getCustomerPW().longValue()==customerLoginRequest.getCustomerPW())
        customerRepository.deleteBycustomerID(customerID);}

    public String cLogin(CustomerLoginRequest customerLoginRequest) {
        Customer customerRequest=customerRepository.findBycustomerID(customerLoginRequest.getCustomerID());
        if(customerRequest.getCustomerPW().longValue()==customerLoginRequest.getCustomerPW())
            //고객 인지 여부를 고객 ID, PW 통해 확인
        {return "OK!";}else return "Fail!";}}//[2][4]