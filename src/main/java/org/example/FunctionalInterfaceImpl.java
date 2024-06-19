package org.example;

public class FunctionalInterfaceImpl {
    public static void main(String[] args) {
        FunctionalInterfaceEx demo = () -> System.out.println("Functional interface using lambda");
        demo.demoAbsMethod();
    }

    public static void demoMethod(){
        System.out.println("Method reference example using FI ");
    }
}
