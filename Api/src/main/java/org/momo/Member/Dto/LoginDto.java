package org.momo.Member.Dto;

import lombok.*;

/**
 * @author : sblim
 * @version : 1.0.0
 * @package : com.karim.jwt.dto
 * @name : spring-basic-server
 * @date : 2023. 04. 27. 027 오후 2:29
 * @modifyed :
 * @description :
 **/
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    private String username;
    private String password;
}