public class Chocolate extends Sweet{
    private String cocoaContent;

    public Chocolate(String name, double weight, double price, String cocoaContent) {
        super(name, weight, price);
        this.cocoaContent = cocoaContent;
    }

    @Override
    public String getUniqueParameter() {
        return "содержание какао: " + cocoaContent;
    }
}
