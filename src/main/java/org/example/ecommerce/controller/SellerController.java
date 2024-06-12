package org.example.ecommerce.controller;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.DuplicateSellerNameException;
import org.example.ecommerce.domain.Seller;
import org.example.ecommerce.loginnrequest.SellerLoginRequest;
import org.example.ecommerce.loginnrequest.SellerLoginRequest0;
import org.example.ecommerce.register.SellerRegister;
import org.example.ecommerce.service.SellerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/seller")
@RequiredArgsConstructor
public class SellerController {//판매자
    private final SellerService sellerService;

   @PostMapping("/make")//판매자 계정 만듬
    public ResponseEntity<Seller> makeSeller(@RequestBody SellerRegister sellerRegister) {
        Seller seller = sellerService.makeSeller(sellerRegister);
 if (seller != null) {return ResponseEntity.status(HttpStatus.CREATED).body(seller);}
        else {return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();}}

    @PostMapping("/login")
    public ResponseEntity<String> loginSeller(HttpSession session,
    @RequestBody SellerLoginRequest0 sellerloginRequest0) {
      Seller seller = sellerService.authenticateSeller(sellerloginRequest0);
        if (seller != null) {// 세션에 판매자 ID 저장
            session.setAttribute("sellerId", seller.getSellerID());
            return ResponseEntity.ok("Logged in successfully");
            } else {return ResponseEntity.status
                (HttpStatus.UNAUTHORIZED).body("Invalid credentials");}}

    @PostMapping("/logout")
    public ResponseEntity<String> logoutSeller(HttpSession session) {//세션 무효화
        session.invalidate();return ResponseEntity.ok("Logged out successfully");}

    @GetMapping("/profile")
    public ResponseEntity<Seller> getProfile(HttpSession session) {
        Long sellerID = (Long) session.getAttribute("sellerId");
        if (sellerID == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();}
        Optional<Seller> seller = sellerService.findBySellerByID(sellerID);
        return seller.map(ResponseEntity::ok).orElseGet(()
                -> ResponseEntity.notFound().build());}

    //@PostMapping("/make")//판매자 계정 만듬
    //    public Seller makeSeller(@RequestBody SellerRegister sellerRegister){
    //        return sellerService.makeSeller(sellerRegister);}

    @GetMapping("/get/{sellerID}")//판매자 정보 가져옴.
    public Seller getSeller(@PathVariable Long sellerID){
        return sellerService.getSeller(sellerID);}

    @PutMapping("/update/{sellerID}")//판매자 정보 수정
    public Seller updateSeller(@PathVariable Long sellerID,
    @RequestBody SellerRegister sellerRegister){
return sellerService.updateSeller(sellerID,sellerRegister);}

     /*@PutMapping("/update0/{sellerID}")//판매자 정보 수정
    public Seller updateSeller0(@PathVariable Long sellerID,
@RequestBody SellerLoginRequest sellerLoginRequest, @RequestBody SellerRegister sellerRegister){
return sellerService.updateSeller0(sellerID,sellerLoginRequest,sellerRegister);}*/

    @DeleteMapping("/delete/{sellerID}")
    //판매자 계정을 삭제 하려고 할 때, 판매자 ID, PW를 확인한 후에 삭제.
    public void deleteSeller(@PathVariable Long sellerID,
    @RequestBody SellerLoginRequest sellerLoginRequest){
        sellerService.deleteSeller(sellerID,sellerLoginRequest);}

     /*@PostMapping("/sellerLogin")//고객이 회원 가입 했는지의 여부를
    //로그인(고객 ID, PW 확인)을 통해 확인 하려는 요청.
    public String sellerLogin(@RequestBody SellerLoginRequest sellerLoginRequestRequest){
        return sellerService.sellerLogin(sellerLoginRequestRequest);}*/

    @PutMapping("/update/{sellerID}/used")
    public Seller updateSellerUsed(@PathVariable Long sellerID,
    @RequestBody SellerRegister customerRegister){
        return sellerService.changeSellerUsed(sellerID,customerRegister);}

    @PutMapping("/write/{sellerID}/review")
    public Seller writeSellerReview(@PathVariable Long sellerID,
    @RequestBody SellerRegister sellerRegister){
        return sellerService.writeSellerReview(sellerID,sellerRegister);}}