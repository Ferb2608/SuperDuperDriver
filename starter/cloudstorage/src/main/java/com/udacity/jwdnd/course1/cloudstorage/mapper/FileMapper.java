package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.entity.File;
import com.udacity.jwdnd.course1.cloudstorage.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FileMapper {
    @Insert("INSERT INTO FILES (filename, contenttype, filesize, userid, filedata)" +
            " VALUES (#{fileName}, #{contentType}, #{fileSize}, #{userId}, #{fileData})")
    @Options(useGeneratedKeys = true, keyProperty = "fileId")
    int insertFile(@Param("fileName") String fileName, @Param("contentType") String contentType,
               @Param("fileSize") String fileSize, @Param("userId") Integer userId, @Param("fileData") String fileData);
}
