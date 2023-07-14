package UnderTheC.DeepSea.dto;

import lombok.Getter;

@Getter
public class JsonDto {
    private String status;
    private String message;

    public JsonDto(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
