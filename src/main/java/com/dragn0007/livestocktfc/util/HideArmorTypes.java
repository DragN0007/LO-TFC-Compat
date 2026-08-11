package com.dragn0007.livestocktfc.util;

public enum HideArmorTypes {
    COPPER("copper", LOTFCArmorMaterials.COPPER_HIDE),
    BRONZE("bronze", LOTFCArmorMaterials.BRONZE_HIDE),
    WROUGHT_IRON("wrought_iron", LOTFCArmorMaterials.WROUGHT_IRON_HIDE),
    STEEL("steel", LOTFCArmorMaterials.STEEL_HIDE),
    BLACK_STEEL("black_steel", LOTFCArmorMaterials.BLACK_STEEL_HIDE),
    BLUE_STEEL("blue_steel", LOTFCArmorMaterials.BLUE_STEEL_HIDE),
    RED_STEEL("red_steel", LOTFCArmorMaterials.RED_STEEL_HIDE);

    public final String name;
    public final LOTFCArmorMaterials type;

    public String getName() {
        return this.name;
    }

    public LOTFCArmorMaterials getType() {
        return this.type;
    }

    HideArmorTypes(String name, LOTFCArmorMaterials material) {
        this.name = name;
        this.type = material;
    }
}
