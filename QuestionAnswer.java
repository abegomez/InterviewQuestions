package myapp.abrahamjohngomez.com.interviewchallenges;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ryuhyoko on 7/2/2017.
 */

public class QuestionAnswer implements Parcelable {
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    private int index;
    private String question;
    private String answer;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.index);
        dest.writeString(this.question);
        dest.writeString(this.answer);
    }

    public QuestionAnswer() {
    }

    protected QuestionAnswer(Parcel in) {
        this.index = in.readInt();
        this.question = in.readString();
        this.answer = in.readString();
    }

    public static final Parcelable.Creator<QuestionAnswer> CREATOR = new Parcelable.Creator<QuestionAnswer>() {
        @Override
        public QuestionAnswer createFromParcel(Parcel source) {
            return new QuestionAnswer(source);
        }

        @Override
        public QuestionAnswer[] newArray(int size) {
            return new QuestionAnswer[size];
        }
    };
}
