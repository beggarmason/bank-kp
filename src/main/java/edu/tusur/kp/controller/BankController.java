package edu.tusur.kp.controller;

import edu.tusur.kp.jpa.dto.*;
import edu.tusur.kp.jpa.model.*;
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
    @GetMapping("/account/remove/{id}")
    public ResponseEntity<Boolean> removeAccount(@PathVariable("id") Long id) {
        Boolean aBoolean = bankService.removeAccount(id);
        return ResponseEntity.ok(aBoolean);
    }

    @ResponseBody
    @PostMapping("/account/edit/{id}")
    public ResponseEntity<AccountDto> editAccount(@PathVariable("id") Long id, @RequestBody AccountDto accountDto) {
        AccountDto resultDto = bankService.editAccount(accountDto, id, mapper);
        return ResponseEntity.ok(resultDto);
    }

    @ResponseBody
    @PostMapping("/account/add")
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
    @ResponseBody
    @GetMapping("/amounts")
    public ResponseEntity<List<AmountDto>> getAmounts() {
        List<Amount> amounts = bankService.getAmounts();
        List<AmountDto> resultList = new ArrayList<>();
        amounts.forEach(a -> {
            AmountDto accountDto = new AmountDto();
            mapper.map(a, accountDto);
            resultList.add(accountDto);
        });
        return ResponseEntity.ok(resultList);
    }


    @ResponseBody
    @GetMapping("/amount/{id}")
    public ResponseEntity<AmountDto> getAmountById(@PathVariable("id") Long id) {
        Optional<Amount> account = bankService.getAmount(id);
        AmountDto amountDto = new AmountDto();
        account.ifPresent(acc -> mapper.map(acc, amountDto));
        return ResponseEntity.ok(amountDto);
    }

    @ResponseBody
    @GetMapping("/amount/remove/{id}")
    public ResponseEntity<Boolean> removeAmount(@PathVariable("id") Long id) {
        Boolean aBoolean = bankService.removeAmount(id);
        return ResponseEntity.ok(aBoolean);
    }

    @ResponseBody
    @PostMapping("/amount/edit/{id}")
    public ResponseEntity<AmountDto> editAmount(@PathVariable("id") Long id, @RequestBody AmountDto accountDto) {
        AmountDto resultDto = bankService.editAmount(accountDto, id, mapper);
        return ResponseEntity.ok(resultDto);
    }

    @ResponseBody
    @PostMapping("/amount/add")
    public ResponseEntity<AmountDto> addAmount(@RequestBody AmountDto accountDto) {
        AmountDto resultDto = bankService.createAmount(accountDto, mapper);
        return ResponseEntity.ok(resultDto);
    }

    // -----------------------------------------------------------------------------------------------------------------------------------------------------

    @ResponseBody
    @GetMapping("/banks")
    public ResponseEntity<List<BankDto>> getBanks() {
        List<Bank> banks = bankService.getBanks();
        List<BankDto> resultList = new ArrayList<>();
        banks.forEach(a -> {
            BankDto accountDto = new BankDto();
            mapper.map(a, accountDto);
            resultList.add(accountDto);
        });
        return ResponseEntity.ok(resultList);
    }


    @ResponseBody
    @GetMapping("/bank/{id}")
    public ResponseEntity<BankDto> getBankById(@PathVariable("id") Long id) {
        Optional<Bank> account = bankService.getBank(id);
        BankDto bankDto = new BankDto();
        account.ifPresent(acc -> mapper.map(acc, bankDto));
        return ResponseEntity.ok(bankDto);
    }

    @ResponseBody
    @GetMapping("/bank/remove/{id}")
    public ResponseEntity<Boolean> removeBank(@PathVariable("id") Long id) {
        Boolean aBoolean = bankService.removeBank(id);
        return ResponseEntity.ok(aBoolean);
    }

    @ResponseBody
    @PostMapping("/bank/edit/{id}")
    public ResponseEntity<BankDto> editBank(@PathVariable("id") Long id, @RequestBody BankDto accountDto) {
        BankDto resultDto = bankService.editBank(accountDto, id, mapper);
        return ResponseEntity.ok(resultDto);
    }

    @ResponseBody
    @PostMapping("/bank/add")
    public ResponseEntity<BankDto> addBank(@RequestBody BankDto accountDto) {
        BankDto resultDto = bankService.createBank(accountDto, mapper);
        return ResponseEntity.ok(resultDto);
    }


    // -----------------------------------------------------------------------------------------------------------------------------------------------------

    @ResponseBody
    @GetMapping("/bonuses")
    public ResponseEntity<List<BankDto>> getBonuses() {
        List<Bonus> bonuses = bankService.getBonuses();
        List<BankDto> resultList = new ArrayList<>();
        bonuses.forEach(a -> {
            BankDto accountDto = new BankDto();
            mapper.map(a, accountDto);
            resultList.add(accountDto);
        });
        return ResponseEntity.ok(resultList);
    }


    @ResponseBody
    @GetMapping("/bonus/{id}")
    public ResponseEntity<BonusDto> getBonusById(@PathVariable("id") Long id) {
        Optional<Bonus> account = bankService.getBonus(id);
        BonusDto bankDto = new BonusDto();
        account.ifPresent(acc -> mapper.map(acc, bankDto));
        return ResponseEntity.ok(bankDto);
    }

    @ResponseBody
    @GetMapping("/bonus/remove/{id}")
    public ResponseEntity<Boolean> removeBonus(@PathVariable("id") Long id) {
        Boolean aBoolean = bankService.removeBonus(id);
        return ResponseEntity.ok(aBoolean);
    }

    @ResponseBody
    @PostMapping("/bonus/edit/{id}")
    public ResponseEntity<BonusDto> editBonus(@PathVariable("id") Long id, @RequestBody BonusDto bonusDto) {
        BonusDto resultDto = bankService.editBonus(bonusDto, id, mapper);
        return ResponseEntity.ok(resultDto);
    }

    @ResponseBody
    @PostMapping("/bonus/add")
    public ResponseEntity<BonusDto> addBonus(@RequestBody BonusDto bonusDto) {
        BonusDto resultDto = bankService.createBonus(bonusDto, mapper);
        return ResponseEntity.ok(resultDto);
    }


    // -----------------------------------------------------------------------------------------------------------------------------------------------------

    @ResponseBody
    @GetMapping("/cities")
    public ResponseEntity<List<CityDto>> getCities() {
        List<City> bonuses = bankService.getCities();
        List<CityDto> resultList = new ArrayList<>();
        bonuses.forEach(a -> {
            CityDto accountDto = new CityDto();
            mapper.map(a, accountDto);
            resultList.add(accountDto);
        });
        return ResponseEntity.ok(resultList);
    }


    @ResponseBody
    @GetMapping("/city/{id}")
    public ResponseEntity<CityDto> getCityById(@PathVariable("id") Long id) {
        Optional<City> account = bankService.getCity(id);
        CityDto bankDto = new CityDto();
        account.ifPresent(acc -> mapper.map(acc, bankDto));
        return ResponseEntity.ok(bankDto);
    }

    @ResponseBody
    @GetMapping("/city/remove/{id}")
    public ResponseEntity<Boolean> removeCity(@PathVariable("id") Long id) {
        Boolean aBoolean = bankService.removeCity(id);
        return ResponseEntity.ok(aBoolean);
    }

    @ResponseBody
    @PostMapping("/city/edit/{id}")
    public ResponseEntity<CityDto> editCity(@PathVariable("id") Long id, @RequestBody CityDto bonusDto) {
        CityDto resultDto = bankService.editCity(bonusDto, id, mapper);
        return ResponseEntity.ok(resultDto);
    }

    @ResponseBody
    @PostMapping("/city/add")
    public ResponseEntity<CityDto> addCity(@RequestBody CityDto bonusDto) {
        CityDto resultDto = bankService.createCity(bonusDto, mapper);
        return ResponseEntity.ok(resultDto);
    }

    // -----------------------------------------------------------------------------------------------------------------------------------------------------

    @ResponseBody
    @GetMapping("/deposits")
    public ResponseEntity<List<DepositDto>> getDeposits() {
        List<Deposit> bonuses = bankService.getDeposits();
        List<DepositDto> resultList = new ArrayList<>();
        bonuses.forEach(a -> {
            DepositDto accountDto = new DepositDto();
            mapper.map(a, accountDto);
            resultList.add(accountDto);
        });
        return ResponseEntity.ok(resultList);
    }


    @ResponseBody
    @GetMapping("/deposit/{id}")
    public ResponseEntity<DepositDto> getDepositById(@PathVariable("id") Long id) {
        Optional<Deposit> account = bankService.getDeposit(id);
        DepositDto bankDto = new DepositDto();
        account.ifPresent(acc -> mapper.map(acc, bankDto));
        return ResponseEntity.ok(bankDto);
    }

    @ResponseBody
    @GetMapping("/deposit/remove/{id}")
    public ResponseEntity<Boolean> removeDeposit(@PathVariable("id") Long id) {
        Boolean aBoolean = bankService.removeDeposit(id);
        return ResponseEntity.ok(aBoolean);
    }

    @ResponseBody
    @PostMapping("/deposit/edit/{id}")
    public ResponseEntity<DepositDto> editDeposit(@PathVariable("id") Long id, @RequestBody DepositDto depositDto) {
        DepositDto resultDto = bankService.editDeposit(depositDto, id, mapper);
        return ResponseEntity.ok(resultDto);
    }

    @ResponseBody
    @PostMapping("/deposit/add")
    public ResponseEntity<DepositDto> addDeposit(@RequestBody DepositDto bonusDto) {
        System.out.println(bonusDto);
        DepositDto resultDto = bankService.createDeposit(bonusDto, mapper);
        return ResponseEntity.ok(resultDto);
    }

    // -----------------------------------------------------------------------------------------------------------------------------------------------------

    @ResponseBody
    @GetMapping("/plans")
    public ResponseEntity<List<PlanDto>> getPlans() {
        List<Plan> bonuses = bankService.getPlans();
        List<PlanDto> resultList = new ArrayList<>();
        bonuses.forEach(a -> {
            PlanDto planDto = new PlanDto();
            mapper.map(a, planDto);
            resultList.add(planDto);
        });
        return ResponseEntity.ok(resultList);
    }


    @ResponseBody
    @GetMapping("/plan/{id}")
    public ResponseEntity<PlanDto> getPlanById(@PathVariable("id") Long id) {
        Optional<Plan> account = bankService.getPlan(id);
        PlanDto planDto = new PlanDto();
        account.ifPresent(acc -> mapper.map(acc, planDto));
        return ResponseEntity.ok(planDto);
    }

    @ResponseBody
    @GetMapping("/plan/remove/{id}")
    public ResponseEntity<Boolean> removePlan(@PathVariable("id") Long id) {
        Boolean aBoolean = bankService.removePlan(id);
        return ResponseEntity.ok(aBoolean);
    }

    @ResponseBody
    @PostMapping("/plan/edit/{id}")
    public ResponseEntity<PlanDto> editPlan(@PathVariable("id") Long id, @RequestBody PlanDto planDto) {
        PlanDto resultDto = bankService.editPlan(planDto, id, mapper);
        return ResponseEntity.ok(resultDto);
    }

    @ResponseBody
    @PostMapping("/plan/add")
    public ResponseEntity<PlanDto> addPlan(@RequestBody PlanDto planDto) {
        PlanDto resultDto = bankService.createPlan(planDto, mapper);
        return ResponseEntity.ok(resultDto);
    }

    // -----------------------------------------------------------------------------------------------------------------------------------------------------

    @ResponseBody
    @GetMapping("/types")
    public ResponseEntity<List<TypeDto>> getTypes() {
        List<Type> bonuses = bankService.getTypes();
        List<TypeDto> resultList = new ArrayList<>();
        bonuses.forEach(a -> {
            TypeDto typeDto = new TypeDto();
            mapper.map(a, typeDto);
            resultList.add(typeDto);
        });
        return ResponseEntity.ok(resultList);
    }


    @ResponseBody
    @GetMapping("/type/{id}")
    public ResponseEntity<TypeDto> getTypeById(@PathVariable("id") Long id) {
        Optional<Type> account = bankService.getType(id);
        TypeDto typeDto = new TypeDto();
        account.ifPresent(acc -> mapper.map(acc, typeDto));
        return ResponseEntity.ok(typeDto);
    }

    @ResponseBody
    @GetMapping("/type/remove/{id}")
    public ResponseEntity<Boolean> removeType(@PathVariable("id") Long id) {
        Boolean aBoolean = bankService.removeType(id);
        return ResponseEntity.ok(aBoolean);
    }

    @ResponseBody
    @PostMapping("/type/edit/{id}")
    public ResponseEntity<TypeDto> editType(@PathVariable("id") Long id, @RequestBody TypeDto planDto) {
        TypeDto resultDto = bankService.editType(planDto, id, mapper);
        return ResponseEntity.ok(resultDto);
    }

    @ResponseBody
    @PostMapping("/type/add")
    public ResponseEntity<TypeDto> addType(@RequestBody TypeDto planDto) {
        TypeDto resultDto = bankService.createType(planDto, mapper);
        return ResponseEntity.ok(resultDto);
    }

    // -----------------------------------------------------------------------------------------------------------------------------------------------------

    @ResponseBody
    @GetMapping("/restrictions")
    public ResponseEntity<List<RestrictionDto>> getRestriction() {
        List<Restriction> bonuses = bankService.getRestrictions();
        List<RestrictionDto> resultList = new ArrayList<>();
        bonuses.forEach(a -> {
            RestrictionDto restrictionDto = new RestrictionDto();
            mapper.map(a, restrictionDto);
            resultList.add(restrictionDto);
        });
        return ResponseEntity.ok(resultList);
    }


    @ResponseBody
    @GetMapping("/restriction/{id}")
    public ResponseEntity<RestrictionDto> getRestrictionById(@PathVariable("id") Long id) {
        Optional<Restriction> account = bankService.getRestriction(id);
        RestrictionDto restrictionDto = new RestrictionDto();
        account.ifPresent(acc -> mapper.map(acc, restrictionDto));
        return ResponseEntity.ok(restrictionDto);
    }

    @ResponseBody
    @GetMapping("/restriction/remove/{id}")
    public ResponseEntity<Boolean> removeRestriction(@PathVariable("id") Long id) {
        Boolean aBoolean = bankService.removeRestriction(id);
        return ResponseEntity.ok(aBoolean);
    }

    @ResponseBody
    @PostMapping("/restriction/edit/{id}")
    public ResponseEntity<RestrictionDto> editRestriction(@PathVariable("id") Long id, @RequestBody RestrictionDto restrictionDto) {
        RestrictionDto resultDto = bankService.editRestriction(restrictionDto, id, mapper);
        return ResponseEntity.ok(resultDto);
    }

    @ResponseBody
    @PostMapping("/restriction/add")
    public ResponseEntity<RestrictionDto> addRestriction(@RequestBody RestrictionDto restrictionDto) {
        RestrictionDto resultDto = bankService.createRestriction(restrictionDto, mapper);
        return ResponseEntity.ok(resultDto);
    }

}
