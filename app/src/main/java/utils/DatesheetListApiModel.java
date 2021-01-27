package utils;

import java.util.List;

public class DatesheetListApiModel {
    private List<DatesheetsInfo> items;

    public DatesheetListApiModel() {
    }

    public DatesheetListApiModel(List<DatesheetsInfo> items) {
        this.items = items;
    }

    public List<DatesheetsInfo> getItems() {
        return items;
    }

    public void setItems(List<DatesheetsInfo> items) {
        this.items = items;
    }
}
