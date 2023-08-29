package be.bstorm.streams;

import be.bstorm.utils.Util;
import be.bstorm.utils.models.Moto;
import be.bstorm.utils.models.PeutRouler;
import be.bstorm.utils.models.Voiture;

import java.util.*;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.*;

public class PlayWithStreams {

    public static void main(String[] args) {
//        Util.Streams.listeVehicules()
//                .filter(v -> v instanceof Moto)
//                .forEach(v -> {
//                    if (v instanceof PeutRouler) {
//                        ((PeutRouler) v).seDeplacer(v);
//                    }
//                });

//        System.out.println(Stream.generate(Util::randomVehicule)
//                .limit(100)
//                .filter(v -> v instanceof Moto)
//                .peek(System.out::println)
//                .count());

//        System.out.println(Stream.iterate(1, x -> x + 1)
//                .limit(100)
//                .filter(x -> x % 2 == 0)
//                .map(x -> Math.pow(x, 2))
//                .reduce(Double::sum));

        IntStream.range(1, 10).forEach(System.out::println);

        Random random = new Random();
        DoubleStream doubleStream = random.doubles(5, 10D, 20D);
        doubleStream.forEach(System.out::println);

        "abcd".chars()
                .forEach(c -> {
                    System.out.println((char)c);
                });

        Stream<String> stringStream = Pattern.compile(", ").splitAsStream("a, b, c, d, e");

        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        Optional<String> stream = list.stream().filter(element -> {
            Logger.getLogger("log").info("filter() was called");
            return element.contains("2");
        }).map(element -> {
            Logger.getLogger("log").info("map() was called");
            return element.toUpperCase();
        }).findFirst();
        System.out.println(stream);
    }
}
