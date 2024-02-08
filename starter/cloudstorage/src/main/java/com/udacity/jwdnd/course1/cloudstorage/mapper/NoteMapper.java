package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.entity.Note;
import com.udacity.jwdnd.course1.cloudstorage.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoteMapper {
    @Insert("INSERT INTO NOTES (noteid, notetitle, notedescription, userid)" +
            " VALUES (#{note.noteId}, #{note.noteTitle}, #{note.noteDescription}, #{user.userId})")
    @Options(useGeneratedKeys = true, keyProperty = "note.noteId")
    int insert(Note note, User user);

    @Select("SELECT * FROM NOTES WHERE userid = #{id}")
    List<Note> findAllNotes(@Param("id") Integer id);
    @Delete("DELETE FROM NOTES WHERE noteid = #{id}")
    void deleteNote(@Param("id") Integer id);
    @Update("UPDATE NOTES SET notetitle = #{noteTitle}, notedescription = #{noteDescription} WHERE noteid = #{id}")
    void updateNote(@Param("id") Integer id, @Param("noteTitle") String noteTitle, @Param("noteDescription") String noteDescription);
}
