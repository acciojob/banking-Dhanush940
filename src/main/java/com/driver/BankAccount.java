package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getMinBalance() {
        return minBalance;
    }


    public BankAccount(String name, double balance, double minBalance) {
        this.name=name;
        this.balance=balance;
        this.minBalance=minBalance;
    }

    public BankAccount(String name,double balance){
        this.name=name;
        this.balance=balance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception

        String result=generateAccountNumberIfPossible(digits,sum);
        if(result.length()!=0)
            return result;
        throw new Exception("Account Number can not be generated");
    }

    public String generateAccountNumberIfPossible(int digits,int sum)
    {
        if(sum>digits*9)
            return "";
        String res="";
        while(digits-->0)
        {
            for(int i=9;i>=0;i--)
            {
                if(sum>=i)
                {
                    res+=i;
                    sum-=i;
                    break;
                }
            }
        }
        return res;

//        if(digits==0)
//        {
//            if(sum==0)
//                return str;
//            else
//                return "";
//        }
//        for(int start=0;start<=9;start++){
//            if(start<=sum)
//            {
//                sum-=start;
//                digits--;
//                String ans=generateAccountNumberIfPossible(digits,sum,str+start);
//                if(ans.length()!=0)
//                    return ans;
//                sum+=start;
//                digits++;
//            }
//            else
//                break;
//        }
//        return "";
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance+=amount;
    }



    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(this.balance-amount<this.minBalance)
            throw new Exception("Insufficient Balance");
        this.balance-=amount;
    }

}