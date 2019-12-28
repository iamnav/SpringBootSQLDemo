package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.demo.model.Album;

@Mapper
public interface AlbumMapper {
	@Select("select * from album")
    List<Album> findAll();

	@Select("select * from album where id = #{id}")
	List<Album> findAllById(@Param("id") Integer id);

	@Insert("insert into album(id,userId,title) values(#{id},#{userId},#{title})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
            before = false, resultType = Integer.class)
	void insert(Album album);
}
