package UnderTheC.DeepSea.dto;

import UnderTheC.DeepSea.Entity.User;
import lombok.Getter;

@Getter
public class LoginDto extends JsonDto {
    private User user;

    public LoginDto(String status, String message, User user) {
        super(status, message);
        this.user = user;
    }
}
