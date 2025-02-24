package com.lddocy.level01.basic;

public class Circle extends Shape implements Resizable {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return getRadius() * getRadius() * Math.PI;
    }

    @Override
    double calculatePerimeter() {
        return 2 * getRadius() * Math.PI;
    }

    @Override
    public void resize(double factor) {
        setRadius(factor * getRadius());
    }

}
