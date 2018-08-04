package com.mockingbird.spinkevich.newwords.presentation.data.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.mockingbird.spinkevich.newwords.presentation.data.converter.DateConverter;

import java.util.Date;

@Entity(tableName = "word")
public class WordEntity implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.word);
        dest.writeString(this.translation);
        dest.writeString(this.translateDirection);
        dest.writeLong(this.timeStamp != null ? this.timeStamp.getTime() : -1);
    }

    public WordEntity() {
    }

    protected WordEntity(Parcel in) {
        this.id = in.readInt();
        this.word = in.readString();
        this.translation = in.readString();
        this.translateDirection = in.readString();
        long tmpTimeStamp = in.readLong();
        this.timeStamp = tmpTimeStamp == -1 ? null : new Date(tmpTimeStamp);
    }

    public static final Parcelable.Creator<WordEntity> CREATOR = new Parcelable.Creator<WordEntity>() {
        @Override
        public WordEntity createFromParcel(Parcel source) {
            return new WordEntity(source);
        }

        @Override
        public WordEntity[] newArray(int size) {
            return new WordEntity[size];
        }
    };
}