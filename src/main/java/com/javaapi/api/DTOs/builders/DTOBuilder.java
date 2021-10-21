package mavenpackage.api.DTOs.builders;

import java.sql.Date;

import mavenpackage.api.DTOs.RestrictionDTO;


/** Data Transfer Object Builder */
public class DTOBuilder {
    private Date date_start;
    private Date date_end;
    private boolean close;
    private int min_los;
    private String property;
    private String name;

    public DTOBuilder() {
    }

    public RestrictionDTO restrctionsDTO() {
        return new RestrictionDTO(date_start, date_end, close, min_los);
    }

    public DTOBuilder dateStartRoom(Date date_start) {
        this.date_start = date_start;
        return this;
    }

    public DTOBuilder dateEndRoom(Date date_end) {
        this.date_end = date_end;
        return this;
    }

    public DTOBuilder closeRoom(boolean close) {
        this.close = close;
        return this;
    }

    public DTOBuilder minLosRoom(int min_los) {
        this.min_los = min_los;
        return this;
    }

    public DTOBuilder propertyHotel(String property) {
        this.property = property;
        return this;
    }

    public DTOBuilder name_room(String name) {
        this.name = name;
        return this;
    }
}
