package ru.unlimit.javapro.patterns;

public class HDD {
    void copyFromDVD(DVDRom dvd){
        if(dvd.hasData()){
            System.out.println("Происходит копирование данных с диска");
        }
        else{
            System.out.println("Вставьте диск с данными");
        }
    }
}
