package edu.tusur.kp.controller;

import edu.tusur.kp.jpa.dto.AccountDto;
import edu.tusur.kp.jpa.model.Account;
import edu.tusur.kp.service.BankService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private BankService bankService;

    @Autowired
    private ModelMapper mapper;

    @ResponseBody
    @GetMapping("/accounts")
    public ResponseEntity<List<AccountDto>> getAccounts() {
        List<Account> accounts = bankService.getAccounts();
        List<AccountDto> resultList = new ArrayList<>();
        accounts.forEach(a -> {
            AccountDto accountDto = new AccountDto();
            mapper.map(a, accountDto);
            resultList.add(accountDto);
        });
        return ResponseEntity.ok(resultList);
    }

    @ResponseBody
    @GetMapping("/accounts/remove/{id}")
    public ResponseEntity<Boolean> removeAccount(@PathVariable("id") Long id) {
        Boolean aBoolean = bankService.removeAccount(id);
        return ResponseEntity.ok(aBoolean);
    }

    @ResponseBody
    @PostMapping("/accounts/edit/{id}")
    public ResponseEntity<AccountDto> editAccount(@PathVariable("id") Long id, @RequestBody AccountDto accountDto) {
        AccountDto resultDto = bankService.editAccount(accountDto, id, mapper);
        return ResponseEntity.ok(resultDto);
    }

    @ResponseBody
    @PostMapping("/accounts/add")
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
        AccountDto resultDto = bankService.createAccount(accountDto, mapper);
        return ResponseEntity.ok(resultDto);
    }

    @ResponseBody
    @GetMapping("/account/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable("id") Long id) {
        Optional<Account> account = bankService.getAccount(id);
        AccountDto accountDto = new AccountDto();
        account.ifPresent(acc -> mapper.map(acc, accountDto));
        return ResponseEntity.ok(accountDto);
    }

    // -----------------------------------------------------------------------------------------------------------------------------------------------------

}
