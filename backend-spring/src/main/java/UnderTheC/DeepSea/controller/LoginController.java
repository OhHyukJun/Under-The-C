package UnderTheC.DeepSea.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "로그인", description = "로그인 API")
@RequestMapping("/login-user")
public class LoginController {
//    @PostMapping("login")
//    @Operation(summary = "로그인", description = "로그인 API", responses = {
//            @ApiResponse(responseCode = "200", description = "야호! 성공!!!")
//    })
//    public String login() {
//        return "";
//    }
//
//    @PostMapping("logout")
//    @Operation(summary = "로그인", description = "로그인 API", responses = {
//            @ApiResponse(responseCode = "200", description = "야호! 성공!!!")
//    })
//    public String logout() {
//        return "";
//    }
}
