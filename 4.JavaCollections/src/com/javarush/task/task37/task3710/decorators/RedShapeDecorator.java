package com.javarush.task.task37.task3710.decorators;

import com.javarush.task.task37.task3710.shapes.Shape;

public class RedShapeDecorator extends ShapeDecorator{

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }
    private void setBorderColor(Shape shape){
        System.out.println("Setting the border color for " + shape.getClass().getSimpleName() + " to red.");
    }

    @Override
    public void draw() {
        setBorderColor(decoratedShape);
        super.draw();
    }
}
/*
2) Реализуй приватный метод setBorderColor() с одним параметром типа Shape.
Он должен выводить на экран фразу "Setting the border color for XXX to red.", где XXX - имя конкретного декорируемого класса
(можешь воспользоваться методами getClass().getSimpleName() вызванными на объекте полученном в качестве параметра).
3) Переопредели метод draw(), в нем сначала измени цвет отображаемого объекта с помощью метода setBorderColor(), а потом нарисуй его.
 */