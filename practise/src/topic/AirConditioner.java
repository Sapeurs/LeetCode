package topic;

import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/11/4 15:05
 * @description:
 */
public class AirConditioner {

    private int temperature;

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void raiseTemp(int temp){
        this.temperature+=temp;
        System.out.println("Air conditioner temperature increased by " + temp +" °C");
    }

    public void lowerTemp(int temp){
        this.temperature-=temp;
        System.out.println("Air conditioner temperature decreased by " + temp +" °C");
    }

    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the initial temperature of the air conditioner:");
        int temperature = sc.nextInt();
        airConditioner.setTemperature(temperature);
        System.out.println("Please enter the temperature of the air conditioner to be increased:");
        int raise = sc.nextInt();
        airConditioner.raiseTemp(raise);
        System.out.println("The current temperature of the air conditioner is: " + airConditioner.getTemperature() + " °C");
        System.out.println("Please enter the temperature of the air conditioner to be decreased:");
        int lower = sc.nextInt();
        airConditioner.lowerTemp(lower);
        System.out.println("The current temperature of the air conditioner is: " + airConditioner.getTemperature() + " °C");

    }
}