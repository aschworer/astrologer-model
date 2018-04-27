package aschworer.astrologer.model;

/**
 * Created by aschworer on 01-Nov-15.
 */
public enum Element {
    WATER("Water"),
    EARTH("Earth"),
    FIRE("Fire"),
    AIR("Air");

    private String string;

    Element(String name) {
        string = name;
    }

    public static Element getByString(String str) {
        for (Element v : values()) {
            if (v.toString().equalsIgnoreCase(str)) {
                return v;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return string;
    }

}
