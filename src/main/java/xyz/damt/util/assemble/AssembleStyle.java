package xyz.damt.util.assemble;

import lombok.Getter;

@Getter
public enum AssembleStyle {

    KOHI(true, 15),
    VIPER(true, -1),
    MODERN(false, 1);

    private final boolean descending;
    private final int startNumber;

    /**
     * Assemble Style.
     *
     * @param descending whether the positions are going down or up.
     * @param startNumber from where to loop from.
     */
    AssembleStyle(boolean descending, int startNumber) {
        this.descending = descending;
        this.startNumber = startNumber;
    }

}
