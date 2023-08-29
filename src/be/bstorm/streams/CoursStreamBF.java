package be.bstorm.streams;

import be.bstorm.utils.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class CoursStreamBF {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

//        System.out.println(list.stream()
//                .filter(x -> x % 2 != 0)
//                .map(x -> (double) x * x)
//                .reduce(Double::sum)
//                .get()
//        );

        List<String> list2 = List.of("Bonjour", "Comment", "allez", "vous", "?");
        List<String> listApresTransformation = list2.stream()
                .map(s -> {
                    System.out.println(s);
                    return s.trim();
                }) // String::trim
                .filter(s -> s.length() >= 5)

                .map(s -> s.toUpperCase()) // String::toUpperCase
                .toList();

        System.out.println(listApresTransformation);

        System.out.println(String.join(",", list2));

        List<Float> doubles = List.of(1.0F, 2.0F, 3.0F);
        DoubleStream doubleStream = DoubleStream.of(1D, 2D);


    }

}
