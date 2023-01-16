package com.lgm.publicdata.repository;

import com.lgm.publicdata.entity.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BoardRepository {

    @Select("select * from board where id = #{id}")
    Board findById(Long id);

    Board findByTitle(String title);
}
