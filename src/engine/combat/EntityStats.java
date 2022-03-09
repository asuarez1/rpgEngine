package engine.combat;

import engine.combat.enums.BuffTrigger;
import engine.combat.enums.BuffType;

import java.util.ArrayList;
import java.util.List;

public class EntityStats {
    private int current_hp;
    private int max_hp;
    private int current_mp;
    private int max_mp;
    private int strength;
    private int magic;
    private int dexterity;
    private int defense;
    private int resistance;
    private int speed;
    private int luck;
    public final List<Buff> buffs = new ArrayList<>();


    public EntityStats(int current_hp, int max_hp, int current_mp, int max_mp, int strength, int magic, int dexterity, int defense, int resistance, int speed, int luck) {
        this.current_hp = current_hp;
        this.max_hp = max_hp;
        this.current_mp = current_mp;
        this.max_mp = max_mp;
        this.strength = strength;
        this.magic = magic;
        this.dexterity = dexterity;
        this.defense = defense;
        this.resistance = resistance;
        this.speed = speed;
        this.luck = luck;
    }


    public int getCurrent_hp() {
        return current_hp;
    }

    public void setCurrent_hp(int current_hp) {
        this.current_hp = current_hp;
    }

    public int getMax_hp() {


        return foo(BuffTrigger.MAX_HP, max_hp);
    }

    public void setMax_hp(int max_hp) {
        this.max_hp = max_hp;
    }

    public int getCurrent_mp() {
        return current_mp;
    }

    public void setCurrent_mp(int current_mp) {
        this.current_mp = current_mp;
    }

    public int getMax_mp() {
        return foo(BuffTrigger.MAX_MP, max_mp);
    }

    public void setMax_mp(int max_mp) {
        this.max_mp = max_mp;
    }

    public int getStrength() {
        return foo(BuffTrigger.STRENGTH, strength);
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getMagic() {
        return foo(BuffTrigger.MAGIC, magic);
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getDexterity() {
        return foo(BuffTrigger.DEXTERITY, dexterity);
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getDefense() {
        return foo(BuffTrigger.DEFENSE, defense);
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getResistance() {
        return foo(BuffTrigger.RESISTANCE, resistance);
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public int getSpeed() {
        return foo(BuffTrigger.SPEED, speed);
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getLuck() {
        return foo(BuffTrigger.LUCK, luck);
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public boolean isDead() {
        return current_hp == 0;
    }

    public int getAttackDamage() {
        return foo(BuffTrigger.DAMAGE, getStrength());
    }

    public int getPhysicalHit() {
        return foo(BuffTrigger.HIT, getDexterity() + 90);
    }

    public int getPhysicalAvoid() {
        return foo(BuffTrigger.AVOID, getSpeed());
    }

    public int getCrit() {
        return foo(BuffTrigger.CRIT, (getDexterity() + getLuck()) / 2);
    }

    public int getCritAvoid() {
        return foo(BuffTrigger.CRIT_AVOID, getLuck());
    }

    public int getCritModifier() {
        return foo(BuffTrigger.CRIT_MODIFIER, 3);
    }

    private int foo(BuffTrigger trigger, int value) {
        List<Buff> var = bar(trigger);
        double newValue = value;
        for (Buff buff : var) {
            if (buff.getType() == BuffType.FLAT) newValue += buff.getValue();
        }
        for (Buff buff : var) {
            if (buff.getType() == BuffType.PERCENTAGE) newValue *= buff.getValue();
        }
        return (int) Math.round(newValue);
    }

    private List<Buff> bar(BuffTrigger trigger) {
        List<Buff> var = new ArrayList<>();
        for (Buff buff : buffs) {
            if (buff.getTrigger() == trigger) var.add(buff);
        }
        return var;
    }
}
