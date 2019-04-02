package com.llx.summer.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @Auther: sharps
 * @Date: 19-4-2 09:33
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String userName;
    private LocalDate birthday;

}
