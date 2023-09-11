package com.hang.work.bank.dao;

import java.util.List;

import com.hang.work.bank.bean.Record;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface RecordDao extends BaseDao<Record> {
    @Override
    @Update("insert into bank_record values(null, #{accountId}, #{money})")
    void insert(Record t);

    @Select("select * from bank_record where accountid=#{accountId}")
    List<Record> selectByAccountId(Integer id);
}
