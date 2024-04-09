package am.cs322.bank.business.api;

import am.cs322.bank.domain.model.BankAccount;
import java.math.BigDecimal;

public interface BankService {

  public BankAccount createBankAccount(Long userId, String accountNumber, BigDecimal initialBalance, String accountType);
}
