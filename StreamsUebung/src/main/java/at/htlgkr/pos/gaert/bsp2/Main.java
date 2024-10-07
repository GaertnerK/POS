package at.htlgkr.pos.gaert.bsp2;

import at.htlgkr.pos.gaert.bsp2.CombatType;
import at.htlgkr.pos.gaert.bsp2.DamageType;
import at.htlgkr.pos.gaert.bsp2.Weapon;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] randomNumbers = new int[10000];
        Random rand = new Random();
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = rand.nextInt(100) + 1;
        }

        String[] randomStrings = new String[10];
        for (int i = 0; i < randomStrings.length; i++) {
            randomStrings[i] = "a";
        }

        List<Weapon> weaponList = new ArrayList<>();
        weaponList = Files.lines(new File("weapons.csv").toPath())
                .skip(1)
                .map(s -> s.split(";"))
                .map(s -> new Weapon(
                        s[0],
                        CombatType.valueOf(s[1]),
                        DamageType.valueOf(s[2]),
                        Integer.parseInt(s[3]),
                        Integer.parseInt(s[4]),
                        Integer.parseInt(s[5]),
                        Integer.parseInt(s[6])
                ))
                .collect(Collectors.toList());

        Streams s = new Streams();
        weaponList.forEach(System.out::println);
        System.out.println(s.findWeaponWithLowestDamage(weaponList));
    }
}
