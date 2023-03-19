package com.codecool.hogwartshouses.model.enums;

public enum Ingredient {
    ABRAXAN_HAIR("abraxian hair"),
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

    private final String rep;

    Ingredient(String rep) {
        this.rep = rep;
    }

    public String getRep() {
        return rep;
    }

    @Override
    public String toString() {
        return this.rep;
    }
}
