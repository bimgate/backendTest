package qa.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
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



