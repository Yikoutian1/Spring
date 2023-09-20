package com.hang.work.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName AccountDto
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/17 017 20:21
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private Integer id;
    private Double money;
}
