package com.service;

import com.alibaba.fastjson.JSONObject;
import com.entity.Student;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 学生 服务层
 * 
 * @author ruoyi
 * @date 2019-03-29
 */
public interface IStudentService 
{
	/**
     * 查询学生信息
     * 
     * @param id 学生ID
     * @return 学生信息
     */
	public Student selectStudentById(Integer id);
	
	/**
     * 查询学生列表
     * 
     * @param student 学生信息
     * @return 学生集合
     */
	public List<Student> selectStudentList(Student student);
	
	/**
     * 新增学生
     * 
     * @param students 学生信息
     * @return 结果
     */
	public int insertStudent( List<JSONObject> students);
	
	/**
     * 修改学生
     * 
     * @param student 学生信息
     * @return 结果
     */
	public int updateStudent(Student student);
		
	/**
     * 删除学生信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteStudentByIds(String ids);

    void downloadExcel(HttpServletResponse response);

}
