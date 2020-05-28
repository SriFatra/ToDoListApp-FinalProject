package com.srifatra.todolistapp.data.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "todo")
@Parcelize()
data class TodoItem(
    @PrimaryKey(autoGenerate = true) val id: Long?,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "note") val note: String?,
    @ColumnInfo(name = "due") val dueTime: Long?,
    @ColumnInfo(name = "made") val made: Long?,
    @ColumnInfo(name = "update") val update: Boolean?,
    @ColumnInfo(name = "completed") var completed: Boolean
): Parcelable