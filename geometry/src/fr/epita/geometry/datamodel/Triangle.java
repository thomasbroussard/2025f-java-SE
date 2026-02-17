package fr.epita.geometry.datamodel;

public class Triangle implements Shape {

    private double base;
    private double height;
    private double sideA;
    private double sideB;

    public Triangle(double base, double height, double sideA, double sideB) {
        this.base = base;
        this.height = height;
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public double calculateArea() {
        return (base * height) / 2;
    }

    public double calculatePerimeter() {
        return sideA + sideB + base;
    }



}
