package com.yj.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 29029
 */
@Data
public class Teacher {
	private Integer id;
	
	private String teaName;
	
	private Integer age;
	
	private Integer sex;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createTime;

}
