package utils;

import engine.combat.Entity;

public class Logger {

    public static void physicalAttack(Entity attacker, Entity target, int damage) {
        String string = String.format("%s%s %sattacked %s%s %sand dealt %s%d %sdamage.",
                ConsoleColors.GREEN, attacker.getName(),
                ConsoleColors.WHITE,
                ConsoleColors.GREEN, target.getName(),
                ConsoleColors.WHITE,
                ConsoleColors.RED, damage,
                ConsoleColors.WHITE);

        System.out.println(string);
    }

    public static void physicalAttackCrit(Entity attacker, Entity target, int damage) {
        String string = String.format("%s%s %slanded a %scritical %sblow on %s%s %sand dealt %s%d %sdamage.",
                ConsoleColors.GREEN, attacker.getName(),
                ConsoleColors.WHITE,
                ConsoleColors.CYAN_BOLD_BRIGHT,
                ConsoleColors.WHITE,
                ConsoleColors.GREEN, target.getName(),
                ConsoleColors.WHITE,
                ConsoleColors.CYAN_BOLD_BRIGHT, damage,
                ConsoleColors.WHITE);
        System.out.println(string);
    }

    public static void physicalAttackMiss(Entity attacker, Entity target) {
        String string = String.format("%s%s %stried to attack %s%s %sand missed.",
                ConsoleColors.GREEN, attacker.getName(),
                ConsoleColors.WHITE,
                ConsoleColors.GREEN, target.getName(),
                ConsoleColors.WHITE);
        System.out.println(string);
    }
}
