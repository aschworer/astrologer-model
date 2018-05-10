package aschworer.astrologer.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by aschworer on 01-Nov-15.
 */
@NoArgsConstructor
public class Person {
    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private String owner;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String dob;
    @Getter
    @Setter
    private String tob;
    @Getter
    @Setter
    private String birthPlace;
    @Getter
    @Setter
    private String sex;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", birthPlace='" + birthPlace + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
