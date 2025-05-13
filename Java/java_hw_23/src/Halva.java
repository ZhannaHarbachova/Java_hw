public class Halva extends Sweet {
    private String type;

    public Halva(String name, double weight, double price, String type) {
            super(name, weight, price);
            this.type = type;
    }

    @Override
    public String getUniqueParameter() {
        return "вид: " + type;
    }
}
