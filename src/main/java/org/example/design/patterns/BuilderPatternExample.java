package org.example.design.patterns;

//Implement the builder pattern to create burger food chain system
/**
 * Builder pattern builds a complex object using simple objects and using a step by step approach. This
 * type of design pattern comes under creational pattern as this pattern provides one of the best ways
 * to create an object.
 */

import java.util.ArrayList;
import java.util.List;

interface FoodItems{
    public String name();
    public int price();
    public String packing();
}

interface Packaging{
    public void wrap();
}

class BoxWrap implements Packaging{

    @Override
    public void wrap() {
        System.out.println("This is Boxwrap");
    }
}

class BottleWrap implements Packaging{

    @Override
    public void wrap() {
        System.out.println("this is bottle wrap");
    }
}

interface Burger extends FoodItems{
    public String getType();
}

interface Drinks extends FoodItems{
    public String getDrink();
}

//Concrete implementation of the Burger interface
class VegBurger implements Burger{

    @Override
    public String getType() {
        return "This is Veg Burger";
    }

    @Override
    public String name() {
        System.out.println("This is Veggie Masala");
        return "Veggie Masala";
    }

    @Override
    public int price() {
        System.out.println("Price is : Rs"+ 45);
        return 45;
    }

    @Override
    public String packing() {
        BoxWrap wrap = new BoxWrap();
        wrap.wrap();
        return "BoxWrap";
    }
}

class NonVegBurger implements Burger{

    @Override
    public String getType() {
        return "This is NonVeg Burger";
    }

    @Override
    public String name() {
        System.out.println("This is Chicken Masala");
        return "Chicken Masala";
    }

    @Override
    public int price() {
        System.out.println("Price is : Rs"+ 145);
        return 145;
    }

    @Override
    public String packing() {
        BoxWrap wrap = new BoxWrap();
        wrap.wrap();
        return "BoxWrap";
    }
}

class Meal{
    List<FoodItems> al = new ArrayList<>();
    public void addItems(FoodItems f){
        al.add(f);
    }

    public void showItems(){
        al.stream().forEach(i -> {
            System.out.println(i.name());
            System.out.println(i.price());
            System.out.println(i.packing());
        });
    }
}

class MealBuilder{
    public Meal createVegBurger(){
        Meal m = new Meal();
        Burger burger = new VegBurger();
        burger.getType();
        burger.name();
        burger.price();
        m.addItems(burger);
        return m;
    }

    public Meal createNonVegBurger(){
        Meal nm = new Meal();
        Burger burger = new NonVegBurger();
        burger.getType();
        burger.name();
        burger.price();
        nm.addItems(burger);
        return nm;
    }
}
public class BuilderPatternExample {
    public static void main(String[] args) {
        MealBuilder mb = new MealBuilder();
        Meal nonVegMeal = mb.createNonVegBurger();
        nonVegMeal.showItems();
        Meal vegMeal = mb.createVegBurger();
        vegMeal.showItems();
    }
}
