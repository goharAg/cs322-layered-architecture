package am.cs322.bank.presentation.impl;


import am.cs322.bank.presentation.api.BankController;
import am.cs322.bank.presentation.api.model.CreateBankAccountRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/bank")
public class BankControllerImpl implements BankController {

  @Override
  @PostMapping
  public String createBankAccount(final CreateBankAccountRequest request) {
    return "received and created";
  }
}
