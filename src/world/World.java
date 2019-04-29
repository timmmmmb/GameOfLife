package world;

import creatures.BasicCreature;
import creatures.Creature;

import java.util.ArrayList;

public class World {
    private int day = 1;
    private double width, height;
    private int removed = 0;
    private int reproduced = 0;
    private ArrayList<Creature> creatures = new ArrayList<>();

    public World(double width, double height) {
        this.width = width;
        this.height = height;
        initializeWorld();
        Stats();
        resetStats();
    }

    private void initializeWorld() {
        for (int i = 0; i < 10; i++) {
            addCreature();
        }
    }

    private void addCreature() {
        creatures.add(new BasicCreature(10, 10));
        reproduced++;
    }

    private void kill(Creature creature) {
        creatures.remove(creature);
        removed++;
    }

    public void nextDay() {
        day++;
        @SuppressWarnings("unchecked")
        ArrayList<Creature> clone = (ArrayList<Creature>) creatures.clone();
        for (Creature creature : clone) {
            if (creature.dies()) {
                kill(creature);
                continue;
            }
            if (creature.reproduces()) {
                addCreature();
            }
        }
        Stats();
        resetStats();
    }

    private void resetStats(){
        reproduced = 0;
        removed = 0;
    }

    private void Stats(){
        System.out.println("Day: " + day);
        System.out.println("Current amount of creatures: " + creatures.size());
        System.out.println("Reproduced creatures: " + reproduced);
        System.out.println("Died creatures: " + removed);
    }
}
