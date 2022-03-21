package dataStructures;

import java.util.*;
import java.lang.*;
import java.text.*;
import java.math.*;


class Test extends AccountHolder { 
private static final String TEXT =  "I am a {0} account with {1,number,#} units of {2} currency";

public static void main(String args[] ) throws Exception {

    List<BankAccount> accounts = new ArrayList<BankAccount>();
    accounts.add(new SavingsAccount("USD",3));//Savings
    accounts.add(new SavingsAccount("EUR",2));//Savings
    accounts.add(new CheckingAccount("HUF",100));//Checking
    accounts.add(new CheckingAccount("COP",10000));//Checking
    accounts.add(new BrokerageAccount("GBP",2));//Brokerage
    accounts.add(new BrokerageAccount("INR",600));//Brokerage

    accounts.stream().forEach(
                                account -> System.out.println(
                                    MessageFormat.format(TEXT,
                                        new Object[]{

account.getAccountType().getName(),//make this work
                                        account.getUnits(),//make this work
                                        account.getCurrency()//make this work
                                                       })));
}

AccountHolder customer = new AccountHolder();
Integer units;
String currency;

void setCustomer(AccountHolder acctHolder) {
    this.customer = acctHolder;
}

AccountHolder getAccountType() {
    return customer;
}

//set units
void setUnits(Integer unit) {
    this.units = unit;
}

void setType(String type) {
    customer.setType(type);
}

Integer getUnits() {
    return units;
}

//set currency 
void setCurrency(String curr) {
    this.currency = curr;       
}

String getCurrency() {
    return currency;
 }
}

class BankAccount {

  public AccountHolder getAccountType() {
    // TODO Auto-generated method stub
    return null;
  }

  public Object getCurrency() {
    // TODO Auto-generated method stub
    return null;
  }

  public Object getUnits() {
    // TODO Auto-generated method stub
    return null;
  }

  public void setUnits(Integer unit) {
    // TODO Auto-generated method stub
    
  }

  public void setCurrency(String curr) {
    // TODO Auto-generated method stub
    
  }

 }

class SavingsAccount extends BankAccount {

 SavingsAccount(String curr, Integer unit) {
    super.getAccountType().setName("Saving");
    super.setUnits(unit);
    super.setCurrency(curr);
  } 
 }

class CheckingAccount extends BankAccount {

 CheckingAccount(String curr, Integer unit) {
    super.setUnits(unit);
    super.getAccountType().setName("Checking");
    super.setCurrency(curr);
 }  
}

class BrokerageAccount extends BankAccount {

BrokerageAccount(String curr, Integer unit) {
    super.getAccountType().setName("Brokerage");
    super.setUnits(unit);
    super.setCurrency(curr);
    }   
 }

class AccountHolder {

 String name;
 String acctType;

 String getName() {
    return name;
 }   

 void setName(String name) {
    this.name = name;
 }

 void setType(String type) {
    this.acctType = type;
 }

 String getType() {
    return acctType;
 }
}