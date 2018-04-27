package aschworer.astrologer.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author aschworer
 * @since april'18
 */
@NoArgsConstructor
public class AstrologerLambdaRequest {

    @Getter
    @Setter
    public String operation;
    @Getter
    @Setter
    public String name;
    @Getter
    @Setter
    public Person person;
    @Getter
    @Setter
    public Characteristic characteristic;
    @Getter
    @Setter
    public Sign sign;
    @Getter
    @Setter
    public Element element;

    public AstrologerLambdaRequest(String operation) {
        this.operation = operation;
    }

}

