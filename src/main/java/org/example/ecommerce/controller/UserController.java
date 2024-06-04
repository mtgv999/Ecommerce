package org.example.ecommerce.controller;

import org.example.ecommerce.ErrorResponse;
import org.example.ecommerce.register.UserCreateRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

public class UserController {@PostMapping
public ResponseEntity<?> createUSer(@Validated @RequestBody final UserCreateRequestDto userCreateRequestDto, BindingResult bindingResult){
    if (bindingResult.hasErrors()) {
        List<String> errors = bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
        // 200 response with 404 status code
        return ResponseEntity.ok(new ErrorResponse("404", "Validation failure", errors));
        // or 404 request
        //  return ResponseEntity.badRequest().body(new ErrorResponse("404", "Validation failure", errors));
    }try {final User user = userService.searchUser(userCreateRequestDto.toEntity().getId());
    }catch (Exception e){
        return ResponseEntity.ok(
                new UserResponseDto(userService.createUser(userCreateRequestDto.toEntity())));}
    // user already exist
    return ResponseEntity.ok(
            new UserResponseDto(userService.searchUser(userCreateRequestDto.toEntity().getId())));
}}