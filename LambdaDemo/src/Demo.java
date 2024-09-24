public class Demo {
    Calculator add = (num1, num2) -> num1 + num2;
    //Calculator add = Integer::sum;
    Calculator sub = (num1, num2) -> num1 - num2;


    GenericMapper<Float> mapFloat = param -> "This is a float: " + param;
    GenericMapper<Integer> mapInt = param -> "This is an int: " + param;

    TextFormatter formatter;
    public void setFormatter(TextFormatter formatter) {
        this.formatter = formatter;
    }

    public String format(String text){
        return formatter.format(text);
    }

    public int add(int number1, int number2) {
        return add.calculate(number1, number2);
    }
}
