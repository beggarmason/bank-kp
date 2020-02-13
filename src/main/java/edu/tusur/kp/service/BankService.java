package edu.tusur.kp.service;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import edu.tusur.kp.jpa.dto.*;
import edu.tusur.kp.jpa.model.*;
import edu.tusur.kp.jpa.repositories.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BankService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AmountRepository amountRepository;

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private BonusRepository bonusRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private DepositRepository depositRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private RestrictionRepository restrictionRepository;

    @Autowired
    private TypeRepository typeRepository;

    public Boolean removeAccount(Long id) {
        Objects.nonNull(id);
        Optional<Account> byId = accountRepository.findById(id);
        if (byId.isPresent()) {
            Account account = byId.get();
            accountRepository.delete(account);
            return true;
        }
        return false;
    }

    public AccountDto createAccount(AccountDto accountDto, ModelMapper mapper) {
        Account account = new Account();
        account.setNumber(accountDto.getNumber());
        account.setActive(accountDto.getActive());
        account.setCreated(accountDto.getCreated());
        Optional<Person> byId = personRepository.findById(accountDto.getPersonId());
        byId.ifPresent(account::setPerson);

        account.setRestriction(null);
        Account save = accountRepository.save(account);
        mapper.map(save, accountDto);
        return accountDto;
    }

    public AccountDto editAccount(AccountDto accountDto, Long id, ModelMapper mapper) {
        System.out.println(accountDto);
        if (id == null)
            return accountDto;

        Optional<Account> byId = accountRepository.findById(id);
        if (byId.isPresent()) {
            Account account = byId.get();
            account.setActive(accountDto.getActive());
            account.setCreated(accountDto.getCreated());
            account.setNumber(accountDto.getNumber());

            if(accountDto.getPersonId() != null) {
                Optional<Person> byId1 = personRepository.findById(accountDto.getPersonId());
                byId1.ifPresent(account::setPerson);
            }

            Account save = accountRepository.save(account);
            mapper.map(save, accountDto);
        }

        return accountDto;
    }

    public Boolean removeAmount(Long id) {
        Objects.nonNull(id);
        Optional<Amount> byId = amountRepository.findById(id);
        if (byId.isPresent()) {
            Amount amount = byId.get();
            amountRepository.delete(amount);
            return true;
        }
        return false;
    }

    public AmountDto createAmount(AmountDto amountDto, ModelMapper mapper) {
        Amount amount = new Amount();
        amount.setActive(amountDto.getActive());
        amount.setBalance(amountDto.getBalance());
        amount.setDebt(amountDto.getDebt());
        amount.setName(amountDto.getName());
        Optional<Deposit> deposit = depositRepository.findById(amountDto.getDepositId());
        Optional<Account> accOpt = accountRepository.findById(amountDto.getAccountId());
        deposit.ifPresent(amount::setDeposit);
        accOpt.ifPresent(amount::setAccount);

        Amount save = amountRepository.save(amount);
        mapper.map(save, amountDto);
        return amountDto;
    }

    public AmountDto editAmount(AmountDto accountDto, Long id, ModelMapper mapper) {
        System.out.println(accountDto);
        if (id == null)
            return accountDto;

        Optional<Amount> byId = amountRepository.findById(id);
        if (byId.isPresent()) {
            Amount amount = byId.get();
            amount.setActive(accountDto.getActive());
            amount.setBalance(accountDto.getBalance());
            amount.setDebt(accountDto.getDebt());
            amount.setName(accountDto.getName());

            if(accountDto.getAccountId() != null) {
                Optional<Account> byId1 = accountRepository.findById(accountDto.getAccountId());
                byId1.ifPresent(amount::setAccount);
            }

            if(accountDto.getDepositId() != null) {
                Optional<Deposit> byId1 = depositRepository.findById(accountDto.getDepositId());
                byId1.ifPresent(amount::setDeposit);
            }

            Amount save = amountRepository.save(amount);
            mapper.map(save, accountDto);
        }

        return accountDto;
    }


    public Boolean removeBank(Long id) {
        Objects.nonNull(id);
        Optional<Bank> byId = bankRepository.findById(id);
        if (byId.isPresent()) {
            Bank amount = byId.get();
            bankRepository.delete(amount);
            return true;
        }
        return false;
    }

    public BankDto createBank(BankDto bankDto, ModelMapper mapper) {
        Bank bank = new Bank();
        bank.setActive(bankDto.getActive());
        bank.setName(bankDto.getName());
        bank.setCreated(bankDto.getCreated());

        Bank save = bankRepository.save(bank);
        mapper.map(save, bankDto);
        return bankDto;
    }

    public BankDto editBank(BankDto bankDto, Long id, ModelMapper mapper) {
        System.out.println(bankDto);
        if (id == null)
            return bankDto;

        Optional<Bank> byId = bankRepository.findById(id);
        if (byId.isPresent()) {
            Bank bankEnt = byId.get();
            bankEnt.setActive(bankDto.getActive());
            bankEnt.setCreated(bankDto.getCreated());
            bankEnt.setName(bankDto.getName());

            Bank bank = bankRepository.save(bankEnt);
            mapper.map(bank, bankDto);
        }

        return bankDto;
    }

    public Boolean removeBonus(Long id) {
        Objects.nonNull(id);
        Optional<Bonus> byId = bonusRepository.findById(id);
        if (byId.isPresent()) {
            Bonus bonus = byId.get();
            bonusRepository.delete(bonus);
            return true;
        }
        return false;
    }

    public BonusDto createBonus(BonusDto bonusDto, ModelMapper mapper) {
        Bonus bonus = new Bonus();
        bonus.setActive(bonusDto.getActive());
        bonus.setYear(bonusDto.getYear());
        bonus.setCreated(bonusDto.getCreated());

        Bonus save = bonusRepository.save(bonus);
        mapper.map(save, bonusDto);
        return bonusDto;
    }

    public BonusDto editBonus(BonusDto bonusDto, Long id, ModelMapper mapper) {
        System.out.println(bonusDto);
        if (id == null)
            return bonusDto;

        Optional<Bonus> byId = bonusRepository.findById(id);
        if (byId.isPresent()) {
            Bonus bonus = byId.get();
            bonus.setActive(bonusDto.getActive());
            bonus.setCreated(bonusDto.getCreated());
            bonus.setYear(bonusDto.getYear());

            Bonus save = bonusRepository.save(bonus);
            mapper.map(save, bonusDto);
        }

        return bonusDto;
    }

    public Boolean removeCity(Long id) {
        Objects.nonNull(id);
        Optional<City> byId = cityRepository.findById(id);
        if (byId.isPresent()) {
            City bonus = byId.get();
            cityRepository.delete(bonus);
            return true;
        }
        return false;
    }

    public CityDto createCity(CityDto cityDto, ModelMapper mapper) {
        City city = new City();
        city.setYear(cityDto.getYear());
        city.setName(cityDto.getName());

        City save = cityRepository.save(city);
        mapper.map(save, cityDto);
        return cityDto;
    }

    public CityDto editCity(CityDto cityDto, Long id, ModelMapper mapper) {
        System.out.println(cityDto);
        if (id == null)
            return cityDto;

        Optional<City> byId = cityRepository.findById(id);
        if (byId.isPresent()) {
            City city = byId.get();
            city.setName(cityDto.getName());
            city.setYear(cityDto.getYear());

            City save = cityRepository.save(city);
            mapper.map(save, cityDto);
        }

        return cityDto;
    }

    // ------------------------------------------------------------------------------------------

    public Boolean removeDeposit(Long id) {
        Objects.nonNull(id);
        Optional<Deposit> byId = depositRepository.findById(id);
        if (byId.isPresent()) {
            Deposit bonus = byId.get();
            depositRepository.delete(bonus);
            return true;
        }
        return false;
    }

    public DepositDto createDeposit(DepositDto depositDto, ModelMapper mapper) {
        Deposit deposit = new Deposit();
        deposit.setCurrency(depositDto.getCurrency());
        deposit.setName(depositDto.getName());
        deposit.setFromDate(depositDto.getFromDate());
        deposit.setToDate(depositDto.getToDate());
        deposit.setYear(depositDto.getYear());
        personRepository.findById(depositDto.getPersonid()).ifPresent(deposit::setPerson);
        planRepository.findById(depositDto.getPlanid()).ifPresent(deposit::setPlan);
        typeRepository.findById(depositDto.getTypeid()).ifPresent(deposit::setType);
        bonusRepository.findById(depositDto.getBonusid()).ifPresent(deposit::setBonus);
        deposit.setRestriction(null);

        Deposit save = depositRepository.save(deposit);
        mapper.map(save, depositDto);
        return depositDto;
    }

    public DepositDto editDeposit(DepositDto depositDto, Long id, ModelMapper mapper) {
        System.out.println(depositDto);
        if (id == null)
            return depositDto;

        Optional<Deposit> byId = depositRepository.findById(id);
        if (byId.isPresent()) {
            Deposit deposit = byId.get();
            deposit.setName(depositDto.getName());
            deposit.setCurrency(depositDto.getCurrency());
            deposit.setFromDate(depositDto.getFromDate());
            deposit.setToDate(depositDto.getToDate());
            deposit.setYear(depositDto.getYear());
            if (depositDto.getPersonid() != null) {
                personRepository.findById(depositDto.getPersonid()).ifPresent(deposit::setPerson);
            }
            if (depositDto.getBonusid() != null) {
                bonusRepository.findById(depositDto.getBonusid()).ifPresent(deposit::setBonus);
            }
            if (depositDto.getPersonid() != null) {
                typeRepository.findById(depositDto.getTypeid()).ifPresent(deposit::setType);
            }
            if (depositDto.getPersonid() != null) {
                planRepository.findById(depositDto.getPlanid()).ifPresent(deposit::setPlan);
            }

            Deposit save = depositRepository.save(deposit);
            mapper.map(save, depositDto);
        }

        return depositDto;
    }

    public Boolean removePlan(Long id) {
        Objects.nonNull(id);
        Optional<Plan> byId = planRepository.findById(id);
        if (byId.isPresent()) {
            Plan bonus = byId.get();
            planRepository.delete(bonus);
            return true;
        }
        return false;
    }

    public PlanDto createPlan(PlanDto planDto, ModelMapper mapper) {
        Plan bonus = new Plan();
        bonus.setActive(planDto.getActive());
        bonus.setYear(planDto.getYear());
        bonus.setCreated(planDto.getCreated());

        Plan save = planRepository.save(bonus);
        mapper.map(save, planDto);
        return planDto;
    }

    public PlanDto editPlan(PlanDto planDto, Long id, ModelMapper mapper) {
        System.out.println(planDto);
        if (id == null)
            return planDto;

        Optional<Plan> byId = planRepository.findById(id);
        if (byId.isPresent()) {
            Plan bonus = byId.get();
            bonus.setActive(planDto.getActive());
            bonus.setCreated(planDto.getCreated());
            bonus.setYear(planDto.getYear());

            Plan save = planRepository.save(bonus);
            mapper.map(save, planDto);
        }

        return planDto;
    }

    public Boolean removeType(Long id) {
        Objects.nonNull(id);
        Optional<Type> byId = typeRepository.findById(id);
        if (byId.isPresent()) {
            Type type = byId.get();
            typeRepository.delete(type);
            return true;
        }
        return false;
    }

    public TypeDto createType(TypeDto typeDto, ModelMapper mapper) {
        Type bonus = new Type();
        bonus.setName(typeDto.getName());
        bonus.setYear(typeDto.getYear());
        bonus.setCreated(typeDto.getCreated());

        Type save = typeRepository.save(bonus);
        mapper.map(save, typeDto);
        return typeDto;
    }

    public TypeDto editType(TypeDto typeDto, Long id, ModelMapper mapper) {
        System.out.println(typeDto);
        if (id == null)
            return typeDto;

        Optional<Type> byId = typeRepository.findById(id);
        if (byId.isPresent()) {
            Type type = byId.get();
            type.setName(typeDto.getName());
            type.setCreated(typeDto.getCreated());
            type.setYear(typeDto.getYear());

            Type save = typeRepository.save(type);
            mapper.map(save, typeDto);
        }

        return typeDto;
    }

    public Boolean removeRestriction(Long id) {
        Objects.nonNull(id);
        Optional<Restriction> byId = restrictionRepository.findById(id);
        if (byId.isPresent()) {
            Restriction type = byId.get();
            restrictionRepository.delete(type);
            return true;
        }
        return false;
    }

    public RestrictionDto createRestriction(RestrictionDto restrictionDto, ModelMapper mapper) {
        Restriction restriction = new Restriction();
        restriction.setYear(restrictionDto.getYear());
        restriction.setCreated(restrictionDto.getCreated());

        Restriction save = restrictionRepository.save(restriction);
        mapper.map(save, restrictionDto);
        return restrictionDto;
    }

    public RestrictionDto editRestriction(RestrictionDto restrictionDto, Long id, ModelMapper mapper) {
        System.out.println(restrictionDto);
        if (id == null)
            return restrictionDto;

        Optional<Restriction> byId = restrictionRepository.findById(id);
        if (byId.isPresent()) {
            Restriction restriction = byId.get();
            restriction.setCreated(restrictionDto.getCreated());
            restriction.setYear(restrictionDto.getYear());

            Restriction save = restrictionRepository.save(restriction);
            mapper.map(save, restrictionDto);
        }

        return restrictionDto;
    }

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> getAccount(Long id) {
        return accountRepository.findById(id);
    }

    public List<Amount> getAmounts() {
        return amountRepository.findAll();
    }

    public Optional<Amount> getAmount(Long id) {
        return amountRepository.findById(id);
    }

    public List<Bank> getBanks() {
        return bankRepository.findAll();
    }

    public Optional<Bank> getBank(Long id) {
        return bankRepository.findById(id);
    }

    public List<Bonus> getBonuses() {
        return bonusRepository.findAll();
    }

    public Optional<Bonus> getBonus(Long id) {
        return bonusRepository.findById(id);
    }

    public List<City> getCities() {
        return cityRepository.findAll();
    }

    public Optional<City> getCity(Long id) {
        return cityRepository.findById(id);
    }

    public List<Deposit> getDeposits() {
        return depositRepository.findAll();
    }

    public Optional<Deposit> getDeposit(Long id) {
        return depositRepository.findById(id);
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> getPerson(Long id) {
        return personRepository.findById(id);
    }

    public List<Plan> getPlans() {
        return planRepository.findAll();
    }

    public Optional<Plan> getPlan(Long id) {
        return planRepository.findById(id);
    }

    public List<Restriction> getRestrictions() {
        return restrictionRepository.findAll();
    }

    public Optional<Restriction> getRestriction(Long id) {
        return restrictionRepository.findById(id);
    }

    public List<Type> getTypes() {
        return typeRepository.findAll();
    }

    public Optional<Type> getType(Long id) {
        return typeRepository.findById(id);
    }

}
