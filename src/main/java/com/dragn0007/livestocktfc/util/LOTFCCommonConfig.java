package com.dragn0007.livestocktfc.util;

import net.minecraftforge.common.ForgeConfigSpec;

public class LOTFCCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

//    public static final ForgeConfigSpec.BooleanValue HORSE_QUERN;
//    public static final ForgeConfigSpec.BooleanValue QUEEN_BEE_SCRAPE;

    static {
//        BUILDER.push("TFC Changes");
//        HORSE_QUERN = BUILDER.define("Allow Horse-Drawn Quern", true);
//        BUILDER.pop();

//        BUILDER.push("Firmalife Changes");
//        QUEEN_BEE_SCRAPE = BUILDER.define("Queen Bee Dies When Scraped", false);
//        BUILDER.pop();

        SPEC = BUILDER.build();
    }
}
