package com.entity;

import com.util.excel.annotation.ExcelField;

/**
 * 学生表 student
 * 
 * @author ruoyi
 * @date 2019-03-29
 */
public class Student
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private String id;
	/** 姓名 */
    @ExcelField(title = "姓名", type = 1, align = 1, fieldType = String.class, sort = 1)
	private String name;
	/** 年龄 */
    @ExcelField(title = "年龄", type = 1, align = 1, fieldType = String.class, sort = 2)
	private String age;
	/** 电话 */
	@ExcelField(title = "电话", type = 1, align = 1, fieldType = String.class, sort = 3)
	private String phone;

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setAge(String age) 
	{
		this.age = age;
	}

	public String getAge() 
	{
		return age;
	}
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	public String getPhone() 
	{
		return phone;
	}


}
