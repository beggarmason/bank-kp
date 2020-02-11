package edu.tusur.kp.service;

import edu.tusur.kp.jpa.dto.AccountDto;
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

    public AccountDto editAccount(AccountDto accountDto, String type, ModelMapper mapper) {
        if (accountDto.getId() == null)
            return accountDto;

        switch (type) {
            case "edit":
                Optional<Account> byId = accountRepository.findById(accountDto.getId());
                if (byId.isPresent()) {
                    Account account = byId.get();
                    account.setId(accountDto.getId());
                    account.setActive(accountDto.getActive());
                    account.setCreated(accountDto.getCreated());
                    Account save = accountRepository.save(account);
                    mapper.map(save, accountDto);
                }
                return accountDto;

            case "create":
                Account account = new Account();
                account.setCreated(accountDto.getCreated());
                account.setActive(accountDto.getActive());
                Person person = new Person();
                mapper.map(accountDto.getPerson(), person);
                account.setPerson(person);
                Account save = accountRepository.save(account);
                return accountDto;
        }
        return accountDto;
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
