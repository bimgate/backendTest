package qa.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Posts {

    @JsonProperty("userId")
    private int userId;

    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("body")
    private String body;


}



