package org.BBC.models.scheduleNotFound;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorDetails {

    @JsonProperty("details")
    private String details;

    @JsonProperty("http_response_code")
    private int http_response_code;
}
