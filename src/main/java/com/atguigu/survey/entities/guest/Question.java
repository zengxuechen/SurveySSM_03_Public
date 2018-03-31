package com.atguigu.survey.entities.guest;

import java.io.Serializable;

import com.atguigu.survey.utils.DataProcessUtils;

/**
 * 问题实体类
 * @author zhangyu
 *
 */
public class Question implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer questionId; //问题id

	private String questionName; //问题名称

	private Integer questionType; //问题类型:0-单选,1-多选,2-简答

	private String options; //问题选项(单选和多选)

	private Integer bagId;  //包裹id

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName == null ? null : questionName.trim();
	}

	public Integer getQuestionType() {
		return questionType;
	}

	public void setQuestionType(Integer questionType) {
		this.questionType = questionType;
	}

	public String getOptions() {
		return options;
	}

	//==============设置特殊操作-开始===================================
	public void setOptions(String options) {
		if(this.options==null){
			this.options = "";
		}
		//1.先将所有的换行替换为逗号
		String temp = options.replaceAll("\r\n",",");
		
		//2.在循环中将连着的两个逗号替换为一个逗号
		while(temp.contains(",,")){
			temp = temp.replaceAll(",,",",");
		}
		//3.去掉字符串中前后有可能出现的逗号
		temp = DataProcessUtils.removeComma(temp,","); //专业祛痘的方法，免费的哦
		
		this.options = temp ;
	}
	
	public String getOptionsForEdit(){ //${question.optionsForEdit}
		if(this.options==null){
			return "" ;
		}
		return this.options.replace(",", "\r\n");
	}
	
	public String[] getOptionsArr(){
		if(this.options==null){
			return null ;
		}
		return this.options.split(",");
	}
	//==============设置特殊操作-结束===================================

	public Integer getBagId() {
		return bagId;
	}

	public void setBagId(Integer bagId) {
		this.bagId = bagId;
	}

}