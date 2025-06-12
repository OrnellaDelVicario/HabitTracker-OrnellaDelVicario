package org.example;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class HabitProcessor {
    List<Habit> filterHabits(List<Habit> habits, Predicate<Habit> condition){
        return
                habits.stream() //convert list in a stream
                        .filter(condition) //Apply filter using condition
                        .collect(Collectors.toList()); //collect results in a new list
    }


    public List<String> mapHabits(List<Habit> habits, Function<Habit, String> mapper) {
        return habits.stream()                   // convert list intro stream
                .map(mapper)                     // transform each habit using condition
                .collect(Collectors.toList());   // collect results in a list
    }

    public void processHabits(List<Habit> habits, Consumer<Habit> action) {
        habits.forEach(action); // para cada hábito, aplica la acción dada
    }

}
