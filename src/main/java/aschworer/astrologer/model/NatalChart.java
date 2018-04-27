package aschworer.astrologer.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aschworer
 */
@NoArgsConstructor
public class NatalChart {

    @Getter
    @Setter
    private Person person;

    @Getter
    private List<CharacteristicInSign> characteristicsInSigns = new ArrayList<>();//todo change to a map

    public NatalChart(List<CharacteristicInSign> characteristicsInSigns) {
        this.characteristicsInSigns = characteristicsInSigns;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public void sortByWeight() {
        characteristicsInSigns.sort((characteristicInSign1, characteristicInSign2) -> {
                    if (characteristicInSign1.getCharacteristic().getWeight() > characteristicInSign2.getCharacteristic().getWeight()) {
                        return -1;
                    } else if (characteristicInSign1.getCharacteristic().getWeight() < characteristicInSign2.getCharacteristic().getWeight()) {
                        return 1;
                    } else if (characteristicInSign1.getCharacteristic().getWeight().equals(characteristicInSign2.getCharacteristic().getWeight())) {
                        return 0;
                    }
                    return 1;
                }
        );
    }

    public Sign[] getSign(Characteristic characteristic) {
        for (CharacteristicInSign characteristicInSign : characteristicsInSigns) {
            if (characteristicInSign.getCharacteristic().equals(characteristic)) {
                return characteristicInSign.getSigns();
            }
        }
        return null;
    }
}
