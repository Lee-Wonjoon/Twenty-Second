package fp.CS.models.vo;

import java.sql.Date;

public class Question {
	private int questionNo;
	private String questionTitle;
	private String questionWriter;
	private String questionContent;
	private Date questionDate;
	private String filename;
	private String filepath;
	private int questionLevel;
	private int questionRel;
	private String questionStatus;
	
	
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Question(int questionNo, String questionTitle, String questionWriter, String questionContent, Date questionDate, String filename,
			String filepath, int questionLevel, int questionRel, String questionStatus) {
		super();
		this.questionNo = questionNo;
		this.questionTitle = questionTitle;
		this.questionWriter = questionWriter;
		this.questionContent = questionContent;
		this.questionDate = questionDate;
		this.filename = filename;
		this.filepath = filepath;
		this.questionLevel = questionLevel;
		this.questionRel = questionRel;
		this.questionStatus = questionStatus;
	}
	public String getQuestionStatus() {
		return questionStatus;
	}
	public void setQuestionStatus(String questionStatus) {
		this.questionStatus = questionStatus;
	}
	public int getQuestionNo() {
		return questionNo;
	}
	public void setQuestionNo(int qustionNo) {
		this.questionNo = qustionNo;
	}
	public String getQuestionWriter() {
		return questionWriter;
	}
	public void setQuestionWriter(String questionWriter) {
		this.questionWriter = questionWriter;
	}
	public String getQuestionContent() {
		return questionContent;
	}
	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}
	public Date getQuestionDate() {
		return questionDate;
	}
	public void setQuestionDate(Date questionDate) {
		this.questionDate = questionDate;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public int getQuestionLevel() {
		return questionLevel;
	}
	public void setQuestionLevel(int questionLevel) {
		this.questionLevel = questionLevel;
	}
	public int getQuestionRel() {
		return questionRel;
	}
	public void setQuestionRel(int questionRel) {
		this.questionRel = questionRel;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	
}
