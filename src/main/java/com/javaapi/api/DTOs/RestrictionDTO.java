package mavenpackage.api.DTOs;

import java.sql.Date;

import com.google.gson.annotations.SerializedName;

public class RestrictionDTO {
    @SerializedName("date_start")
    public Date date_start;
    @SerializedName("date_end")
    public Date date_end;
    @SerializedName("close")
    public boolean close;
    @SerializedName("min_los")
    public int min_los;

    public RestrictionDTO(Date date_start, Date date_end, boolean close, int min_los) {
        this.date_start = date_start;
        this.date_end = date_end;
        this.close = close;
        this.min_los = min_los;
    }
}
