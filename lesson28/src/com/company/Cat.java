package com.company;

import java.util.LinkedList;

public class Cat {
    private String name;
    private int age;
    private LinkedList <String> vaccination = new LinkedList<>();

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", vaccination=" + vaccination +
                '}';
    }
// альтернатива get set, создать builder(опишем отдельным классом в классе Cat)

    public static class Builder {
        private Cat cat = new Cat();
        // промежуточные (intermediate)
        // методы должны:
        // 1. возвращать сылку на текущий объект Builder-a
        // 2. не должны прерывать процесс построения объекта

        //здесь вся функциональность setterov

        public Builder setName(String name) {
            cat.name = name;
            return this;

        }
        public Builder setAge(int age) {
            cat.age = age;
            return this;

        }

        public Builder addVaccination(String v){
            cat.vaccination.add(v);
            return this;
        }

        //  конечный(terminated) метод должен завершать процесс построения
        // и возвращать итоговый объект

        public Cat build(){
            return this.cat;
        }
    }
}
