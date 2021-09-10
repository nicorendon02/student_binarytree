package com.student_binarytree.student_binarytree.controller;

import com.student_binarytree.student_binarytree.exception.BinaryTreeException;
import com.student_binarytree.student_binarytree.exception.DataNotFoundException;
import com.student_binarytree.student_binarytree.model.Student;
import com.student_binarytree.student_binarytree.model.Node;
import com.student_binarytree.student_binarytree.service.BinaryTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Path;
import javax.validation.Valid;

// Using Lombok Annotations...
@RestController
@RequestMapping(path = "binarytree")
@Validated
public class BinaryTreeController {

    @Autowired
    private BinaryTreeService binaryTreeService;

    @PostMapping("/add")
    public @ResponseBody
    ResponseEntity<?> addStudent(@Valid @RequestBody Student student) throws BinaryTreeException {
        return binaryTreeService.addStudent(student);
    }

    @GetMapping("/preorder")
    public @ResponseBody
    ResponseEntity<?> listStudentsPreOrder() throws DataNotFoundException {
        return binaryTreeService.listStudents(1);
    }

    @GetMapping("/inorder")
    public @ResponseBody
    ResponseEntity<?> listStudentsInOrder() throws DataNotFoundException {
        return binaryTreeService.listStudents(2);
    }

    @GetMapping("/postorder")
    public @ResponseBody
    ResponseEntity<?> listStudentsPostOrder() throws DataNotFoundException {
        return binaryTreeService.listStudents(3);
    }

    @GetMapping("/count")
    public @ResponseBody
    ResponseEntity<?> countBinaryTree() throws DataNotFoundException {
        return binaryTreeService.count();
    }

    @GetMapping("/listEndEqualNum/{number}")
    public @ResponseBody
    ResponseEntity<?> listEndEqualNum(@PathVariable int number) throws DataNotFoundException {
        return binaryTreeService.listEndEqualNum(number);
    }

    @GetMapping("/countEndEqualNum/{number}")
    public @ResponseBody
    ResponseEntity<?> countEndEqualNum(@PathVariable int number) throws DataNotFoundException {
        return binaryTreeService.countEndEqualNum(number);
    }

    @GetMapping("/getLeaves")
    public @ResponseBody
    ResponseEntity<?> getLeaves() throws DataNotFoundException {
        return binaryTreeService.getLeaves();
    }

    // prune the existing Leaves in the Tree
    @GetMapping("/prune")
    public @ResponseBody
    ResponseEntity<?> prune() throws DataNotFoundException {
        return binaryTreeService.prune();
    }

    // calculate Tree Grade
    @GetMapping("/treeGrade")
    public @ResponseBody
    ResponseEntity<?> calculateTreeGrade() throws DataNotFoundException {
        return binaryTreeService.calculateTreeGrade();
    }

    // get All Boys Grade
    @GetMapping("/studentsGrade")
    public @ResponseBody
    ResponseEntity<?> getStudentsGrade() throws DataNotFoundException {
        return binaryTreeService.getStudentsGrade();
    }

    // get Boys by Level
    @GetMapping("/studentsByLevel/{level}")
    public @ResponseBody
    ResponseEntity<?> getStudentsByLevel(@PathVariable int level) throws DataNotFoundException, BinaryTreeException {
        return binaryTreeService.getStudentsByLevel(level);
    }

    // get Boys that end in a certain number and are Leaves
    @GetMapping("/equalAndLeaf/{number}")
    public @ResponseBody
    ResponseEntity<?> isEqualAndLeaf(@PathVariable int number) throws DataNotFoundException {
        return binaryTreeService.isEqualAndLeaf(number);
    }
}
