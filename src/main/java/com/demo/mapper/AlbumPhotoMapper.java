package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.demo.model.AlbumPhoto;

@Mapper
public interface AlbumPhotoMapper {
	@Select("select * from photo")
	List<AlbumPhoto> findAll();

	@Select("select * from photo where albumId = #{albumId} and id = #{id}")
	List<AlbumPhoto> findAllByAlbumIdAndId(@Param("albumId") Integer albumId, @Param("id") Integer id);

	@Insert("insert into photo(albumId,id,title,url,thumbnailUrl) values(#{albumId},#{id},#{title},#{url},#{thumbnailUrl})")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	void insert(AlbumPhoto albumPhoto);
}
