package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Geo {

    @JsonProperty("lat")
    private String lat;

    @JsonProperty("lng")
    private String lng;

}



