package topic;

import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/11/3 21:39
 * @description:
 */
public class Meter {

    private double feePerKilometer;

    public void setFeePerKilometer(double feePerKilometer) {
        this.feePerKilometer = feePerKilometer;
    }

    public double charge(int kilometer){
        if (kilometer <= 10){
            return kilometer * feePerKilometer;
        }else {
            return feePerKilometer * 10 + (kilometer - 10) * feePerKilometer * 0.8;
        }
    }

    public static void main(String[] args) {
        Meter meter = new Meter();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the cost per kilometer");
        double mile = sc.nextDouble();
        meter.setFeePerKilometer(mile);
        System.out.println("Please enter the mileage");
        int mileage = sc.nextInt();
        double fee = meter.charge(mileage);
        System.out.println("The total cost is: " + fee);
    }
}