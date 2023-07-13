package UnderTheC.DeepSea.controller;

import UnderTheC.DeepSea.Entity.User;
import UnderTheC.DeepSea.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "user API", description = "유저 정보 API")
@RequestMapping("/user")
public class UserController {
    private UserRepository userRepository;

    UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("")
    @Operation(summary = "유저 모두 찾기", description = "user 테이블에 저장된 모든 유저 정보를 반환", responses = {
            @ApiResponse(responseCode = "200", description = "성공"),
            @ApiResponse(responseCode = "400", description = "실패")
    })
    public List<User> findAll() {
        List<User> user = null;
        user = userRepository.findAll();
        return user;
    }

    @GetMapping("/email")
    @Operation(summary = "유저를 email 기준으로 찾기")
    public User findByEmail(@RequestParam("email") String email) {
        User user = null;
        user = userRepository.findByEmail(email);
        return user;
    }

    @PostMapping("")
    @Operation(summary = "유저 추가", description = "user 테이블에 지정된 ID로 유저 추가", responses = {
            @ApiResponse(responseCode = "200", description = "성공")
    })
    public User addById(@RequestParam("id") String id) {
        User user = null;
        user = new User();
        user.setID(id);
        user.setPasswd("1234");
        user.setEmail("ACID@naver.com");
        userRepository.save(user);
        return user;
    }

    @DeleteMapping("")
    @Operation(summary = "유저 삭제", description = "user 테이블에 지정된 ID로 유저 삭제", responses = {
            @ApiResponse(responseCode = "200", description = "성공")
    })
    public User deleteById(@RequestParam("id") String id) {
        Optional<User> user = null;
        user = userRepository.findById(id);
        userRepository.deleteById(id);
        return user.get();
    }
}
