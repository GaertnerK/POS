public class Main {
    public static void main(String[] args) {
        double points = 85.5;
        System.out.println(getGrade((int)points));
    }

    public static double getGrade(int points){
        return switch (points){
            case 105, 106, 107,108,109,110,111,112,113,114,115,116,117,118,119,120 ->  1.0;
            case 100,101,102,103,104 -> 1.3;
            case 95,96,97,98,99 -> 1.7;
            case 90,91,92,93,94 -> 2.0;
            case 85,86,87,88,89 -> 2.3;
            case 80,81,82,83,84 -> 2.7;
            case 75,76,77,78,79 -> 3.0;
            case 70,71,72,73,74 -> 3.3;
            case 65,66,67,68,69 -> 3.7;
            case 60,61,62,63,64 -> 4.0;
            case 50,51,52,53,54,55,56,57,58,59 -> 4.7;
            default -> 5.0;
        };
    }
}