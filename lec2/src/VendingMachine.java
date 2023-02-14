import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Класс вендинговой машины для хранения и реализиации продуктов
 */
public class VendingMachine {
    private Map<Product, Integer> products = new HashMap<>();
    private int maxStorage;
    private int count = 0;

    /**
     * Конструктор
     * @param maxStorage максимальное кол-во товаров для экземпляра
     */
    VendingMachine(int maxStorage) {
        this.maxStorage = maxStorage;
    }

    public int getMaxStorage() {
        return this.maxStorage;
    }

    public String getProductByName(String name) {
        for (Iterator<Map.Entry<Product, Integer>> it = products.entrySet().iterator(); it.hasNext();){
            Map.Entry<Product, Integer> pr = it.next();
            if(pr.getKey().getName().equals(name)){
                if (pr.getValue() > 1) {
                    pr.setValue(pr.getValue() - 1);
                    count--;
                    return ("Выдан один " + name + " по цене " + pr.getKey().getCost());
                } else {
                    it.remove();
                    count--;
                    return ("Выдан последний продукт " + name + " по цене " + pr.getKey().getCost());
                }
            }
        }
        return ("Нет продукта: " + name + "!");
    }

    public String getProductByCost(double cost) {
        for (Iterator<Map.Entry<Product, Integer>> it = products.entrySet().iterator(); it.hasNext();){
            Map.Entry<Product, Integer> pr = it.next();
            if(pr.getKey().getCost() == cost){
                if (pr.getValue() > 1) {
                    pr.setValue(pr.getValue() - 1);
                    count--;
                    return ("Выдан один " + pr.getKey().getName() + " по цене " + cost);
                } else {
                    it.remove();
                    count--;
                    return ("Выдан последний продукт " + pr.getKey().getName() + " по цене " + cost);
                }
            }
        }
        return ("Нет продукта по цене: " + cost + "!");
    }

    private boolean addProduct(Product product) {
        if (this.products.size() < maxStorage) {
            if (this.products.containsKey(product)){
                int tempQuantity = this.products.get(product);
                this.products.remove(product);
                this.products.put(product, tempQuantity + 1);
                count++;
                return true;
            }
            this.products.put(product, 1);
            count++;
            return true;
        }
        return false;
    }

    /**
     * Если продукт есть, то метод обновит кол-во и цену
     * (по упрощенной схеме - удалит добавит)
     * Если нет, то добавит продукт
     * @param product добавляемый продукт
     * @param quantity кол-во добавляемых продуктов
     * @return true  в случае успешного добавления
     * false в случае НЕ добавления
     */
    public boolean addProducts(Product product, int quantity) {
        if (this.products.size() + quantity <= this.maxStorage){
            for (int i = 0; i < quantity; i++) {
                if (!(addProduct(product))) return false;
            }
            return true;
        }
        return false;
    }

    public String getProductsInfo() {
        return products.toString();
    }

    public Integer size() {
        return this.count;
    }
}
