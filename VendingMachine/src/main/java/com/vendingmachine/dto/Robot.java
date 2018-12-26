package com.vendingmachine.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class Robot {

    private String id;
    private String name;
    private int quantity;
    private BigDecimal price;
    private String info = "";

    public Robot(String id, String name, int quantity, BigDecimal price, String info) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.info = info;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.name);
        hash = 17 * hash + this.quantity;
        hash = 17 * hash + Objects.hashCode(this.price);
        hash = 17 * hash + Objects.hashCode(this.info);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Robot other = (Robot) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.info, other.info)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        return true;
    }

}
