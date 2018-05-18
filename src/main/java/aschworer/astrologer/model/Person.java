package aschworer.astrologer.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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
    private LocalDate dob;
    @Getter
    @Setter
    private LocalTime tob;
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
                ", dob='" + DateTimeFormatter.ofPattern("dd-MM-yyyy").format(dob) + '\'' +
                ", birthPlace='" + birthPlace + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
