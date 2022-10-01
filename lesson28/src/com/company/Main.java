package com.company;


import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {


        // Stream API
        // builder: builder

        Cat cat = new Cat.Builder() //Cat.Builder builder = new Cat.Builder();
                .setAge(12)
                .setAge(24)
                .setName("Tom")
                .addVaccination("v1")
                .addVaccination("v2")
                .addVaccination("v3")  //builder.addVaccination("v3")

                .build();//Cat cat = builder.build();
        System.out.println(cat);

        // Stream API => 8.0
        // упростить работу с потоками данных
        // Объект класса Stream можно создать:
        // - на основе массива
        // - либо на основе коллекции

        //Все интерфейсы в JAVA можно заменить на lambda!!!!

        // Stream на основе массива

        IntStream sInt = Arrays.stream(new int[]{1, 2, 3, 4});
        System.out.println(sInt);

        Stream s = Stream.of("text", "text1", "text2");
        System.out.println(s);

        // Stream на основе коллекции
        // только если имплементирует Collection

        ArrayList<Double> list = new ArrayList<>();
        list.add(12.02);
        list.add(3.1415);
        list.add(-8.8);

        Stream<Double> stream = list.stream();//на основе данных лежащих в коллекции
        stream
                .filter((Double e) -> e > 0) //отсеять часть эл-ов поо какому-то принципу true-элемент останется
                .sorted((o1, o2) -> (int) (o1 - o2))
                .forEach(System.out::println); //должны отсеятся отрицательные и сортировка по возврастанию

        //stream никак не влияет на коллекцию

        System.out.println(list);

//        stream
//                .filter((e) -> e > 10)
//                .forEach(System.out::println);

        LinkedList<Double> filteredList = new LinkedList<>();
        list.stream()
                .filter((e) -> e > 0)
                .forEach(filteredList::add);
        System.out.println(filteredList);

       Double d =  list.stream()
                .filter((e) -> e > 0).findFirst()
                .get();
        System.out.println(d);

        boolean f =list.stream()
                .filter((e) -> e > 0)
                .allMatch((e) -> e < 12);//все, соответствующие условию
        System.out.println(f);


        boolean f =list.stream()
                .filter((e) -> e > 0)
                .anyMatch((e) -> e < 12);//хотя бы один
        System.out.println(f);


        Double g = list.stream()
                .max((a,b) -> (int)(a - b))
                .get();
        System.out.println(g);

        // reduce
        // 1,3,5,7
        // первая перегрузка reduce
        // 1. (1, 3) -> 1 + 3
        // 2. (4, 5) -> 4 + 5
        // 3. (9, 7) -> 9 +  ======>16


//        Optional<Double> result = list.stream()
//                .reduce((p ,c) -> p + c);
//        if(resuit.isPresent()){
//            System.out.println(result.get());
//        }

        System.out.println(list.stream()
        .reduce(100.0,(p,c) -> p + c));

        list.parallelStream().forEach(System.out::println);





    }

}
