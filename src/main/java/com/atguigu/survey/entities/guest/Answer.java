package com.atguigu.survey.entities.guest;

import java.io.Serializable;

/**
 * 答案实体类
 * @author zhangyu
 *
 */
public class Answer implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer answerId; //答案id

	private String content; //答案内容(简答题,单选题,多选题)

	private String uuid; //区分是否属于同一次参与调查的答案

	private Integer questionId; //问题id

	private Integer surveyId; //调查id

	public Answer(Integer answerId, String content, String uuid,
			Integer questionId, Integer surveyId) {
		super();
		this.answerId = answerId;
		this.content = content;
		this.uuid = uuid;
		this.questionId = questionId;
		this.surveyId = surveyId;
	}

	public Answer() {
		super();
	}

	public Integer getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid == null ? null : uuid.trim();
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Integer getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Integer surveyId) {
		this.surveyId = surveyId;
	}
}