/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googlepaydemo;
//import static googlepaydemo.GooglePayDemo.check;
import static googlepaydemo.setUp.upi;
import java.util.*;
//import java.lang.*;

final class setUp{
    int otp;
    public static String userid="";
    public static String lan="";
    public static String ei="";
    public static String bank="";
    public static int upi,d;
    public static long mn;
    public static double balance;
    Scanner s=new Scanner(System.in);
    setUp(){
        
        int c;
        System.out.println("\t\t\t----------------------Google Pay------------------------------\n");
        System.out.println("\t\tA better way to pay, by Google.\n\n\n\n");
        System.out.println("Welcome to Google Pay!\n\n\n");
        System.out.println("Enter your preferred language to get started: ");
        lan=s.next();
        System.out.println("Enter your mobile number:\n(Use the number on this phone. It should be linked with your bank account.)");
        mn =s.nextLong();
        if(mn<600000000){
            System.out.println("Please enter a valid phone number!");
            mn=s.nextLong();
            
        }
        s.nextLine();
        System.out.println("Enter a GPay ID for your account:");
        userid=s.nextLine();
        System.out.println("Enter your email id:");
        ei=s.next();
        System.out.println("Enter OTP:");
        otp=s.nextInt();
        GooglePayDemo.check(otp);
        System.out.println("You're safe with Google Pay.\nChoose screen lock or Google PIN");
        System.out.println("1. Create phone screen lock.\n2. Create a 4-digit Google PIN.");
        c=s.nextInt();
        switch(c){
            case 1:
                System.out.println("Create a screen lock pattern");
                break;
            case 2:
                System.out.println("Enter your 4-digit Google pin:");
                int pin=s.nextInt();
                break;
            default:
                System.out.println("Please enter a valid choice.");
        }}
        void addBankAcc(){
            s.nextLine();
        System.out.println("ADD YOUR BANK ACCOUNT:\nEnter the name of your bank:");
        bank=s.nextLine();
        System.out.println("Sent SMS for verification.\nVerified mobile number with partner bank.");
        System.out.println("Create a UPI PIN for this bank account.\nYou will enter this PIN for all payments.\n Have your debit card ready to create it.");
        System.out.println("\n\n\nEnter the last 6 digits of your debit/ATM card:");
        d=s.nextInt();
       System.out.println("Enter expiry date in MM/YY format:");
       String e=s.next();
       System.out.println("Enter OTP:");
       otp=s.nextInt();
       GooglePayDemo.check(otp);
       System.out.println("Enter your account balance:");
       balance=s.nextDouble();
    }
    public void setupi(){
        
        System.out.println("Set UPI PIN:");
       upi=s.nextInt();
       System.out.println("Account added!");
    }
    }
class transactions{
    Scanner s=new Scanner(System.in);
    public static String id="";
    public static String rid="";
    public static long mbno;
   
    final static int limit=30000;
    public static void pay(int amt1){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter UPI PIN to proceed: ");
        int u=s.nextInt();
        GooglePayDemo.upicheck(u);
        s.nextLine();
        System.out.println("PAY\nEnter the GPay ID of the person you want to pay:");
        id=s.nextLine();
        System.out.println("Enter the mobile number of the person you want to pay:");
        mbno=s.nextLong();
        if(amt1>limit){
            System.out.println("Your payment can't be processed. Payment amount can't exceed Rs.30,000");
        }else{
            System.out.println("Your payment is being processed...");
            setUp.balance=setUp.balance-amt1;
            System.out.println("Your payment has been processed. New balance is "+setUp.balance);
        }
}
    public static void pay(double amt){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter UPI PIN to proceed: ");
        int u=s.nextInt();
        GooglePayDemo.upicheck(u);
        s.nextLine();
        System.out.println("PAY\nEnter the GPay ID of the person you want to pay:");
        id=s.nextLine();
        System.out.println("Enter the mobile number of the person you want to pay:");
        mbno=s.nextLong();
        if(amt>limit){
            System.out.println("Your payment can't be processed. Payment amount can't exceed Rs.30,000");
        }else{
            System.out.println("Your payment is being processed...");
            setUp.balance=setUp.balance-amt;
            System.out.println("Your payment has been processed. New balance is "+setUp.balance);}
    }
    public static void receive(int at1){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter UPI PIN to proceed: ");
        int u=s.nextInt();
        GooglePayDemo.upicheck(u);
        s.nextLine();
        System.out.println("RECEIVE\nEnter the GPay ID of the person you want to receive from:");
        rid=s.nextLine();
        System.out.println("Enter the mobile number of the person you want to receive from:");
        mbno=s.nextLong();
        if(at1>limit){
            System.out.println("Your transaction can't be processed. You can't receive more than Rs.30,000");
        }
        else{
            System.out.println("Your transaction is being processed...");
            setUp.balance=setUp.balance+at1;
            System.out.println("Your transaction has been processed. New balance is "+setUp.balance);
        }}
    public static void receive(double at){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter UPI PIN to proceed: ");
        int u=s.nextInt();
        GooglePayDemo.upicheck(u);
        s.nextLine();
        System.out.println("RECEIVE\nEnter the GPay ID of the person you want to receive from:");
        rid=s.nextLine();
        System.out.println("Enter the mobile number of the person you want to receive from:");
        mbno=s.nextLong();
        if(at>limit){
            System.out.println("Your transaction can't be processed. You can't receive more than Rs.30,000");
        }
        else{
            System.out.println("Your transaction is being processed...");
            setUp.balance=setUp.balance+at;
            System.out.println("Your transaction has been processed. New balance is "+setUp.balance);
        }
}
}
interface operationsModel{
    void displaytransactions();
    void checkbalance();
}
class operations implements operationsModel{
    Scanner s =new Scanner(System.in);
    @Override
    public void displaytransactions(){
    System.out.println("-----------------TRANSACTIONS------------------");
    System.out.println("PAID:\nPaid to: "+transactions.id+"\nAmount paid: "+GooglePayDemo.a);
    System.out.println("RECEIVED:\nReceived from: "+transactions.rid+"\nAmount received: "+GooglePayDemo.rec);
}
    @Override
    public void checkbalance(){
        System.out.println("Enter UPI PIN to proceed: ");
        int u=s.nextInt();
        GooglePayDemo.upicheck(u);
        System.out.println("Current balance is "+setUp.balance);
    }
}
 interface profileModel{
     void displayProfile();
     void displayAccount();
     void settings();
 }
