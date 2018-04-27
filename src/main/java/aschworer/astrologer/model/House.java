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
        return string;
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
