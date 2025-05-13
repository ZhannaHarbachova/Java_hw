public abstract class Sweet {
    protected String name;
    protected double weight;
    protected double price;

    protected Sweet(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected void setWeight(double weight) {
        this.weight = weight;
    }

    protected void setPrice(double price) {
        this.price = price;
    }

    protected String getName() {
        return name;
    }

    protected double getWeight() {
        return weight;
    }

    protected double getPrice() {
        return price;
    }

    protected abstract String getUniqueParameter();

    @Override
    public String toString() {
        return "- Наименование: " + name +
                ", вес: " + weight +
                ", цена: " + price +
                ", " + getUniqueParameter();
    }}
