package engine.combat;

import utils.ConsoleColors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Encounter {
    private final Party playerParty = new Party();
    private final Party enemyParty = new Party();
    private int turnCount = 0;

    public void addPlayer(EntityPlayer player) {
        this.playerParty.partyMembers.add(player);
    }

    public void addEnemy(EntityEnemy enemy) {
        this.enemyParty.partyMembers.add(enemy);
    }

    public List<Entity> getAlivePlayers() {
        return playerParty.getAliveEntities();
    }

    public List<Entity> getAliveEnemies() {
        return enemyParty.getAliveEntities();
    }

    public boolean encounterEnded() {
        if (getAlivePlayers().isEmpty()) {
            System.out.println("Player party was defeated in " + turnCount + " turns.");
            return true;
        }
        if (getAliveEnemies().isEmpty()) {
            System.out.println("Enemy party was defeated in " + turnCount + " turns.");
            return true;
        }
        return false;
    }

    public void nextTurn() {
        turnCount++;
        ArrayList<Entity> turnOrder = new ArrayList<>();
        turnOrder.addAll(getAlivePlayers());
        turnOrder.addAll(getAliveEnemies());
        turnOrder.sort(Entity.SpeedComparator);

        Scanner scanner = new Scanner(System.in);
        while (!turnOrder.isEmpty()) {
            Entity entity = turnOrder.remove(0);
            if (!entity.getEntityStats().isDead()) {
                if (entity instanceof EntityEnemy) {
                    Battle.physicalAttack(entity, playerParty, true);
                } else {
                    System.out.println(entity.getName() + " is awaiting instruction...");
                    String input = scanner.nextLine();
                    if (input.equals("attack")) {
                        Battle.physicalAttack(entity, enemyParty, true);
                    } else {
                        System.out.println(entity.getName() + " did nothing...");
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        String output = String.format("%sPlayer Party:\n%s|", ConsoleColors.BLUE, ConsoleColors.WHITE);
        EntityStats stats;
        for (Entity e : playerParty.partyMembers) {
            stats = e.getEntityStats();
            output = output.concat(String.format(" %s%s %sHP: %d/%d %s|", ConsoleColors.GREEN, e.getName(),
                    ConsoleColors.RED, stats.getCurrent_hp(), stats.getMax_hp(), ConsoleColors.WHITE));
        }
        output = output.concat(String.format("\n%sEnemy Party:\n%s|", ConsoleColors.YELLOW, ConsoleColors.WHITE));
        for (Entity e : enemyParty.partyMembers) {
            stats = e.getEntityStats();
            output = output.concat(String.format(" %s%s %sHP: %d/%d %s|", ConsoleColors.GREEN, e.getName(),
                    ConsoleColors.RED, stats.getCurrent_hp(), stats.getMax_hp(), ConsoleColors.WHITE));
        }

        return output;
    }
}



