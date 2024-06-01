package org.momo.Member.Service;

import lombok.RequiredArgsConstructor;
import org.momo.Common.status.ErrorStatus;
import org.momo.Exception.handler.MemberHandler;
import org.momo.Member.Converter.UserConverter;
import org.momo.Member.Dto.UserRequest;
import org.momo.Member.Dto.UserResponse;
import org.momo.Member.Entity.User;
import org.momo.Member.Repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponse.UserCreateResponse join(UserRequest.UserCreateRequest userCreateRequest){
        User user = userRepository.findByUsername(userCreateRequest.getName())
                .orElseGet(() -> userRepository.save(UserConverter.toUserEntity(userCreateRequest)));

        return UserConverter.toUserCreateResponse(user);
    }

    @Transactional
    public UserResponse.UserLoginResponse login(UserRequest.UserLoginRequest userLoginRequest){
        User user = userRepository.findByUsername(userLoginRequest.getName())
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        if(user.getPassword().equals(userLoginRequest.getPassword())){
            return UserConverter.toUserLoginResponse(user);
        } else{
            throw new MemberHandler(ErrorStatus.NICKNAME_NOT_EXIST);
        }
    }
}
