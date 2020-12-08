package Dto;

public class BoardInfoBean {
	private int Num;
	private String Writer;
	private String Password;
	private String Title;
	private String Content;
	private String Date;
	private int Thumbs;
	private String File;
	private String WriterId;
	private String reply;
	private String ID;
	

	public int getThumbs() {
		return Thumbs;
	}
	public void setThumbs(int thumbs) {
		Thumbs = thumbs;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}

	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}

	@Override
	public String toString() {
		return "BoardInfoBean [Num=" + Num + ", Writer=" + Writer + ", Password=" + Password + ", Title=" + Title
				+ ", Content=" + Content + ", Date=" + Date + ", Thumbs=" + Thumbs + ", File=" + File + ", WriterId="
				+ WriterId + "]";
	}
	public String getWriterId() {
		return WriterId;
	}
	public void setWriterId(String writerId) {
		WriterId = writerId;
	}
	public int getNum() {
		return Num;
	}
	public void setNum(int num) {
		Num = num;
	}
	public String getWriter() {
		return Writer;
	}
	public void setWriter(String writer) {
		Writer = writer;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	
	public String getFile() {
		return File;
	}
	public void setFile(String file) {
		File = file;
	}
	
	
}
