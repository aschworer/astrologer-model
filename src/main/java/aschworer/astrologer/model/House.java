package aschworer.astrologer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

/**
 * @author aschworer on 01-Nov-15.
 */
public enum House implements Characteristic {
    //    @SerializedName("Ascendant")
//    @SerializedName("Asc") @JsonProperty("Asc")
    @SerializedName("Ascendant") @JsonProperty("Ascendant")
    ASC("Ascendant"),
    @SerializedName("House1") @JsonProperty("House1")
    I("I"),
    @SerializedName("House2") @JsonProperty("House2")
    II("II"),
    @SerializedName("House3") @JsonProperty("House3")
    III("III"),
    @SerializedName("House4") @JsonProperty("House4")
    IV("IV"),
    @SerializedName("House5") @JsonProperty("House5")
    V("V"),
    @SerializedName("House6") @JsonProperty("House6")
    VI("VI"),
    @SerializedName("House7") @JsonProperty("House7")
    VII("VII"),
    @SerializedName("House8") @JsonProperty("House8")
    VIII("VIII"),
    @SerializedName("House9") @JsonProperty("House9")
    IX("IX"),
    //    @SerializedName("Midheaven")
//    X("Midheaven"),
    @SerializedName("House10") @JsonProperty("House10")
    X("X"),
    @SerializedName("House11") @JsonProperty("House11")
    XI("XI"),
    @SerializedName("House12") @JsonProperty("House12")
    XII("XII");

    private String string;

    House(String name) {
        string = name;
    }

    public static House getByString(String str) {
        for (House v : values()) {
            if (v.string.equalsIgnoreCase(str)) {
                return v;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        switch (this) {
            case I:
                return "Ascendant (I)";
            case X:
                return "Midheaven (X)";
            default:
                return string;
        }
    }

    public String getString() {
        switch (this) {
            case I:
                return "Ascendant";
            case II:
                return "2nd house";
            case III:
                return "3rd house";
            case IV:
                return "4th house";
            case V:
                return "5th house";
            case VI:
                return "6th house";
            case VII:
                return "7th house";
            case VIII:
                return "8th house";
            case IX:
                return "9th house";
            case X:
                return "Midheaven";
            case XI:
                return "11th house";
            case XII:
                return "12th house";

            default:
                return null;
        }
    }

    public Integer getWeight() {
        switch (this) {
            case I:
                return 7;
            case X:
                return 5;
            default:
//                throw new IllegalArgumentException();
                return 0;//todo throw exception
        }
    }
}
