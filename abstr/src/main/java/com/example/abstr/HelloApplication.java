package com.example.abstr;



public class HelloApplication {
    public interface CarsFactory {
        Sedan createSedan();
        Coupe createCoupe();
    }

    public class ToyotaFactory implements CarsFactory {
        public Sedan createSedan() {
            return new ToyotaSedan();
        }

        public Coupe createCoupe() {
            return new ToyotaCoupe();
        }
    }
    public class FordFactory implements CarsFactory {
        @Override
        public Sedan createSedan() {
            return new  FordSedan();
        }

        @Override
        public Coupe createCoupe() {
            return new FordCoupe();
        }
        }

}