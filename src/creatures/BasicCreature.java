package creatures;

import java.util.Random;

public class BasicCreature implements Creature {
    private String name = "BasicCreature";
    private double deathrate = 0.2;
    private double reproductionRate = 0.3;

    private double x, y;

    public BasicCreature(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean dies() {
        return new Random().nextDouble() < deathrate;
    }

    @Override
    public boolean reproduces() {
        return new Random().nextDouble() < reproductionRate;
    }

    @Override
    public String toString() {
        return "BasicCreature{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
