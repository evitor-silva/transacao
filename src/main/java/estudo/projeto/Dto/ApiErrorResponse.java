package estudo.projeto.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ApiErrorResponse(
        @JsonProperty("message")
        String data,
        @JsonProperty("status")
        Integer errorCode
) {
    public String getMessage(){
        return data;
    }
    public Integer getStatus(){
        return errorCode;
    }
}
