package com.jackingaming.vesselforcheesepos.models.menu_items.drinks;

public enum DrinkSize {
    KID(8),
    SHORT(8),
    TALL(12),
    GRANDE(16),
    VENTI_HOT(20),
    VENTI_ICED(24),
    TRENTA(30),
    SOLO(-1),
    DOPPIO(-1),
    TRIPLE(-1),
    QUAD(-1),
    UNIQUE(-1),
    UNDEFINED(-1);

    private final int sizeInFlOz;

    DrinkSize(int sizeInFlOz) {
        this.sizeInFlOz = sizeInFlOz;
    }

    public int getSizeInFlOz() {
        return sizeInFlOz;
    }

    public String getUserFriendlyName() {
        String nameDrinkInLowercase = name().toLowerCase();
        if (nameDrinkInLowercase.length() >= "venti".length() &&
                nameDrinkInLowercase.substring(0, 5).equals("venti")) {
            nameDrinkInLowercase = "venti";
        }
        return capitalizeFirstLetter(nameDrinkInLowercase);
    }

    private String capitalizeFirstLetter(String text) {
        char[] c = text.toCharArray();
        c[0] = Character.toUpperCase(c[0]);
        return new String(c);
    }
}
