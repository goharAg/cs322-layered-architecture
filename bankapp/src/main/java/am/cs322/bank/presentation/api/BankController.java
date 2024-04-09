package am.cs322.bank.presentation.api;

import am.cs322.bank.presentation.api.model.CreateBankAccountRequest;

public interface BankController {

  public String createBankAccount(CreateBankAccountRequest request);

}
