package org.momo.Member.Service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.momo.Member.Dto.UserRequest;
import org.momo.Member.Dto.UserResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.boot.test.mock.mockito.SpyBean;

@ExtendWith(SpringExtension.class)
public class UserServiceTest {
    @SpyBean
    private UserService userService;

    @Test
    public void testForSignup(UserRequest.UserCreateRequest userCreateRequest) {
//        doReturn(-1).when(clientService).registerClient(null, "yo");

    }
}
