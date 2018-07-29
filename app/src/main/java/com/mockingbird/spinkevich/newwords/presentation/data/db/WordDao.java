package com.mockingbird.spinkevich.newwords.presentation.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import com.mockingbird.spinkevich.newwords.presentation.data.converter.DateConverter;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
@TypeConverters(DateConverter.class)
public interface WordDao {

    @Query("SELECT * FROM word")
    LiveData<List<WordEntity>> getAll();

    @Query("SELECT COUNT(*) from word")
    int countWords();

    @Insert(onConflict = REPLACE)
    void insert(WordEntity word);

    @Delete
    void delete(WordEntity word);
}
