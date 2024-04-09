package am.cs322.bank.domain.model;

import am.cs322.user.domain.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "\"bank_account\"")
public class BankAccount {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  private String accountNumber;
  private BigDecimal balance;
  private String accountType;

  public BankAccount() {

  }

  public BankAccount(User user, String accountNumber, BigDecimal balance, String accountType){
    this.user = user;
    this.accountNumber =  accountNumber;
    this.balance = balance;
    this.accountType = accountType;

  }

  public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    BankAccount that = (BankAccount) o;
    return Objects.equals(id, that.id) &&
           Objects.equals(user, that.user) &&
           Objects.equals(accountNumber, that.accountNumber) &&
           Objects.equals(balance, that.balance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, user, accountNumber, balance);
  }

}

