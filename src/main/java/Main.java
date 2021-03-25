package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class Main {

    public static void main(final String[] args) {
        // write your code here
        final ArrayList<Boy> boys = new ArrayList<>() {{
            add(new Boy("Николай", 68));
            add(new Boy("Пётр", 53));
            add(new Boy("Василий", 25));
            add(new Boy("Михаил", 19));
            add(new Boy("Алексей", 6));
            add(new Boy("Николай", 86));
            add(new Boy("Пётр", 35));
            add(new Boy("Михаил", 111));
            add(new Boy("Алексей", 22));
            add(new Boy("Михаил", 1));
            add(new Boy("Яков", 30));
        }};

        Map<String, Integer> result = new HashMap<>();

        //фильтруем и сохраняем результат в мапу с ключами-именами (п.1, 2, 3)
        boys.stream().filter(boy -> boy.getAge() >= 18).map(boy -> boy.getName()).
                distinct().sorted().limit(4).collect(Collectors.toList()).
                forEach(s -> result.put(s, -1));

        //апдейтим значение по ключам-именам (п.3)
        boys.stream().forEach(boy -> {
            if (result.containsKey(boy.getName())) {
                result.put(boy.getName(), result.get(boy.getName()) + 1);
            }
        });

        //выводим в консоль(п.4)
        System.out.println(result);

    }
}

