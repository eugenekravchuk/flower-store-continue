package com.example.demo.flower;

import lombok.Getter;
import lombok.Setter;
import com.example.demo.Item;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Flower extends Item {
    private double sepalLength;
    private FlowerColor color;
    private Integer price;
    private FlowerType flowerType;

    public Flower(Flower flower) {
        flowerType = flower.flowerType;
        sepalLength = flower.sepalLength;
        price = flower.price;
        color = flower.color;
    }

    public String getColor() {
        return color.toString();
    }

    public boolean match(Flower f) {
        return this.price == f.getPrice() && this.flowerType.equals(f.getFlowerType())
                && this.getSepalLength() == f.getSepalLength();
    }
}
