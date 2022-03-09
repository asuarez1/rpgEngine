package engine.combat;

import utils.Logger;

import java.util.List;
import java.util.Random;

public class Battle {
    private static final Random rand = new Random();

    public static void physicalAttack(Entity attacker, Entity target) {
        if(isHit(attacker, target)) {
            int damage = Math.max(1, attacker.getEntityStats().getAttackDamage() - target.getEntityStats().getDefense());
            if (isCrit(attacker, target)) {
                damage *= attacker.getEntityStats().getCritModifier();
                Logger.physicalAttackCrit(attacker, target, damage);
            } else {
                Logger.physicalAttack(attacker, target, damage);
            }

            target.takePhysicalDamage(damage);
        } else {
            Logger.physicalAttackMiss(attacker, target);
        }
    }

    public static void physicalAttack(Entity attacker, Party targetParty, boolean random) {
        List<Entity> aliveEntities = targetParty.getAliveEntities();
        if(random) {
            Entity target = aliveEntities.get(rand.nextInt(aliveEntities.size()));
            physicalAttack(attacker, target);
        } else {
            for(Entity target : aliveEntities){
                physicalAttack(attacker, target);
            }
        }
    }

    private static boolean isCrit(Entity attacker, Entity target){
        int critChance = Math.max(0, (attacker.getEntityStats().getCrit() - target.getEntityStats().getCritAvoid()));
        //System.out.printf("DEBUG: %s's crit chance is %d%n", attacker.getName(), critChance);
        return critChance >= rand.nextInt(100);
    }

    private static boolean isHit(Entity attacker, Entity target){
        int hitChance = attacker.getEntityStats().getPhysicalHit() - target.getEntityStats().getPhysicalAvoid();
        //System.out.printf("DEBUG: %s's hit chance is %d%n", attacker.getName(), hitChance);
        return hitChance >= rand.nextInt(100);
    }
}
