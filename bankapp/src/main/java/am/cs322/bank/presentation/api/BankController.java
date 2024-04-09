package am.cs322.bank.presentation.api;


import am.cs322.bank.presentation.api.model.CreateBankAccountRequest;
import am.cs322.data.model.BankAccount;
import java.math.BigDecimal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface BankController {

  public ResponseEntity<BankAccount> createBankAccount(@RequestBody CreateBankAccountRequest request);

  public ResponseEntity<Void> debit(@PathVariable("accountId") Long accountId, @RequestParam
  BigDecimal amount);

  public ResponseEntity<Void> credit(@PathVariable("accountId") Long accountId, @RequestParam BigDecimal amount);

}
