package qa.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @JsonProperty("name")
    private String name;

    @JsonProperty("catchPhrase")
    private String catchPhrase;

    @JsonProperty("bs")
    private String bs;
}
