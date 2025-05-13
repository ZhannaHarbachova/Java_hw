public interface Box {
    void addSweet(Sweet sweet);
    void removeSweet(int index);
    void removeLastSweet();
    double getTotalWeight();
    double getTotalPrice();
    void displaySweets();
    void decreaseByWeight(double maxWeight);
    void decreaseByPrice(double maxWeight);
}
