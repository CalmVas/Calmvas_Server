package org.momo.Member.Controller;

import lombok.*;
import org.momo.Common.BaseResponseDto;
import org.momo.Member.Dto.UserRequest;
import org.momo.Member.Dto.UserResponse;
import org.momo.Member.Service.UserService;
import org.momo.Member.Entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class UserController {
    private final UserService userService;

    @PostMapping("/v1/login")
    public BaseResponseDto<UserResponse.UserLoginResponse> login(@RequestBody UserRequest.UserLoginRequest userLoginRequest){
        UserResponse.UserLoginResponse joined = userService.login(userLoginRequest);
        return BaseResponseDto.onSuccess(joined);
    }

    @PostMapping("/v1/signup")
    public BaseResponseDto<UserResponse.UserCreateResponse> signup(
            @RequestBody UserRequest.UserCreateRequest userCreateRequest) {
        UserResponse.UserCreateResponse joined = userService.join(userCreateRequest);
        return BaseResponseDto.onSuccess(joined);
    }


}
