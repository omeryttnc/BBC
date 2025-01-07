package org.BBC.models.scheduleNotFound;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NotFoundSchedule {

    @JsonProperty("version")
    private String version;

    @JsonProperty("schema")
    private String schema;

    @JsonProperty("error")
    private ErrorDetails error;
}
