package com.nhom1.productservice.query.queries;

public class getProductToAdvise {
    String categoryName;
    String brandName;
    double PriceMax;
    double PriceMin;

    public String getcategoryName() {
        return categoryName;
    }

    public void setcategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getbrandName() {
        return brandName;
    }

    public void setbrandName(String brandName) {
        this.brandName = brandName;
    }

    public double getPriceMax() {
        return PriceMax;
    }

    public void setPriceMax(double PriceMax) {
        this.PriceMax = PriceMax;
    }

    public double getPriceMin() {
        return PriceMin;
    }

    public void setPriceMin(double PriceMin) {
        this.PriceMin = PriceMin;
    }
}
