package com.student_binarytree.student_binarytree.controller.dto;

import com.student_binarytree.student_binarytree.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentGradeDTO{
    private Student student;
    private int grade;
}
