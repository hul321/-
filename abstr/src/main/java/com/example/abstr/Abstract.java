package com.example.abstr;

import java.security.Key;

public class Abstract {
    public static void main(String[]args){

        DeviceFactory factory = getfactoryByCountryCode("RU");
        Mouse       m = factory.getMouse();
        Keyboard    k = factory.getKeyboard();
        Touchpad    t = factory.getTouchpad();

        m.click();
        k.print();
        k.println();
        t.track(10, 35);

    }
    private static DeviceFactory getfactoryByCountryCode(String lang){
        switch (lang){
            case "RU":
                return new RuDeviceFactory();
            case "EN":
                return new EnDeviceFactory();
            default:
                throw new RuntimeException("Unsupported Country Code: " + lang);
        }
    }
}
interface Mouse{
    void click();
    void dblclick();
    void scroll(int direction);
}
interface Keyboard{
    void print();
    void println();
}
interface Touchpad{
    void track(int deltaX, int deltaY);
}
interface DeviceFactory{
    Mouse getMouse();
    Keyboard getKeyboard();
    Touchpad getTouchpad();
}
class RuMouse implements Mouse{
    @Override
    public void click() {System.out.println("Щелчок мышью");}

    @Override
    public void dblclick() {System.out.println("Двойной щелчок мышью");}



    @Override
    public void scroll(int direction) {
        if (direction>0)
            System.out.println("Скроллим вверх");
        else if(direction<0)
            System.out.println("Скроллим вниз");
        else
            System.out.println("Не скроллим");
    }

}
class RuKeyboard implements Keyboard{
    public void print() {System.out.print("Печатаем строку");}
    public void println() {System.out.println("Печатаем строку с переводом строки");}
}
class RuTouchpad implements Touchpad{
    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX, 2)+Math.pow(deltaY, 2));
        System.out.println("Передвинулись на " + s + " пикселей ");
    }
}
class EnMouse implements Mouse{
    @Override
    public void click() {System.out.println("Mouse click");}

    @Override
    public void dblclick() {System.out.println("Mouse double click");}



    @Override
    public void scroll(int direction) {
        if (direction>0)
            System.out.println("Scroll Up");
        else if(direction<0)
            System.out.println("Scroll Down");
        else
            System.out.println("No scrolling");
    }

}
class EnKeyboard implements Keyboard{
    public void print() {System.out.print("Print");}
    public void println() {System.out.println("Print Line");}
}
class EnTouchpad implements Touchpad{
    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX, 2)+Math.pow(deltaY, 2));
        System.out.println("Moved " + s + " pixels ");
    }
}
class EnDeviceFactory implements DeviceFactory{
    public Mouse getMouse() {
        return new EnMouse();
    }
    public Keyboard getKeyboard() {
        return new EnKeyboard();
    }
    public Touchpad getTouchpad() {
        return new EnTouchpad();
    }
}
class RuDeviceFactory implements DeviceFactory{
    public Mouse getMouse() {
        return new RuMouse();
    }
    public Keyboard getKeyboard() {
        return new RuKeyboard();
    }
    public Touchpad getTouchpad() {
        return new RuTouchpad();
    }
}