package com.gildedrose;

import com.gildedrose.Item;
import com.gildedrose.GildedRose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {

    @Test
    public void Sulfuras_QualityDoesNotDecrease() {
        GildedRose app = new GildedRose(createItemArray("Sulfuras, Hand of Ragnaros", 20, 33));
        app.updateQuality();
        assertEquals(33, app.items[0].quality, "Quality is not decreased for this legendary item");
    }

    @Test
    public void Sulfuras_NeverHasToBeSold() {
        GildedRose app = new GildedRose(createItemArray("Sulfuras, Hand of Ragnaros", 1, 17));
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn, "Sellin is not decreased for this legendary item");
    }

    // sellin date
    // - once past, quality degrades twice as fast
    // quality - never negative, never more than 50

    //generic item
    //aged brie - quality increases with age
    //backstage pass
    // - quality increases each update
    // - between day 6-10 quality increases by 2
    // - between day 1-5 quality increases by 3
    // - quality drops to 0 when concert passes

    //NEW BEHAVIOR
    // conjured items



    private Item[] createItemArray(String itemName, int sellIn, int quality) {
        return new Item[] { new Item(itemName, sellIn, quality) };
    }



}
