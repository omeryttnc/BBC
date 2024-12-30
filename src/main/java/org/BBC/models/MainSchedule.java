
package org.BBC.models;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class MainSchedule {

    @JsonProperty("schedule")
    private Schedule schedule;
}
