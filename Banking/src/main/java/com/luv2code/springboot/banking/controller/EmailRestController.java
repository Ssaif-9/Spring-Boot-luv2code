package com.luv2code.springboot.banking.controller;

import com.luv2code.springboot.banking.servicr.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email/")
public class EmailRestController {
    private final EmailService emailService;
}

