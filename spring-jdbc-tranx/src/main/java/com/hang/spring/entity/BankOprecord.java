package com.hang.spring.entity;

import java.util.Date;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 银行-操作流水表-2(BankOprecord)表实体类
 *
 * @author makejava
 * @since 2023-09-17 18:50:32
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankOprecord implements Serializable {
    //流水号@TableId
    private Integer id;

    //卡号
    private Integer aid;
    //操作金额，正数存款，负数取款
    private Double opmoney;
    //交易费
    private Double charge;
    //操作时间, 默认系统当前时间
    private Date optime;
    //备注: 存款,取款,转账,缴费
    private String remark;


}

