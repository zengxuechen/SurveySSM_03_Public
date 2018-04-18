package com.atguigu.survey.model;

import java.util.List;

/**
 * 分页
 * @author zhangyu
 * @param <T>
 */
public class Page<T> {

	private int pageNo ; //当前页
	private int pageSize = 100 ; //每页数量
	private List<T> list ; //业务数据
	private int totalRecordNo ; //总记录
	private int totalPageNo ; //总页
	
	public Page(String pageNoStr , int totalRecordNo){
		
		//①计算总页
		//[1]给totalRecordNo 赋值
		this.totalRecordNo = totalRecordNo ;
		
		//[2]计算总页
		this.totalPageNo = (this.totalRecordNo / this.pageSize) + ((this.totalRecordNo % this.pageSize) == 0 ? 0 : 1) ;
		
		//②修正pageNo
		
		this.pageNo = 1 ;
		//尝试进行类型转换
		try {
			this.pageNo = Integer.parseInt(pageNoStr);
		} catch (Exception e) {}//如果类型转换失败，就使用默认值1
		
		
		//修正pageNo 在1~totalPageNo进行修正
		if(this.pageNo > this.totalPageNo){ //如果totalPageNo为0 ，那么，pageNo为0
			this.pageNo = this.totalPageNo ;
		}
		//注意这个判断在上面的判断之后（代码编写小技巧）
		if(this.pageNo < 1){ //如果pageNo为0,那么，就纠正为1
			this.pageNo = 1 ;
		}
		
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getPageNo() {
		return pageNo;
	}

	public int getTotalRecordNo() {
		return totalRecordNo;
	}

	public int getTotalPageNo() {
		return totalPageNo;
	}

	//--------------------
	//boolean类型的get方法一般是以is开头的。get方法都是无参数的。如果有参数就不称为get方法了。
	public boolean isHasPrev(){
		return this.pageNo > 1 ;
	}
	
	public boolean isHasNext(){
		return this.pageNo < this.totalPageNo ;
	}
	
	public int getPrev(){
		return this.getPageNo() - 1 ;
	}
	
	public int getNext(){
		return this.getPageNo() + 1 ;
	}
	
	public int getStartIndex(){
		return (pageNo-1)*pageSize ;
	}

	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", pageSize=" + pageSize + ", list="
				+ list + ", totalRecordNo=" + totalRecordNo + ", totalPageNo="
				+ totalPageNo + "]";
	}
	
}
