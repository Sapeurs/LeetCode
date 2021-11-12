package topic;

import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/11/3 19:43
 * @description:
 */
public class Phone {
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void telCall(String callNumber){
        if (callNumber.length() != 11){
            System.out.println("Invalid number!");
        }else {
            System.out.println("Call number " + callNumber);
        }
    }

    public static void main(String[] args) {
        Phone phone = new Phone();
        System.out.println("Please enter the phone number:");
        Scanner sc = new Scanner(System.in);
        String theNumber = sc.nextLine();
        phone.setPhoneNumber(theNumber);
        System.out.println("The phone number is: " + phone.getPhoneNumber());
        System.out.println("Please enter the number you want to call: ");
        String callNumber = sc.nextLine();
        phone.telCall(callNumber);
    }
}


