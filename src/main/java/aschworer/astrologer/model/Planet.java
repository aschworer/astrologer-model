package aschworer.astrologer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

/**
 * @author aschworer on 01-Nov-15.
 */

public enum Planet implements Characteristic {
    @SerializedName("Sun") @JsonProperty("Sun")
    SUN("Sun"),
    @SerializedName("Moon") @JsonProperty("Moon")
    MOON("Moon"),
    @SerializedName("Mercury") @JsonProperty("Mercury")
    MERCURY("Mercury"),
    @SerializedName("Mars") @JsonProperty("Mars")
    MARS("Mars"),
    @SerializedName("Venus") @JsonProperty("Venus")
    VENUS("Venus"),
    @SerializedName("Jupiter") @JsonProperty("Jupiter")
    JUPITER("Jupiter"),
    @SerializedName("Saturn") @JsonProperty("Saturn")
    SATURN("Saturn"),
    @SerializedName("Uranus") @JsonProperty("Uranus")
    URANUS("Uranus"),
    @SerializedName("Neptune") @JsonProperty("Neptune")
    NEPTUNE("Neptune"),
    @SerializedName("Pluto") @JsonProperty("Pluto")
    PLUTO("Pluto"),
    @SerializedName("Chiron") @JsonProperty("Chiron")
    CHIRON("Chiron"),
    @SerializedName("Lilith") @JsonProperty("Lilith")
    LILITH("Lilith"),
    @SerializedName("Asc node") @JsonProperty("Asc node")
    ASC_NODE("Asc node");

    private String string;

    Planet(String name) {
        string = name;
    }

    public static Planet getByString(String str) {
        for (Planet v : values()) {
            if (v.string.equalsIgnoreCase(str)) {
                return v;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return string;
    }

    public String getString() {
        return toString();
    }

    public Integer getWeight() {
        switch (this) {
            case SUN:
                return 10;
            case MOON:
                return 10;
            case MARS:
                return 8;
            case VENUS:
                return 8;
            case MERCURY:
                return 8;
            case JUPITER:
                return 2;
            case SATURN:
                return 1;
            case URANUS:
                return 1;
            case NEPTUNE:
                return 1;
            case PLUTO:
                return 1;
            case CHIRON:
                return 1;
            case LILITH:
                return 0;//todo
            case ASC_NODE:
                return 0;//todo
            default:
                throw new IllegalArgumentException();
        }
    }


        /*public Element getElement() {

            switch (this) {
                case SUN:
                    return Element.FIRE;
                case MOON:
                    return Element.WATER;
                case MERCURY:
                    return Element.AIR;//or earth
                case VENUS:
                    return Element.EARTH;//or air
                case MARS:
                    return Element.FIRE;
                case JUPITER:
                    return Element.AIR;//or fire
                case SATURN:
                    return Element.EARTH;
                case URANUS:
                    return Element.AIR;
                case NEPTUNE:
                    return Element.WATER;
                case PLUTO:
                    return Element.WATER;
                default:
                    throw new IllegalArgumentException();
            }
        }*/
}
