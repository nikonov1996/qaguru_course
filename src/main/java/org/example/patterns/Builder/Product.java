package org.example.patterns.Builder;

public class Product {
    private String title;
    private String company;
    private Integer coast;

    private Boolean toxic;

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", company='" + company + '\'' +
                ", coast=" + coast +
                ", toxic=" + toxic +
                '}';
    }

    public Product(String title, String company, Integer coast, Boolean toxic) {
        this.title = title;
        this.company = company;
        this.coast = coast;
        this.toxic = toxic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getCoast() {
        return coast;
    }

    public void setCoast(Integer coast) {
        this.coast = coast;
    }

    public Boolean isToxic() {
        return toxic;
    }

    public void setToxic(Boolean toxic) {
        this.toxic = toxic;
    }
}
