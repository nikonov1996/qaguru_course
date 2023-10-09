package org.example.patterns.Builder;

public class Test {
    public static void main(String[] args) {

        Product product1 = new ProductBuilder()
                .setTitle("Колбаса Ветчина")
                .setCompany("ООО Омский бекон")
                .setCoast(329)
                .setToxic(false)
                .build();

        Product product2 = new ProductBuilder()
                .setTitle("Колбаса Салями")
                .setCompany("ООО Омский бекон")
                .build();

        System.out.println(product1);
        System.out.println("*******");
        System.out.println(product2);
    }


}
