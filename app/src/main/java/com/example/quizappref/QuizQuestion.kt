package com.example.quizappref

import android.os.Parcel
import android.os.Parcelable

data class QuizQuestion(
    val question: String,
    val options: List<String>,
    val correctAnswer: String,
    val marks: Int,
    var selected: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.createStringArrayList()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(question)
        parcel.writeStringList(options)
        parcel.writeString(correctAnswer)
        parcel.writeInt(marks)
        parcel.writeString(selected)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<QuizQuestion> {
        override fun createFromParcel(parcel: Parcel): QuizQuestion {
            return QuizQuestion(parcel)
        }

        override fun newArray(size: Int): Array<QuizQuestion?> {
            return arrayOfNulls(size)
        }
    }
}
