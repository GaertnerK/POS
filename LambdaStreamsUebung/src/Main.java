import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Weapon> weaponList = new ArrayList<>();
        weaponList = Files.lines(new File("weapons.csv").toPath())
                .skip(1)
                .map(s -> s.split(";"))
                .map(s -> new Weapon(
                        s[0], Integer.parseInt(s[1]), s[2], Double.parseDouble(s[3].replace(",", ".")), Integer.parseInt(s[4]), s[5]
                ))
                .collect(Collectors.toList());

        List<Weapon> playerWeapons = List.of(new Weapon[]{weaponList.get(2), weaponList.get(3), weaponList.get(4)});
        Player player = new Player("Test", 50, playerWeapons);
        StringConverter converter = value -> "Player: " + value.getName() + "; " + value.getMaxWeight() + "; " + value.getCarrying() + "; " + value.getWeapons();
        System.out.println(converter.convert(player));

        //findWhereItemIDStartsWith
        System.out.println("findWhereItemIDStartsWith");
        List<Weapon> list = player.findWhereItemIDStartsWith("U");
        list.forEach(System.out::println);

        //findWithItemID
        System.out.println("findWithItemID");
        Weapon w = player.findWithItemID("UEWABG");
        System.out.println(w);

        //findWithCategory
        System.out.println("findWithCategory");
        List<Weapon> list2 = player.findWithCategory("orcish");
        list2.forEach(System.out::println);

        //sumPrice
        System.out.println("sumPrice");
        int price = player.sumPrice();
        System.out.println(price);

        //averageAttackPoints
        System.out.println("averageAttackPoints");
        int avergeAttackPoints = player.averageAttackPoints();
        System.out.println(avergeAttackPoints);

        //findWithMostAttackPoints
        System.out.println("findWithMostAttackPoints");
        Weapon weapon = player.findWithMostAttackPoints();
        System.out.println(weapon);

        //findWeightUnder
        System.out.println("findWeightUnder");
        List<Weapon> list3 = player.findWeightUnder(20);
        list3.forEach(System.out::println);

        //carryAbleWeapons
        System.out.println("carryAbleWeapons");
        List<Weapon> list4 = player.carryAbleWeapons(player);
        list4.forEach(System.out::println);
    }
}