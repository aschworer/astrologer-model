package aschworer.astrologer.model;

/**
 * @author aschworer on 01-Nov-15.
 */
public enum Sign {
    ARIES("Aries"),
    TAURUS("Taurus"),
    GEMINI("Gemini"),
    CANCER("Cancer"),
    LEO("Leo"),
    VIRGO("Virgo"),
    LIBRA("Libra"),
    SCORPIO("Scorpio"),
    SAGITTARIUS("Sagittarius"),
    CAPRICORN("Capricorn"),
    AQUARIUS("Aquarius"),
    PISCES("Pisces");

    private String string;

    Sign(String name) {
        string = name;
    }

    public static Sign getByString(String str) {
        for (Sign v : values()) {
            if (v.toString().equalsIgnoreCase(str)) {
                return v;
            }
        }
        return null;
    }

    public Element getElement() {
        switch (this) {
            case ARIES:
                return Element.FIRE;
            case LEO:
                return Element.FIRE;
            case SAGITTARIUS:
                return Element.FIRE;
            case TAURUS:
                return Element.EARTH;
            case VIRGO:
                return Element.EARTH;
            case CAPRICORN:
                return Element.EARTH;
            case GEMINI:
                return Element.AIR;
            case LIBRA:
                return Element.AIR;
            case AQUARIUS:
                return Element.AIR;
            case CANCER:
                return Element.WATER;
            case SCORPIO:
                return Element.WATER;
            case PISCES:
                return Element.WATER;
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return string;
    }

}
