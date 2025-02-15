package streamsLambda;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class ReadCsv {
    public static final String PATHNAME = "weapons.csv";
    public List<Weapon> readWeapons() throws IOException {
        return Files.lines(new File(PATHNAME).toPath())
                .skip(1)
                .map(s -> s.split(";"))
                .map(s -> new Weapon(s[0], Integer.parseInt(s[1]), s[2], Double.parseDouble(s[3]), Integer.parseInt(s[4]), s[5], s[6]))
                .collect(Collectors.toList());
    }
}
