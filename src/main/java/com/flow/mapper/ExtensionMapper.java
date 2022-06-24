package com.flow.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.flow.domain.Extension;


@Mapper
public interface ExtensionMapper {

    @Select("SELECT * FROM extensions")
    List<Extension> findAll();

    @Select("SELECT extensionId FROM extensions WHERE name=#{name}")
    Long findByName(@Param("name") String name);

    @Insert("INSERT INTO extensions(name, isBlock, type) VALUES(#{name}, #{isBlock}, #{type})")
    int insertExtension(@Param("name") String name, @Param("isBlock") boolean isBlock, @Param("type") int type);

    @Update("UPDATE extensions SET isBlock=#{isBlock} WHERE extensionId=#{extensionId}")
    int updateExtension(@Param("extensionId") Long extensionId, @Param("isBlock") boolean isBlock);

    @Delete("DELETE FROM extensions WHERE extensionId=#{extensionId}")
    int deleteExtension(@Param("extensionId") Long extensionId);
}
