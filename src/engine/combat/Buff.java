package engine.combat;

    /*
    Buff is blanket term for something that modifies stats or derived stats in anyway, includes de-buff

    Buff parameters:
    name
    mod value -> two type flat and percentage, can be negative
    mod type -> distinguish if mod value is flat or percentage
    stat trigger -> what does the buff affect e.g. strength, int, get damage, crit chance, avoid
    turns -> how many turns buff will last for (if set to -1 will be infinite)

    might need 2 types of buff - one just effect stats and one to cast spells on events
    e.g. on deal damage restore 10% as hp
    how do i do ?????
     */

import engine.combat.enums.BuffTrigger;
import engine.combat.enums.BuffType;

public class Buff {
    private String name;
    private BuffType type;
    private BuffTrigger trigger;
    private double value;
    private int turns;

    public Buff(String name, BuffType type, BuffTrigger trigger, int value, int turns) {
        this.name = name;
        this.type = type;
        this.trigger = trigger;
        this.value = value;
        this.turns = turns;
    }

    public String getName() {
        return name;
    }

    public BuffType getType() {
        return type;
    }

    public BuffTrigger getTrigger() {
        return trigger;
    }

    public double getValue() {
        return value;
    }

    public int getTurns() {
        return turns;
    }
}

