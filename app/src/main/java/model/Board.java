package model;

import java.util.List;

public class Board {

    private String id;
    private List<Branch> branches;

    public Board() {
    }

    public Board(String id, List<Branch> branches) {
        this.id = id;
        this.branches = branches;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    public void addBranch(Branch branch) {
        this.branches.add(branch);
    }

    public void removeBranch(Branch branch) {
        this.branches.remove(branch);
    }
}
