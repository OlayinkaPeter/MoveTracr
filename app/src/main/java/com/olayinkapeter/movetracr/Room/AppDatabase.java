package com.olayinkapeter.movetracr.Room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Track.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TrackDao trackDao();
}
