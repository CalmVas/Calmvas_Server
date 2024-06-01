package org.momo.Member.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * @author : sblim
 * @version : 1.0.0
 * @package : com.karim.jwt.dto
 * @name : spring-basic-server
 * @date : 2023. 04. 27. 027 오후 2:31
 * @modifyed :
 * @description :
 **/

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String username;
    private String email;
    private String nickname;
}