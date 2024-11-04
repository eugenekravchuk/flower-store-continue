package com.example.demo.flower;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlowerPack {
    private Flower flower;
    private int count;

    public FlowerPack(Flower newFlower, int newCount) {
        flower = new Flower(newFlower);
        count = newCount;
    }

    public double getPrice() {
        return flower.getPrice() * count;
    }

    public boolean match(FlowerPack fp) {
        return this.count == fp.count && this.flower.match(fp.flower);
    }

    @Override
    public String toString() {
        return "FlowerPack" + " " + this.getPrice() + " " + this.count;
    }
}
