package model;

import java.util.ArrayList;
import java.util.List;

public class Mocks {

    public static List<Board> boards = new ArrayList<>();

    static {
        Board hsBoard = new Board("HS", new ArrayList<>());
        boards.add(hsBoard);

        Branch coBranch = new Branch("CO", new ArrayList<>());
        Branch cseBranch = new Branch("CSE", new ArrayList<>());
        Branch cvBranch = new Branch("CV", new ArrayList<>());
        Branch eceBranch = new Branch("ECE", new ArrayList<>());
        Branch eleBranch = new Branch("ELE", new ArrayList<>());
        Branch meBranch = new Branch("ME", new ArrayList<>());
        Branch mlBranch = new Branch("ML", new ArrayList<>());
        hsBoard.addBranch(coBranch);
        hsBoard.addBranch(cseBranch);
        hsBoard.addBranch(cvBranch);
        hsBoard.addBranch(eceBranch);
        hsBoard.addBranch(eleBranch);
        hsBoard.addBranch(meBranch);
        hsBoard.addBranch(mlBranch);

        // Create and add HS/CO semesters
        Semester co01Semester = new Semester("01", new ArrayList<>());
        Semester co02Semester = new Semester("02", new ArrayList<>());
        coBranch.addSemester(co01Semester);
        coBranch.addSemester(co02Semester);

        // Create and add HS/CO first semester lectures
        co01Semester.addLecture(new Lecture("BL", "Basic electrical engineering"));
        co01Semester.addLecture(new Lecture("S1", "Communication skills"));
        co01Semester.addLecture(new Lecture("M1", "Applied mathematics-1"));
        co01Semester.addLecture(new Lecture("P1", "Applied physics-1"));
        co01Semester.addLecture(new Lecture("C1", "Applied chemistry-1"));
        co01Semester.addLecture(new Lecture("D1", "Engineering drawing-1"));

        // Create and add HS/CO second semester lectures
        co02Semester.addLecture(new Lecture("AX", "Analog electronics-1"));
        co02Semester.addLecture(new Lecture("PG", "Programming in C"));
        co02Semester.addLecture(new Lecture("BL", "Basic electrical engineering"));
        co02Semester.addLecture(new Lecture("S2", "Communication skills-2"));
        co02Semester.addLecture(new Lecture("M2", "Applied mathematics-2"));
        co02Semester.addLecture(new Lecture("P2", "Applied physics-2"));
        co02Semester.addLecture(new Lecture("C2", "Applied chemistry-2"));
        co02Semester.addLecture(new Lecture("D2", "Engineering drawing-2"));
        co02Semester.addLecture(new Lecture("AM", "Applied mechanics"));
    }

    private Mocks() {
    }
}
