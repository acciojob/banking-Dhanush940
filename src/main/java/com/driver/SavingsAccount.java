package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name,balance,0);
        this.rate=rate;
        this.maxWithdrawalLimit=maxWithdrawalLimit;

    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if(amount<=maxWithdrawalLimit)
           super.withdraw(amount);
        else
            throw new Exception("Maximum Withdraw Limit Exceeded");

    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount

        return getBalance()+(getBalance()*years*rate)/100;

    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
//        return getBalance() * (Math.pow((1 + rate/100), (times * years))) - getBalance();
        return getBalance() * Math.pow((1 + rate / (100 * times)), times * years);
    }

}
