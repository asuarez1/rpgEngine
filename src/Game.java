import engine.combat.*;
import engine.combat.enums.BuffTrigger;
import engine.combat.enums.BuffType;

// TODO:
// AUTO GENERATE ENCOUNTERS
// ADD SPELLS
// ADD BUFFS
// ADD ABILITIES
public class Game {
    public static void main(String[] args) {

        Encounter encounter = new Encounter();
        EntityStats playerStats = new EntityStats(40, 40, 10, 10, 10, 3,
                5, 3, 3, 5, 5);
        EntityStats enemyStats = new EntityStats(10, 10, 5, 5, 6, 0,
                3, 2, 3, 3, 1);
        EntityStats enemyStats2 = new EntityStats(10, 10, 5, 5, 6, 0,
                3, 2, 3, 4, 7);
        EntityStats enemyStats3 = new EntityStats(10, 10, 5, 5, 6, 0,
                3, 2, 3, 1, 5);
        EntityPlayer player = new EntityPlayer(playerStats, "Alex");
        EntityEnemy ratA = new EntityEnemy(enemyStats, "Rat A");
        EntityEnemy ratB = new EntityEnemy(enemyStats2, "Rat B");
        EntityEnemy ratC = new EntityEnemy(enemyStats3, "Rat C");
        encounter.addPlayer(player);
        encounter.addEnemy(ratA);
        encounter.addEnemy(ratB);
        encounter.addEnemy(ratC);
        player.getEntityStats().buffs.add(new Buff("Vitality", BuffType.FLAT, BuffTrigger.MAX_HP, 10, 10));
        player.getEntityStats().buffs.add(new Buff("Frenzy", BuffType.PERCENTAGE, BuffTrigger.DAMAGE, 2, 10));
        do {
            System.out.println(encounter);
            encounter.nextTurn();
        } while (!encounter.encounterEnded());
    }
}
