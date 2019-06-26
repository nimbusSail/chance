package com.lyf.chance;

public class Chance {
    private double probability;

    public Chance(double probability) {
        this.probability = probability;
    }

    public double getProbability() {
        return probability;
    }

    public Chance not() {
        return new Chance(1 - this.probability);
    }

    public Chance and(Chance anotherChance) {
        return new Chance(this.probability * anotherChance.probability);
    }

    public Chance or(Chance anotherChance) {
        return new Chance(this.probability + anotherChance.getProbability()
                - (this.probability * anotherChance.probability));
    }
}
