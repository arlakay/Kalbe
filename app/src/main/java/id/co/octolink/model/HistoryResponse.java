package id.co.octolink.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ERD on 14/09/2016.
 */
public class HistoryResponse {
    @SerializedName("history")
    private List<History> histories;

    public List<History> getHistories() {
        return histories;
    }

    public void setHistories(List<History> histories) {
        this.histories = histories;
    }
}
