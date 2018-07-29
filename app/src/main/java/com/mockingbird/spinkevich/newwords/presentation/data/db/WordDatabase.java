package com.mockingbird.spinkevich.newwords.presentation.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {WordEntity.class}, version = 1)
public abstract class WordDatabase extends RoomDatabase {

    private static WordDatabase INSTANCE;
    public static final String DATABASE_NAME = "words.db";

    public abstract WordDao wordDao();

    public static WordDatabase getWordDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (WordDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordDatabase.class, DATABASE_NAME)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public static void clean() {
        INSTANCE = null;
    }
}
