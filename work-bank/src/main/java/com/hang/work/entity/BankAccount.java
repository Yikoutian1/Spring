package com.hang.work.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 银行-账号表-2000000000(BankAccount)表实体类
 *
 * @author makejava
 * @since 2023-09-17 18:48:01
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount implements Serializable {
    //银行卡号@TableId
    private Integer id;

    //密码
    private String password;
    //账户余额
    private Double balance;



}

