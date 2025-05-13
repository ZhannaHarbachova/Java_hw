public class Waffle extends Sweet {
    private String filling;

    public Waffle(String name, double weight, double price, String filling) {
        super(name, weight, price);
        this.filling = filling;
    }

    @Override
    public String getUniqueParameter() {
        return "начинка: " + filling;
    }
}