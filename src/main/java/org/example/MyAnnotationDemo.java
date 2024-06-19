package org.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME) //Reflection policy RUNTIME ensures annotation values processed in Runtime.
@Target(ElementType.METHOD)
@interface MyAnnotation {
    String value() default "Sahana";
    int id() default 1;
}

class AnnotationEx{

    @MyAnnotation(value = "Shreeja", id =2)
    public String myMethod(){
        return "Hello";
    }

    @MyAnnotation
    public String myMethod1(){
        return "Hello";
    }

    public void print(String msg, String name, int id){
        System.out.println(msg +" "+ name +": "+ id);
    }
}

class AnnotationProcessorEx{
    public static void main(String[] args) throws NoSuchMethodException {
        Class<AnnotationEx> ex = AnnotationEx.class;
        Method myMethod = ex.getMethod("myMethod");
        Method myMethod1 = ex.getMethod("myMethod1");
        MyAnnotation reflectAnnotation = myMethod.getAnnotation(MyAnnotation.class);
        MyAnnotation reflectAnnotation1 = myMethod1.getAnnotation(MyAnnotation.class);

        //using the annotation values in conjunction to create a meaningful msg
        AnnotationEx ex1 = new AnnotationEx();
        ex1.print(ex1.myMethod(), reflectAnnotation.value(), reflectAnnotation.id());//custom values passed in annotation
        ex1.print(ex1.myMethod1(), reflectAnnotation1.value(), reflectAnnotation1.id());//default values of annotation
    }
}