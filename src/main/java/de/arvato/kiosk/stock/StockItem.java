package de.arvato.kiosk.stock;

import java.util.Objects;

public class StockItem {


    private String name;
    private double pricePerUnit;
    private int quantity;

    private String category;

    public StockItem() {
    }

    public StockItem(String name, double pricePerUnit, int quantity, String category) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.quantity = quantity;
        this.category = category;
    }

    @Override
    public String toString() {
        return "StockItem{" +
                "name='" + name + '\'' +
                ", price=" + pricePerUnit +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockItem stockItem = (StockItem) o;
        return Double.compare(stockItem.pricePerUnit, pricePerUnit) == 0 && quantity == stockItem.quantity && Objects.equals(name, stockItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pricePerUnit, quantity);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
