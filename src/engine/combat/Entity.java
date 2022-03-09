package engine.combat;

import java.util.Comparator;

public abstract class Entity {

    // VARIABLES

    private final EntityStats entityStats;
    private final String name;

    // CONSTRUCTORS

    public Entity(EntityStats entityStats, String name) {
        this.entityStats = entityStats;
        this.name = name;
    }

    // GETTERS AND SETTERS

    public EntityStats getEntityStats() {
        return this.entityStats;
    }

    public String getName() {
        return this.name;
    }

    // METHODS
    // TAKE DAMAGE

    public void takePhysicalDamage(int damage) {
        int new_health = Math.max(0, entityStats.getCurrent_hp() - damage);
        entityStats.setCurrent_hp(new_health);
        if (entityStats.isDead()) {
            System.out.println(name + " was defeated.");
        }
    }

    // MISC

    public static Comparator<Entity> SpeedComparator = (e1, e2)
            -> e2.getEntityStats().getSpeed() - e1.getEntityStats().getSpeed();
}
