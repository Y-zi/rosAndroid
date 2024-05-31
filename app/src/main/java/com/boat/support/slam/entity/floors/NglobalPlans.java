package com.boat.support.slam.entity.floors;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class NglobalPlans implements Parcelable {
    private List<NPoint> nPoints;
    private List<NLine> nLines;

    protected NglobalPlans(Parcel in) {
        nPoints = in.createTypedArrayList(NPoint.CREATOR);
        nLines = in.createTypedArrayList(NLine.CREATOR);
    }

    public static final Creator<NglobalPlans> CREATOR = new Creator<NglobalPlans>() {
        @Override
        public NglobalPlans createFromParcel(Parcel in) {
            return new NglobalPlans(in);
        }

        @Override
        public NglobalPlans[] newArray(int size) {
            return new NglobalPlans[size];
        }
    };

    public List<NPoint> getnPoints() {
        return nPoints;
    }

    public void setnPoints(List<NPoint> nPoints) {
        this.nPoints = nPoints;
    }

    public List<NLine> getnLines() {
        return nLines;
    }

    public void setnLines(List<NLine> nLines) {
        this.nLines = nLines;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(nPoints);
        parcel.writeTypedList(nLines);
    }
}
