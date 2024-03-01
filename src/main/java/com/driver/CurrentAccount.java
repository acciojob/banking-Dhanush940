package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,500);
        this.tradeLicenseId=tradeLicenseId;
        if(balance<getMinBalance())
            throw new Exception("Insufficient Balance");
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        boolean isValid=true;
        for(int i=1;i<tradeLicenseId.length();i++)
        {
            if(tradeLicenseId.charAt(i)==tradeLicenseId.charAt(i-1))
            {
                isValid=false;
                break;
            }
        }
        if(isValid)
            return;
        String rearrangedString=isPossibleToRearrange(tradeLicenseId);
        if(rearrangedString.length()==0)
            throw new Exception("Valid License can not be generated");
        this.tradeLicenseId=rearrangedString;
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public String isPossibleToRearrange(String s)
    {
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++)
            hash[s.charAt(i) - 'a']++;

        int max = 0, letter = 0;
        for (int i = 0; i < hash.length; i++)
        {
            if (hash[i] > max)
            {
                max = hash[i];
                letter = i;
            }
        }

        if (max > (s.length() + 1) / 2) return "";
        char[] res = new char[s.length()];

        // Fill all even places with majority character
        int idx = 0;
        while (hash[letter]-- > 0)
        {
            res[idx] = (char) (letter + 'a');
            idx += 2;
        }

        // Fill the remaining characters
        for (int i = 0; i < hash.length; i++)
        {
            while (hash[i]-- > 0)
            {
                if (idx >= res.length) idx = 1;
                res[idx] = (char) (i + 'a');
                idx += 2;
            }
        }

        return String.valueOf(res);
    }

}
