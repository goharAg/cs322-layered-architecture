package am.cs322.bank.presentation.api.model;

import org.antlr.v4.runtime.misc.NotNull;

public record CreateBankAccountRequest(
    @NotNull String userId,
    @NotNull  String cardType
) {

}