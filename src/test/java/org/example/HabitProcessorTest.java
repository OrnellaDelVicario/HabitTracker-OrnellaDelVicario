package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

class HabitProcessorTest {

    @Test
    void filterHabits_shouldReturnOnlyIncompleteHabits() {
        List<Habit> habits = Arrays.asList(
                new Habit("Drink Water", false, "Health"),
                new Habit("Read Book", true, "Growth")
        );

        Predicate<Habit> incomplete = habit -> !habit.isCompletedToday();
        HabitProcessor processor = new HabitProcessor();
        List<Habit> result = processor.filterHabits(habits, incomplete);

        assertEquals(1, result.size());
        assertEquals("Drink Water", result.get(0).getName());
    }

    @Test
    void mapHabits_shouldReturnListOfNames() {
        List<Habit> habits = Arrays.asList(
                new Habit("Exercise", false, "Health"),
                new Habit("Meditate", false, "Mindfulness")
        );

        Function<Habit, String> getName = Habit::getName;
        HabitProcessor processor = new HabitProcessor();
        List<String> names = processor.mapHabits(habits, getName);

        assertEquals(Arrays.asList("Exercise", "Meditate"), names);
    }

    @Test
    void processHabits_shouldApplyConsumerAction() {
        List<Habit> habits = Arrays.asList(
                new Habit("Journal", false, "Productivity"),
                new Habit("Walk", false, "Health")
        );

        StringBuilder log = new StringBuilder();
        Consumer<Habit> logger = habit -> log.append("Don't forget: ").append(habit).append("\n");

        HabitProcessor processor = new HabitProcessor();
        processor.processHabits(habits, logger);

        String output = log.toString();
        assertTrue(output.contains("Don't forget: Habit{name='Journal', completedToday=false, category='Productivity'}"));
        assertTrue(output.contains("Don't forget: Habit{name='Walk', completedToday=false, category='Health'}"));
    }
}
