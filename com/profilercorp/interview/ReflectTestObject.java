package com.profilercorp.interview;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.lang.System.out;

/**
 * Created by albertgao on 1/08/16.
 * This is for task a.
 */
public class ReflectTestObject {
    private Class testObjectClass;

    // This is an instance initialized by the reflection.
    // For task c, but we will hold the instance.
    private TestObject newInstance;

    public ReflectTestObject() {
        this.testObjectClass = TestObject.class;
        this.newInstance = null;
    }

    // For task b
    public void describeFields(){
        Field[] fields = this.testObjectClass.getDeclaredFields();
        out.println("[b] The private fields and type:");
        out.println();
        for(int i=0; i<fields.length; i++){
            out.print((i+1)+" FIELD : "+fields[i].getName());
            out.println();
            out.println("  TYPE  : "+fields[i].getGenericType().getTypeName());
            out.println();
        }
    }

    // For task b
    public void describeConstructor() {
        Constructor[] constructors = this.testObjectClass.getConstructors();
        for (Constructor c : constructors) {
            this.printDivider();
            out.println("[b] The Constructor and its parameters:");
            out.println();
            out.println(c.toGenericString());
            this.printDivider();
        }
    }

    // For task b.
    public void describeMethods(){
        Method[] methods = this.testObjectClass.getDeclaredMethods();
        out.println("[b] The public methods and return type:");
        out.println();
        for (int i=0; i<methods.length; i++){
            out.print((i+1)+" METHOD : "+methods[i].getName());
            out.println();
            out.println("  RETURN : "+methods[i].getReturnType().toString());
            out.println();
        }
        this.printDivider();
    }

    // For task c
    public void createInstance() {
        Constructor[] constructors = TestObject.class.getDeclaredConstructors();
        Constructor constructor = constructors[0];
        TestObject testMe = null;
        try {
            testMe = (TestObject) constructor.newInstance("Albert");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        this.newInstance = testMe;
        out.println("[c] Create New Instance via reflection: DONE!");
        this.printDivider();
    }

    // For task d.
    public void printFieldValue(){
        Field[] fields = this.newInstance.getClass().getDeclaredFields();
        out.println("[d] The value of private fields:");
        out.println();
        for(int i=0; i<fields.length; i++){
            Field field = fields[i];
            field.setAccessible(true);
            out.println((i+1)+" FIELD : "+field.getName());
            String value = "YES";
            try {
                value = field.get(this.newInstance).toString();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            out.println("  VALUE : "+ value);
            out.println();
        }
        this.printDivider();
    }

    // For task e
    public void callMethods(){
        Method[] methods = this.newInstance.getClass().getDeclaredMethods();
        out.println("[e] Invoke all the methods:");
        out.println();
        for (int i=0; i<methods.length; i++){
            try {
                methods[i].setAccessible(true);
                out.println((i+1)+" METHOD : "+methods[i].getName());
                Object value = methods[i].invoke(this.newInstance);
                if (methods[i].getName().contains("getModificationTime")){
                    out.println("  RETURN : "+(long)value);
                }else{
                    out.println("  RETURN : "+value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            out.println();
        }
        this.printDivider();
    }

    // For task f
    public void changeValueOfaField(){
        try {
            Field requiredField = this.testObjectClass.getDeclaredField("__cantmodify");
            requiredField.setAccessible(true);
            requiredField.set(this.newInstance,"NOT SAFE");
            out.println("[f] __cantmodify CHANGED TO: "+requiredField.get(this.newInstance));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e){
            e.printStackTrace();
        }
        this.printDivider();
    }

    public void printDivider(){
        for (int i=0; i<38; i++){
            out.print("=");
        }
        out.println();
    }
}
