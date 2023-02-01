package com.javarush.task.task36.task3609;

/* 
Рефакторинг MVC
*/

public class Solution {
    public static void main(String[] args) {
        // Fetch car record from the database
        CarModel model = retrieveCarFromDatabase();
        CarController controller = new CarController(model);

        SpeedometerView view = new SpeedometerView(controller);
        view.printCarDetails();


        // Update the model data
        controller.increaseSpeed(15);
        view.printCarDetails();

        // Update the model data
        controller.increaseSpeed(50);
        view.printCarDetails();


        // Update the model data
        controller.decreaseSpeed(7);
        view.printCarDetails();

    }

    private static CarModel retrieveCarFromDatabase() {
        CarModel currentCar = new CarModel();
        currentCar.setBrand("Nissan");
        currentCar.setModel("Almera Classic");
        currentCar.setSpeed(0);
        currentCar.setMaxSpeed(200);
        return currentCar;
    }
}