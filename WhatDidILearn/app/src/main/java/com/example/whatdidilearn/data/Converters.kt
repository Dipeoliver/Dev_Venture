package com.example.whatdidilearn.data

import androidx.room.TypeConverter
import com.example.whatdidilearn.R


class Converters {
    @TypeConverter
    fun levelToInt(level: UnderstandingLevel): Int{
        return level.ordinal
    }
    fun intToLevel(int: Int): UnderstandingLevel {
        return when (int) {
            UnderstandingLevel.LOW.ordinal -> UnderstandingLevel.LOW
            UnderstandingLevel.MEDIUM.ordinal -> UnderstandingLevel.MEDIUM
            else  -> UnderstandingLevel.HIGH
        }
    }
}