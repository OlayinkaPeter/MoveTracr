package com.olayinkapeter.movetracr.Room;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface TrackDao {
    @Query("SELECT * FROM track")
    List<Track> getAll();

    @Insert
    void insert(Track track);

    @Delete
    void delete(Track track);

    @Update
    void update(Track track);
}
