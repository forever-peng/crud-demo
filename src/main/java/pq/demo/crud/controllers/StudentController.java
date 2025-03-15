package pq.demo.crud.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pq.demo.crud.dao.StudentMapper;
import pq.demo.crud.dto.PaginationRequest;
import pq.demo.crud.dto.ServiceResponse;
import pq.demo.crud.dto.StudentDto;
import pq.demo.crud.entities.Student;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("student")
public class StudentController
{
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 根据可选参数获取表中的数据
     *
     * @param request
     * @return
     */
    @GetMapping("all")
    public ServiceResponse<List<Student>> getAllStudents(@ModelAttribute PaginationRequest request)
    {
        List<Student> students = studentMapper.getAllStudents(request.getPageSize(), (request.getPageIndex() - 1) * request.getPageSize());
        return ServiceResponse.buildSuccessResponse(students);
    }

    /**
     * 根据id获取表中的数据
     *
     * @param id
     * @return
     */
    @GetMapping("get")
    public ServiceResponse<Student> getStudentById(@RequestParam("id") long id)
    {
        Student student = studentMapper.getStudentById(id);
        return ServiceResponse.buildSuccessResponse(student);
    }

    /**
     * 根据id修改已经存在的数据
     *
     * @param studentDto
     * @return
     */
    @PutMapping("update")
    public ServiceResponse<Long> updateStudentById(@RequestBody StudentDto studentDto)
    {
        long l = studentMapper.updateById(studentDto);
        return ServiceResponse.buildSuccessResponse(l);
    }

    /**
     * 根据id删除一条数据
     *
     * @param id
     * @return
     */
    @DeleteMapping("delete")
    public ServiceResponse<Long> deleteStudentById(@RequestParam("id") long id)
    {
        long l = studentMapper.deleteById(id);
        return ServiceResponse.buildSuccessResponse(l);
    }

    /**
     * 新增一条数据
     *
     * @param student
     * @return
     */
    @PostMapping("add")
    public ServiceResponse<Long> addStudent(@RequestBody StudentDto student)
    {
        long l = studentMapper.addStudent(student);
        return ServiceResponse.buildSuccessResponse(l);
    }
}
