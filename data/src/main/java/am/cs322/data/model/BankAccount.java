package am.cs322.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "\"bank_account\"")
public class BankAccount {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;


  private Long userId;

  private String accountNumber;
  private BigDecimal balance;
  private String accountType;

  public BankAccount() {

  }

  public BankAccount(Long userId, String accountNumber, BigDecimal balance, String accountType){
    this.userId = userId;
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

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
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
           Objects.equals(userId, that.userId) &&
           Objects.equals(accountNumber, that.accountNumber) &&
           Objects.equals(balance, that.balance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userId, accountNumber, balance);
  }

}

