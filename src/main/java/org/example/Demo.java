package org.example;

import java.util.Arrays;
import java.util.List;

public class Demo
{
    public static void main( String[] args ) {
        //1. List of habits
        List<Habit> habits = Arrays.asList(
                new Habit("Drink Water", false, "Health"),
                new Habit("Read a Book", false, "Growth"),
                new Habit("Exercise", true, "Health"),
                new Habit("Write Journal", true, "Productivity")
        );

        HabitProcessor processor = new HabitProcessor();

        // 2. Filter to habits not completed today
        List<Habit> incompleteHabits = processor.filterHabits(habits, habit -> !habit.isCompletedToday());

        // 3. Process habits: print a message
        processor.processHabits(incompleteHabits, habit -> System.out.println("Don't forget: " + habit));

        // 4. Map to names
        List<String> habitNames = processor.mapHabits(incompleteHabits, Habit::getName);

        // 5. Print list of habit names
        System.out.println("Habit Names: " + habitNames);
    }
}
