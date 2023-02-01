package com.javarush.task.task36.task3609;

public class SpeedometerView {
  private CarController controller;

    public SpeedometerView(CarController controller) {
        this.controller = controller;
    }

    //    public void printCarDetails(String brand, String model, int speed) {
//        System.out.println("Car: \nBrand: " + brand + "\nModel: " + model + "\nCurrent Speed: " + speed + "\n");
//    }
public void printCarDetails() {
    System.out.println("Car: \nBrand: " + controller.getCarBrand() + "\nModel: " + controller.getCarModel() + "\nCurrent Speed: " + controller.getCarSpeed() + "\n");
}
}