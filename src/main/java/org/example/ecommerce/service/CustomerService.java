package org.example.ecommerce.service;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.DuplicateNameException;
import org.example.ecommerce.domain.Customer;
import org.example.ecommerce.request.CustomerDeleteRequest;
import org.example.ecommerce.request.CustomerLoginRequest;
import org.example.ecommerce.register.CustomerRegister;
import org.example.ecommerce.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerService {//고객
    private final CustomerRepository customerRepository;

    public Customer makeCustomer(CustomerRegister customerRegister) {
        if(customerRepository.existsByCustomerName(customerRegister.getCustomerName())){
            throw new DuplicateNameException("판매자 이름 이미 있음");}
        return customerRepository.save(CustomerRegister.customerForm(customerRegister));}

    public Customer authenticateCustomer(CustomerLoginRequest customerLoginRequest){
        //고객 인증 - 고객이 로그인을 하려고 할 때, 고객 이름, PW를 확인한 후에 로그인
        Customer customer= customerRepository.findByCustomerName(customerLoginRequest.getCustomerName());
        if(customer.getCustomerPW().equals(customerLoginRequest.getCustomerPW())
                &&customer.getCustomerName().equals(customerLoginRequest.getCustomerName()))
        {return customer;}return null;} //출처: chatgpt 질의 응답

    public void logoutCustomer(HttpSession session)//고객 로그아웃
    {session.invalidate();}

    public Optional<Customer> findByCustomerID(Long customerID){
        //고객 이름으로 중복된 계정 찾기[16]
        return customerRepository.findById(customerID);}

    public Customer getCustomer(Long customerID) {
        return customerRepository.findById(customerID).orElse(null);}

public Customer updateCustomer(Long customerID, CustomerRegister customerRegister) {
        Customer saved=customerRepository.findById(customerID)
.orElseThrow(()->new RuntimeException("고객 없음."));
        saved.customerUpdate(customerRegister);return saved;}

    public void deleteCustomer(Long customerID, CustomerDeleteRequest customerDeleteRequest) {
        Customer customer=customerRepository.findById(customerID)
                .orElseThrow(()->new RuntimeException("고객 없음"));
        if(customer.getCustomerPW().equals(customerDeleteRequest.getCustomerPW())){
            customerRepository.deleteById(customerID);}
    else throw new RuntimeException("고객 ID 삭제 실패 또는 발견 안 됨");}}//[15]

    /* public Customer makeCustomer(CustomerRegister customerRegister) {
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
        {return "OK!";}else return "Fail!";}

    public Customer changeCustomerUsed(Long customerID,CustomerRegister customerRegister){
        Customer saved2=customerRepository.findBycustomerID(customerID);
        saved2.changeCustomerUsed(customerRegister);return saved2;}

    public Customer writeCustomerReview(Long customerID, CustomerRegister customerRegister) {
        Customer saved3=customerRepository.findBycustomerID(customerID);
        saved3.writeCustomerReview(customerRegister);return saved3;}}//[2][4][7][8]*/