package teem11.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Summoner {

    @Id
    private String name;
    private String id;

}