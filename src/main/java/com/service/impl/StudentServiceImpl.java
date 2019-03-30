package com.service.impl;

import java.io.IOException;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dao.StudentMapper;
import com.entity.Student;
import com.service.IStudentService;
import com.util.excel.ExportExcel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;

/**
 * 学生 服务层实现
 *
 * @author ruoyi
 * @date 2019-03-29
 */
@Service
public class StudentServiceImpl implements IStudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 查询学生信息
     *
     * @param id 学生ID
     * @return 学生信息
     */
    @Override
    public Student selectStudentById(Integer id) {
        return studentMapper.selectStudentById(id);
    }

    /**
     * 查询学生列表
     *
     * @param student 学生信息
     * @return 学生集合
     */
    @Override
    public List<Student> selectStudentList(Student student) {
        return studentMapper.selectStudentList(student);
    }

    /**
     * 新增学生
     *
     * @param students 学生信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insertStudent(List<JSONObject> students) {
        List<Student> studentList = JSONArray.parseArray(students.toString(), Student.class);
        int i = 0;
        for (Student student : studentList) {
            i += studentMapper.insertStudent(student);
        }

        return i < students.size() ? 0 : 1;
    }

    /**
     * 修改学生
     *
     * @param student 学生信息
     * @return 结果
     */
    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    /**
     * 删除学生对象
     *
     * @param id 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteStudentByIds(String id) {
        return studentMapper.deleteStudentById(id);
    }

    @Override
    public void downloadExcel(HttpServletResponse response) {
        Student student = new Student();
        List<Student>Students=studentMapper.selectStudentList(student);
        try {
            new ExportExcel("学生信息", Student.class).setDataList(Students).write(response,  "学生信息.xlsx").dispose();
        } catch (IOException e) {
            logger.info("导出失败");
        }
    }
}
