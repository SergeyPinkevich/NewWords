package com.mockingbird.spinkevich.newwords.presentation.data.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.mockingbird.spinkevich.newwords.presentation.data.converter.DateConverter;

import java.util.Date;

@Entity(tableName = "word")
public class WordEntity {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    @ColumnInfo(name = "word")
    private String word;

    @ColumnInfo(name = "translation")
    private String translation;

    @ColumnInfo(name = "translateDirection")
    private String translateDirection;

    @TypeConverters(DateConverter.class)
    @ColumnInfo(name = "timeStamp")
    private Date timeStamp;

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getTranslateDirection() {
        return translateDirection;
    }

    public void setTranslateDirection(String translateDirection) {
        this.translateDirection = translateDirection;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}