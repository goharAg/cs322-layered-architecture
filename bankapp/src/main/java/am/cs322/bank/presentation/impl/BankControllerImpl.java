package am.cs322.bank.presentation.impl;


import am.cs322.bank.business.impl.BankAccountService;
import am.cs322.bank.domain.model.BankAccount;
import am.cs322.bank.presentation.api.model.CreateBankAccountRequest;
import am.cs322.user.domain.model.User;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bank-accounts")
public class BankControllerImpl {

  @Autowired
  private BankAccountService bankAccountService;

  @PostMapping("/create")
  public ResponseEntity<BankAccount> createBankAccount(@RequestBody CreateBankAccountRequest request) {
    Long userId = request.userId();
    String accountNumber = request.accountNumber();
    BigDecimal initialBalance = BigDecimal.valueOf(request.initialBalance());
    String accountType = request.accountType();

    BankAccount bankAccount = bankAccountService.createBankAccount(userId, accountNumber, initialBalance, accountType );
    return ResponseEntity.ok(bankAccount);
  }

  @PostMapping("/{accountId}/debit")
  public ResponseEntity<Void> debit(@PathVariable("accountId") Long accountId, @RequestParam
  BigDecimal amount) {
    BankAccount bankAccount = bankAccountService.findById(accountId);
    if (bankAccount == null) {
      return ResponseEntity.notFound().build();
    }

    bankAccountService.addDebit(accountId, amount);
    return ResponseEntity.ok().build();
  }

  @PostMapping("/{accountId}/credit")
  public ResponseEntity<Void> credit(@PathVariable("accountId") Long accountId, @RequestParam BigDecimal amount) {
    BankAccount bankAccount = bankAccountService.findById(accountId);
    if (bankAccount == null) {
      return ResponseEntity.notFound().build();
    }

    bankAccountService.addCredit(accountId, amount);
    return ResponseEntity.ok().build();
  }
}
