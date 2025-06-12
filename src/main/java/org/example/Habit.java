package org.example;

public class Habit {
    private String name;
    private boolean completedToday;
    private String category;

    // Constructor
    public Habit(String name, boolean completedToday, String category) {
        this.name = name;
        this.completedToday = completedToday;
        this.category = category;
    }

    // Getters
    public String getName() {
        return name;
    }

    public boolean isCompletedToday() {
        return completedToday;
    }

    public String getCategory() {
        return category;
    }

    // toString to show legible info
    @Override
    public String toString() {
        return "Habit{name='" + name + "', completedToday=" + completedToday + ", category='" + category + "'}";
    }
}
