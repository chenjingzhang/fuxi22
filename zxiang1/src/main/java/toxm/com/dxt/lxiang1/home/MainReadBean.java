package toxm.com.dxt.lxiang1.home;

import android.os.Parcel;
import android.os.Parcelable;

public class MainReadBean implements Parcelable {
    int type;
    Object oo;
    protected MainReadBean() {
    }

    public MainReadBean(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Object getOo() {
        return oo;
    }

    public void setOo(Object oo) {
        this.oo = oo;
    }

    public static final Creator<MainReadBean> CREATOR = new Creator<MainReadBean>() {
        @Override
        public MainReadBean createFromParcel(Parcel in) {
            int type = in.readInt();
            return new MainReadBean(type);
        }

        @Override
        public MainReadBean[] newArray(int size) {
            return new MainReadBean[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(type);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
