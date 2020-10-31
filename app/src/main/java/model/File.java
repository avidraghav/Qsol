package model;

import com.google.firebase.firestore.DocumentId;
import com.google.firebase.firestore.DocumentReference;

import lombok.Data;

@Data
public class File {

    @DocumentId
    private String id;
    private DocumentReference board;
    private DocumentReference branch;
    private DocumentReference semester;
    private DocumentReference subject;
    private String name;
    private String fileName;
    private String code;
    private String url;
    private String year;
    private boolean isSyllabus;
    private long papersCount;
}
