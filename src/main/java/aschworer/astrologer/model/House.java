package aschworer.astrologer.model;

import com.google.gson.annotations.SerializedName;

/**
 * @author aschworer on 01-Nov-15.
 */
public enum House implements Characteristic {
    //    @SerializedName("Ascendant")
    @SerializedName("Asc")
    ASC("Ascendant"),
    @SerializedName("House1")
    I("I"),
    @SerializedName("House2")
    II("II"),
    @SerializedName("House3")
    III("III"),
    @SerializedName("House4")
    IV("IV"),
    @SerializedName("House5")
    V("V"),
    @SerializedName("House6")
    VI("VI"),
    @SerializedName("House7")
    VII("VII"),
    @SerializedName("House8")
    VIII("VIII"),
    @SerializedName("House9")
    IX("IX"),
    //    @SerializedName("Midheaven")
//    X("Midheaven"),
    @SerializedName("House10")
    X("X"),
    @SerializedName("House11")
    XI("XI"),
    @SerializedName("House12")
    XII("XII");

    private String string;

    House(String name) {
        string = name;
    }

    public static House getByString(String str) {
//        if ("Asc".equalsIgnoreCase(str) || "Ascendant".equalsIgnoreCase(str)){
//            return I;
//        }
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

                default: return "House not found";//todo
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
