package am.cs322.bank.business.impl;

import am.cs322.bank.business.api.BankService;
import am.cs322.bank.data.BankAccountRepository;
import am.cs322.bank.domain.model.BankAccount;
import am.cs322.user.data.UserRepository;
import am.cs322.user.domain.model.User;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService implements BankService {

  private BankAccountRepository bankAccountRepository;

  private UserRepository userRepository;

  BankAccountService(BankAccountRepository bankAccountRepository, UserRepository userRepository){
    this.bankAccountRepository = bankAccountRepository;
    this.userRepository = userRepository;
  }

  @Transactional
  @Override
  public BankAccount createBankAccount(Long userId, String accountNumber, BigDecimal initialBalance, String accountType) {
    User user = userRepository.findById(userId).orElse(null);
    if (user == null) {
      return null;
    }
    BankAccount bankAccount = new BankAccount();
    bankAccount.setUser(user);
    bankAccount.setAccountNumber(accountNumber);
    bankAccount.setBalance(initialBalance);
    bankAccount.setAccountType(accountType);
    return bankAccountRepository.save(bankAccount);
  }

  @Transactional
  public void addCredit(Long accountId, BigDecimal amount) {
    BankAccount bankAccount = bankAccountRepository.findById(accountId).orElse(null);
    if (bankAccount == null) {
      return;
    }
    if (!"credit".equalsIgnoreCase(bankAccount.getAccountType())) {
      return;
    }
    BigDecimal newBalance = bankAccount.getBalance().add(amount);
    bankAccount.setBalance(newBalance);
    bankAccountRepository.save(bankAccount);
  }

  @Transactional
  public void addDebit(Long accountId, BigDecimal amount) {
    BankAccount bankAccount = bankAccountRepository.findById(accountId).orElse(null);
    if (bankAccount == null) {
      return;
    }
    if (!"debit".equalsIgnoreCase(bankAccount.getAccountType())) {
      return;
    }
    BigDecimal newBalance = bankAccount.getBalance().add(amount);
    bankAccount.setBalance(newBalance);
    bankAccountRepository.save(bankAccount);
  }

  @Transactional
  public BankAccount findById(Long accountId) {
    return bankAccountRepository.findById(accountId).orElse(null);
  }
}

