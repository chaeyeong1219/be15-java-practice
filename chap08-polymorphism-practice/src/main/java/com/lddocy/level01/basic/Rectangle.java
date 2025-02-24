package com.lddocy.level01.basic;

public class Rectangle extends Shape implements Resizable {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    double calculateArea() {
        return getWidth() * getHeight();
    }

    @Override
    double calculatePerimeter() {
        return 2 * (getWidth() + getHeight());
    }

    @Override
    public void resize(double factor) {
        setWidth(factor * getWidth());
        setHeight(factor * getHeight());
    }

}
