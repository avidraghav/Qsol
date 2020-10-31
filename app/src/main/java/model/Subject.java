package model;

import com.google.firebase.firestore.DocumentId;
import com.google.firebase.firestore.DocumentReference;

import lombok.Data;

@Data
public class Subject {

    @DocumentId
    private String id;
    private String name;
    private DocumentReference board;
    private DocumentReference branch;
    private DocumentReference semester;
    private long papersCount;
    private long syllabusesCount;
}
