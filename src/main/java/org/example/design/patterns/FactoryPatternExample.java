package org.example.design.patterns;

/**
 * In Factory pattern, we create object without exposing the creation logic to the client and
 * refer to newly created object using a common interface. Factory pattern is one of the most used
 * design patterns in Java. This type of design pattern comes under creational pattern as this pattern
 * provides one of the best ways to create an object.
 *
 * This Null Object Pattern is all about handling the null keyword in a way that removes all of those
 * nasty if (object != null) checks from your code.
 */

interface Shape{
    void setShapeColor(String color);
    String draw();
}

enum ShapeType{
    CIRCLE,
    RECTANGLE;
}

class Circle implements Shape{

    private String color;
    private String name;

    public Circle(String name){
        this.name = name;
    }
    @Override
    public void setShapeColor(String color) {
        this.color=color;
    }

    @Override
    public String draw() {
        return "This is :"+this.name+"with color: "+ this.color;
    }
}

class Rectangle implements Shape{

    private String color;
    private String name;

    public Rectangle(String name){
        this.name=name;
    }
    @Override
    public void setShapeColor(String color) {
        this.color=color;
    }

    @Override
    public String draw() {
        return "This is :"+this.name+"with coloe: "+color;
    }

}

class NullHandler implements Shape{

    String name;
    String color;

    public NullHandler(String name){
        this.name=name;
    }

    @Override
    public void setShapeColor(String color) {
        this.color = color;
    }

    @Override
    public String draw() {
        return "Sorry the type"+ this.name +"is not instantiable";
    }
}
class ShapeFactory{
    public  Shape getShapeInstance(String shape){
        if(ShapeType.CIRCLE.toString().equals(shape.toUpperCase())){
            return new Circle(shape);
        }else if(ShapeType.RECTANGLE.toString().equals(shape.toUpperCase())){
            return new Rectangle(shape);
        }
return new NullHandler(shape);
    }
}
public class FactoryPatternExample {
    public static void main(String[] args) {
        ShapeFactory sf = new ShapeFactory();
        Shape myShape = sf.getShapeInstance("Square");
        myShape.setShapeColor("blue");
        System.out.println(myShape.draw());

        Shape myShape2 = sf.getShapeInstance("Circle");
        myShape2.setShapeColor("Green");
        System.out.println(myShape2.draw());
    }
}


