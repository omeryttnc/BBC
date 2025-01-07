package org.BBC.models.schedulePositive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Schedule {

    @JsonProperty("channel")
    private Channel channel;

    @JsonProperty("elements")
    private List<Elements> elements;
}
