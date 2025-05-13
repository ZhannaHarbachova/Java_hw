public class Marshmallows extends Sweet {
    private String color;

    public Marshmallows(String name, double weight, double price, String color) {
        super(name, weight, price);
        this.color = color;
    }

    @Override
    public String getUniqueParameter() {
        return "цвет: " + color;
    }
}
