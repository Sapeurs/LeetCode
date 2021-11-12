package topic;

import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/11/4 14:32
 * @description:
 */
public class Cube {

    double length;

    double width;

    double height;


    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double volume() {
        return length * width * height;
    }

    public double area() {
        return length * width * 2 + width * height * 2 + length * height * 2;
    }

    public static void main(String[] args) {
        Cube cube = new Cube();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the length of the cube");
        int length = sc.nextInt();
        cube.setLength(length);
        System.out.println("Please enter the width of the cube");
        int width = sc.nextInt();
        cube.setWidth(width);
        System.out.println("Please enter the height of the cube");
        int height = sc.nextInt();
        cube.setHeight(height);
        System.out.println("The volume of the cube is: " + cube.volume());
        System.out.println("The Area of the cube is: " + cube.area());
    }
}