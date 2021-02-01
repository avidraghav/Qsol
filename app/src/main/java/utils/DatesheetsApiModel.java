package utils;

import java.util.List;

public class DatesheetsApiModel {
    private List<DatesheetsInfo> items;

    public DatesheetsApiModel(){}


    public DatesheetsApiModel(List<DatesheetsInfo> items)
    {
        this.items = items;
    }

    public List<DatesheetsInfo> getItems() {
        return items;
    }

    public void setItems(List<DatesheetsInfo> items) {
        this.items = items;
    }

}

