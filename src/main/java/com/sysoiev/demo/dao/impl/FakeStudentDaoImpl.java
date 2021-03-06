package com.sysoiev.demo.dao.impl;

import com.sysoiev.demo.dao.StudentDao;
import com.sysoiev.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("fakeDao")
public class FakeStudentDaoImpl implements StudentDao {
    private final Map<UUID, Student> database;

    public FakeStudentDaoImpl() {
        database = new HashMap<>();
        UUID studentId1 = UUID.randomUUID();
        UUID studentId2 = UUID.randomUUID();
        database.put(studentId1, new Student(studentId1, 25, "Valera", "Popovich", "math"));
        database.put(studentId2, new Student(studentId2, 35, "Gena", "Ivanov", "chemistry"));
    }

    @Override
    public int insertNewStudent(UUID studentId, Student student) {
        database.put(studentId, student);
        return 1;
    }

    @Override
    public Student selectStudentById(UUID studentId) {
        return database.get(studentId);
    }

    @Override
    public List<Student> selectAllStudents() {
        return new ArrayList<>(database.values());
    }

    @Override
    public int updateStudentById(UUID studentId, Student studentUpdate) {
        database.put(studentId, studentUpdate);
        return 1;
    }

    @Override
    public int deleteStudentById(UUID studentId) {
        database.remove(studentId);
        return 1;
    }
}
