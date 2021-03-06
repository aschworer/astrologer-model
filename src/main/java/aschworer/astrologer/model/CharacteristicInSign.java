package aschworer.astrologer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by aschworer on 01-Nov-15.
 */
@NoArgsConstructor
public class CharacteristicInSign {

    @Getter
    @Setter
    @JsonAdapter(CharacteristicAdapter.class)
    @JsonDeserialize(using = CharacteristicAdapter.class)
    private Characteristic characteristic;

    @Getter
    @Setter
    @SerializedName("sign")
    @JsonProperty("sign")
    private Sign[] signs = new Sign[1];

    @Getter
    @Setter
    private String angle;

    public CharacteristicInSign(Characteristic characteristic, Sign[] signs, String angle) {
        this.characteristic = characteristic;
        this.signs = signs;
        this.angle = angle;
    }

    public CharacteristicInSign(Characteristic characteristic, Sign sign) {
        this.characteristic = characteristic;
        this.signs[0] = sign;
    }

    @Override
    public String toString() {
        return characteristic.getString() + ": " + ((signs.length > 1) ? toSignRange() : signs[0]) + ((signs.length > 1) ? "" : " (" + signs[0].getElement() + ")");
    }

    public String toSignRange() {
        StringBuilder signsDisplay = new StringBuilder();
        int i = 0;
        for (Sign sign : signs) {
            if (i != 0) signsDisplay.append(" to ");
            signsDisplay.append(sign);
            i++;
        }
        return signsDisplay.toString();
    }
}
