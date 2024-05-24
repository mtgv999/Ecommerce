package org.example.ecommerce.controller;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.domain.Seller;
import org.example.ecommerce.loginnrequest.SellerLoginRequest;
import org.example.ecommerce.register.SellerRegister;
import org.example.ecommerce.service.SellerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seller")
@RequiredArgsConstructor
public class SellerController {//판매자
    private final SellerService sellerService;

    @PostMapping("/make")//판매자 계정 만듬
    public Seller makeSeller(@RequestBody SellerRegister sRegister){
        return sellerService.makeSeller(sRegister);}

    @GetMapping("/get/{sID}")//판매자 정보 가져옴.
    public Seller getSeller(@PathVariable Long sID){
        return sellerService.getSeller(sID);}

    @PutMapping("/update/{sID}")//판매자 정보 수정
    public Seller updateSeller(@PathVariable Long sID,
    @RequestBody SellerRegister sRegister){
        return sellerService.updateSeller(sID,sRegister);}

    @DeleteMapping("/delete/{sID}")//판매자 계정 삭제
    public void deleteSeller(@PathVariable Long sID){
        sellerService.deleteSeller(sID);}

    @PostMapping("/sLogin")//고객이 회원 가입 했는지의 여부를
    //로그인(고객 ID, PW 확인)을 통해 확인 하려는 요청.
    public String sLogin(@RequestBody SellerLoginRequest sLReq){
        return sellerService.sLogin(sLReq);}}