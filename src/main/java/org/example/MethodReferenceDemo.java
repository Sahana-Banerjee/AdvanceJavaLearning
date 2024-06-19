package org.example;

public class MethodReferenceDemo {
    public static void main(String[] args) {
        // Here instead of writing a lambda I am reusing exisiting code 'demoMethod' to define the
        // abstract method of the funcitonal interface. 'demoMethod' is a static method
        //defined in class FunctionalInterfaceImpl.
        FunctionalInterfaceEx demo = FunctionalInterfaceImpl::demoMethod;
        demo.demoAbsMethod();
    }
}
