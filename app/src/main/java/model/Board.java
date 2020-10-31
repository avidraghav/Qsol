package model;

import com.google.firebase.firestore.DocumentId;

import lombok.Data;

@Data
public class Board {

    @DocumentId
    private String id;
    private String key;
    private long branchCount;
    private long papersCount;
}
