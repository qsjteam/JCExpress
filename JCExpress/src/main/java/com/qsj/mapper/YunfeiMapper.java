package com.qsj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qsj.pojo.Prices;

public interface YunfeiMapper {
	List<Prices> yunfei(@Param("in_province")Integer in_province, @Param("weight")Integer weight,@Param("timer") Integer timer);
}
