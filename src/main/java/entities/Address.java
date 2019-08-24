package qa.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @JsonProperty("street")
    private String street;

    @JsonProperty("suite")
    private String suite;

    @JsonProperty("city")
    private String city;

    @JsonProperty("zipcode")
    private String zipcode;

    @JsonProperty("geo")
    private Geo geo;
}

