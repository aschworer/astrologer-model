package aschworer.astrologer.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

@NoArgsConstructor
public class AstrologerLambdaResponse {

    @Getter
    @Setter
    private String message;

    @Getter
    @Setter
    private AstrologerLambdaRequest request;

    @Getter
    @Setter
    private List<NatalChart> charts;

    @Getter
    @Setter
    private List<Person> people;

    @Getter
    @Setter
    private NatalChart natalChart;

//    @Getter
//    @Setter
//    private HashMap<Person, Sign[]> personAndSignOfObject;

    public AstrologerLambdaResponse(String message) {
        this.message = message;
    }

    public AstrologerLambdaResponse(AstrologerLambdaRequest request, List<NatalChart> charts) {
        this.request = request;
        this.charts = charts;
    }

    public AstrologerLambdaResponse(AstrologerLambdaRequest request, NatalChart natalChart) {
        this.request = request;
        this.natalChart = natalChart;
    }

    public AstrologerLambdaResponse(AstrologerLambdaRequest request) {
        this.request = request;
    }

    public AstrologerLambdaResponse(AstrologerLambdaRequest request, String message) {
        this.message = message;
        this.request = request;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
