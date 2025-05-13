import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SweetBox implements Box {
    private final List<Sweet> sweets;

    public SweetBox() {
        sweets = new ArrayList<>();
    }

    @Override
    public void addSweet(Sweet sweet) {
        sweets.add(sweet);
    }

    @Override
    public void removeSweet(int index) {
        System.out.println("Удален товар: " + sweets.get(index).getName());
        sweets.remove(index);
    }

    public void removeLastSweet() {
        if (!sweets.isEmpty()) {
            sweets.remove(sweets.size() - 1);
        }
    }

    @Override
    public double getTotalWeight() {
        return sweets.stream().mapToDouble(Sweet::getWeight).sum();
    }

    @Override
    public double getTotalPrice() {
        return sweets.stream().mapToDouble(Sweet::getPrice).sum();
    }

    @Override
    public void displaySweets() {
        for (Sweet sweet : sweets) {
            System.out.println(sweet);
        }
    }

    @Override
    public void decreaseByPrice(double maxWeight) {
        sweets.sort(Comparator.comparing(Sweet::getPrice).reversed());
        decrease(maxWeight);
    }

    @Override
    public void decreaseByWeight(double maxWeight) {
        sweets.sort(Comparator.comparing(Sweet::getWeight).reversed());
        decrease(maxWeight);
    }

    public int getSweetCount() {
        return sweets.size();
    }

    public boolean isEmpty() {
        return sweets.isEmpty();
    }

    private void decrease(double maxWeight) {
        while (getTotalWeight() > maxWeight) {
            Sweet lastSweet = sweets.get(sweets.size() - 1);
            double newWeight = lastSweet.getWeight() - getTotalWeight() + maxWeight;
            if (newWeight > 0) {
                System.out.println("Уменьшено количество товара " + lastSweet.getName());
                lastSweet.setPrice(Math.round(newWeight * lastSweet.getPrice() / lastSweet.getWeight()));
                lastSweet.setWeight(newWeight);
            } else {
                System.out.println("Удален товар " + lastSweet.getName());
                removeLastSweet();
            }
        }
    }
}