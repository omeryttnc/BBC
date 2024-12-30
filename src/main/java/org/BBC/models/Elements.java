package org.BBC.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Elements {

    @JsonProperty("id")
    private String id;

    @JsonProperty("transmission_start")
    private String transmission_start;

    @JsonProperty("transmission_end")
    private String transmission_end;

    @JsonProperty("episode")
    private Episode episode;
}
