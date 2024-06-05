package org.example.ecommerce.controller;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.domain.Customer;
import org.example.ecommerce.domain.Seller;
import org.example.ecommerce.loginnrequest.SellerLoginRequest;
import org.example.ecommerce.register.CustomerRegister;
import org.example.ecommerce.register.SellerRegister;
import org.example.ecommerce.service.ProductService;
import org.example.ecommerce.service.SellerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seller")
@RequiredArgsConstructor
public class SellerController {//판매자
    private final SellerService sellerService;
    private final ProductService productService;

    @PostMapping("/make")//판매자 계정 만듬
    public Seller makeSeller(@RequestBody SellerRegister sellerRegister){
        return sellerService.makeSeller(sellerRegister);}

    @GetMapping("/get/{sellerID}")//판매자 정보 가져옴.
    public Seller getSeller(@PathVariable Long sellerID){
        return sellerService.getSeller(sellerID);}

    @PutMapping("/update/{sellerID}")//판매자 정보 수정
    public Seller updateSeller(@PathVariable Long sellerID,
    @RequestBody SellerRegister sellerRegister){
return sellerService.updateSeller(sellerID,sellerRegister);}

    @PutMapping("/update0/{sellerID}")//판매자 정보 수정
    public Seller updateSeller0(@PathVariable Long sellerID,
@RequestBody SellerLoginRequest sellerLoginRequest, @RequestBody SellerRegister sellerRegister){
return sellerService.updateSeller0(sellerID,sellerLoginRequest,sellerRegister);}

    @DeleteMapping("/delete/{sellerID}")
    //판매자 계정을 삭제 하려고 할 때, 판매자 ID, PW를 확인한 후에 삭제.
    public void deleteSeller(@PathVariable Long sellerID,
    @RequestBody SellerLoginRequest sellerLoginRequest){
        sellerService.deleteSeller(sellerID,sellerLoginRequest);}

    @PostMapping("/sellerLogin")//고객이 회원 가입 했는지의 여부를
    //로그인(고객 ID, PW 확인)을 통해 확인 하려는 요청.
    public String sellerLogin(@RequestBody SellerLoginRequest sellerLoginRequestRequest){
        return sellerService.sellerLogin(sellerLoginRequestRequest);}

    @PutMapping("/update/{sellerID}/used")
    public Seller updateSellerUsed(@PathVariable Long sellerID,
    @RequestBody SellerRegister customerRegister){
        return sellerService.changeSellerUsed(sellerID,customerRegister);}

    @PutMapping("/write/{sellerID}/review")
    public Seller writeSellerReview(@PathVariable Long sellerID,
    @RequestBody SellerRegister sellerRegister){
        return sellerService.writeSellerReview(sellerID,sellerRegister);}}