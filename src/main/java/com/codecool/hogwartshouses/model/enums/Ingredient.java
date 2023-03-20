package com.codecool.hogwartshouses.model.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Ingredient {
    ABRAXIAN_HAIR("abraxian hair"),
    BAT_WING("bat wing"),
    COWBANE("cowbane"),
    DRAGON_BLOOD("dragon blood"),
    EEL_EYE("eel eye"),
    FLESH("flesh"),
    GOOSEGRASS("goosegrass"),
    HALIWINKLES("haliwinkles"),
    IGUANA_BLOOD("iguana blood"),
    JEWELWEED("jewelweed"),
    KELP("kelp"),
    LAVENDER("lavender"),
    MANDRAKE("mandrake"),
    NEWT("newt"),
    OCTOPUS_POWDER("octopus powder"),
    PEARL_DUST("pearl dust"),
    RAT_TAIL("rat tail"),
    SCARAB_BEETLE("scarab beetle"),
    TAR("tar"),
    UNICORN_BLOOD("unicorn blood"),
    VERVAIN("vervain"),
    WATER("water");

    private final String stringValue;

    Ingredient(String stringValue) {
        this.stringValue = stringValue;
    }

    @Override
    public String toString() {
        return stringValue;
    }

    public static Ingredient getByStringValue(String string) {
        return Arrays.stream(values())
                .filter(i -> string.equals(i.toString()))
                .findFirst()
                .orElse(null);
    }

    public static List<String> getStringValues() {
        return Arrays.stream(values())
                .map(Ingredient::toString)
                .collect(Collectors.toList());
    }
}