class profile implements profileModel{
    Scanner s=new Scanner(System.in);
    @Override
    public void displayProfile(){
        System.out.println("PROFILE\nGPay ID: "+setUp.userid+"\nMobile No.: "+setUp.mn+"\nEmail id: "+setUp.ei);
    }
    @Override
    public void displayAccount(){
        System.out.println("ACCOUNT:\nSigned in as "+setUp.ei+"\nMobile No.: "+setUp.mn+"\nPayment Methods: "+setUp.bank+" "+setUp.d+"\nPreferred Language: "+setUp.lan);
    }
    @Override
    public void settings(){
        System.out.println("1.Notification settings\n2.Log out from Google Pay\n3.Close account\n");
        int c=s.nextInt();
        switch(c){
            case 1:
                System.out.println("Do you want to disable notifications from this app? Y/N");
                String r=s.next();
                if("Y".equals(r)){
                    System.out.println("Notifications are disabled from this app.");
                }
                break;
            case 2:
                System.out.println("You are logged out from Google Pay.");
               break;
            case 3:
                System.out.println("Your account has been closed.");
            default:
                System.out.println("Please enter a valid choice.");
        }
    }
    
}


public class GooglePayDemo {
    public static double a, rec;

    public static void check(int i){
    if(i==1234){
        System.out.println("Valid OTP.");
    }else{
        throw new ArithmeticException("Invalid OTP.");
    }
}
    public static void upicheck(int u){
        if(u==setUp.upi){
            System.out.println("Valid UPI PIN.");
        }
        else{
            throw new ArithmeticException("Invalid UPI PIN.");
    }
    }
public static void main(String[] args) {
    Scanner s= new Scanner(System.in);
       setUp t=new setUp();
       
       t.addBankAcc();
       t.setupi();
       System.out.println("Do you want to make a transaction? Y/N");
       String r=s.next();
       if("Y".equals(r)){
           transactions ti=new transactions();
            
           System.out.println("Do you want to\n1.Pay\nor\n2.Receive ?");
           int g=s.nextInt();
           switch(g){
               case 1:
                   System.out.println("Enter the amount you want to pay:");
                   a=s.nextDouble();
                ti.pay(a);
                break;
               case 2:
                   System.out.println("Enter the amount you want to receive:");
                   rec=s.nextDouble();
                   ti.receive(rec);
                   break;
               default:
                   System.out.println("Please enter a valid choice.");
           }
       }
       System.out.println("Do you want to\n 1.Display your transactions\n2.Check account balance ?");
       int l=s.nextInt();
       operations o=new operations();
       switch(l){
           case 1:
               o.displaytransactions();
               break;
           case 2:
               o.checkbalance();
               break;
               default:
               System.out.println("Please enter a valid choice.");
       }
       System.out.println("Do you want to view your profile? Y/N");
       r=s.next();
       if("Y".equals(r)){
           profile p=new profile();
           System.out.println("1.Display Profile\n2.Display Account\n3.Go to settings");
           int y=s.nextInt();
           switch(y){
               case 1:
                   p.displayProfile();
                   break;
               case 2:
                   p.displayAccount();
                   break;
               case 3:
                   p.settings();
                   break;
               default:
                   System.out.println("Please enter a valid choice.");
               
           }
       }
    }
    
}
