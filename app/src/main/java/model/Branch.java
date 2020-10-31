package model;

import com.google.firebase.firestore.DocumentId;
import com.google.firebase.firestore.DocumentReference;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Branch {

    @DocumentId
    private String id;
    private String key;
    private String name;
    private String group;
    private DocumentReference board;
    private long semestersCount;
    private long papersCount;
    private List<Semester> semesters = new ArrayList<>();
}
