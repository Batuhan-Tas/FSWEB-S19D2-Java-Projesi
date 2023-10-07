package com.workintech.S19D2.controller;

import com.workintech.S19D2.entity.Account;
import com.workintech.S19D2.service.AccountService;
import com.workintech.S19D2.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping("/")
    public List<Account> findAll(){
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    public Account findById(@PathVariable int id){
        return accountService.findById(id);
    }

    @PostMapping("/")
    public Account save(@RequestBody Account account){
        return accountService.save(account);
    }

    @PutMapping("/{id}")
    public Account update(@RequestBody Account account,@PathVariable int id){
        Account foundAccount = accountService.findById(id);
        if(foundAccount != null){
            account.setId(id);
            return accountService.save(account);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){

        accountService.delete(id);
    }
}
