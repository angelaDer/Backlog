package com.example.angela.backlogactivity;

import android.os.Parcel;
import android.os.Parcelable;

public class Task implements Parcelable {

    private String mName;
    private int mWeight;
    private int mTime;

    Task(String name, int weight, int time) {
        mName = name; mWeight = weight; mTime = time;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getWeight() {
        return mWeight;
    }

    public void setWeight(int weight) {
        mWeight = weight;
    }

    public int getTime() {
        return mTime;
    }

    public void setTime(int time) {
        mTime = time;
    }

    protected Task(Parcel in) {
        mName = in.readString();
        mTime = in.readInt();
        mWeight = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeInt(mWeight);
        dest.writeInt(mTime);
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
