package UnderTheC.DeepSea.dto;

import UnderTheC.DeepSea.Entity.User;
import lombok.Getter;

@Getter
public class LoginDto extends JsonDto {
    private String sid;
    private User user;

    public LoginDto(String status, String message, String sid, User user) {
        super(status, message);
        this.sid = sid;
        this.user = user;
    }
}
