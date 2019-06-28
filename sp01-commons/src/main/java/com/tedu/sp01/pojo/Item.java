package com.tedu.sp01.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
	//编号
	private Integer id;
	//名称
	private String name;
	//商品编码
	private Integer number;
}
