package org.example.patterns.Builder;

public class ProductBuilder {

    private String title;
    private String company;
    private Integer coast;

    private Boolean toxic;

    public ProductBuilder(){
    }

    public Product build(){
        return new Product(title,company,coast,toxic);
    }

    public ProductBuilder setTitle(String title) {
        this.title = title;
        return this;
    }


    public ProductBuilder setCompany(String company) {
        this.company = company;
        return this;
    }


    public ProductBuilder setCoast(Integer coast) {
        this.coast = coast;
        return this;
    }

    public ProductBuilder setToxic(Boolean toxic) {
        this.toxic = toxic;
        return this;
    }
}
