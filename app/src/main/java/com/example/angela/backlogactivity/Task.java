package com.example.angela.backlogactivity;

import android.os.Parcel;
import android.os.Parcelable;

public class Task implements Parcelable {

    private String mName;
    private String mWeight;
    private String mTime;

    Task(String name, String weight, String time) {
        mName = name; mWeight = weight; mTime = time;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getWeight() {
        return mWeight;
    }

    public void setWeight(String weight) {
        mWeight = weight;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String time) {
        mTime = time;
    }

    protected Task(Parcel in) {
        mName = in.readString();
        mTime = in.readString();
        mWeight = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mWeight);
        dest.writeString(mTime);
    }

    public static final Parcelable.Creator<Task> CREATOR = new Parcelable.Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };
}
