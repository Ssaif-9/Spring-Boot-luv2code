package com.luv2code.springboot.banking.controller;

import com.luv2code.springboot.banking.dto.*;
import com.luv2code.springboot.banking.servicr.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/")
public class UserRestController {

    private final UserService userService;

    @PostMapping()
    public BankResponse addNewUserAccount(@RequestBody UserRequest userRequest) {
        return userService.createAccount(userRequest);
    }

    @GetMapping("balanceEnquiry")
    public BankResponse getEnquiryAccounts(@RequestBody EnquiryRequest enquiryRequest) {
        return userService.balanceEnquiry(enquiryRequest);
    }

    @GetMapping("nameEnquiry")
    public String getEnquiryName(@RequestBody EnquiryRequest enquiryRequest) {
        return userService.nameEnquiry(enquiryRequest);
    }

    @PostMapping("credit")
    public BankResponse creditUser(@RequestBody CreditDebitRequest creditDebitRequest) {
        return userService.creditAmount(creditDebitRequest);
    }

    @PostMapping("debit")
    public BankResponse debitUser(@RequestBody CreditDebitRequest creditDebitRequest) {
        return userService.debitAmount(creditDebitRequest);
    }

    @PostMapping("transfer")
    public BankResponse transferUser(@RequestBody TransferRequest transferRequest) {
        return userService.transfer(transferRequest);
    }
}
