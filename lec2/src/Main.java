
public class Main {
    public static void main(String[] args) {
        Product pr1 = new Product("chips", 74.3);
        Product pr2 = new Product("cola", 80.65);
        Product pr3 = new Product("mars", 50.50);
        Product pr4 = new Product("gum", 10.20);
        Product pr4_2 = new Product("gum", 11.11);


//        System.out.println(pr1);
//        System.out.println(pr2);
//        System.out.println(pr3);

        VendingMachine vM = new VendingMachine(10);
        System.out.println("storage: " + vM.size() + ", limit: " + vM.getMaxStorage());
        System.out.println("---");

        System.out.println(vM.addProducts(pr1, 1));
        System.out.println(vM.addProducts(pr2, 1));
        System.out.println(vM.addProducts(pr3, 2));
        System.out.println(vM.addProducts(pr3, 1));
        System.out.println(vM.addProducts(pr4, 1));
        System.out.println(vM.addProducts(pr4_2, 1));
        System.out.println(vM.addProducts(pr4_2, 10));
        System.out.println("storage: " + vM.size() + ", limit: " + vM.getMaxStorage());
        System.out.println("---");

        System.out.println(vM.getProductByName("cola"));
        System.out.println("storage: " + vM.size() + ", limit: " + vM.getMaxStorage());
        System.out.println("---");
        System.out.println(vM.getProductByCost(50.50));
        System.out.println("storage: " + vM.size() + ", limit: " + vM.getMaxStorage());
        System.out.println("---");


        System.out.println("Остаток продуктов: " + vM.getProductsInfo());

    }
}
