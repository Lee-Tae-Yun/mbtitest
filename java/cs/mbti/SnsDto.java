package cs.mbti;

public class SnsDto {
	private String sid; //메시지번호 
	private String fid; //보내는사람 아이디 
	private String tid; //받는사람 아이디 
	private String stitle; //제목 
	private String content; //내용 
	private int readcheck; //읽음 확인 
	private String sdate; //보낸시간 
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getStitle() {
		return stitle;
	}
	public void setStitle(String stitle) {
		this.stitle = stitle;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadcheck() {
		return readcheck;
	}
	public void setReadcheck(int readcheck) {
		this.readcheck = readcheck;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	
	public SnsDto(String sid,String fid, String tid, String stitle, String content, int readcheck, String sdate) {
		this.setSid(sid);
		this.setFid(fid);
		this.setTid(tid);
		this.setStitle(stitle);
		this.setContent(content);
		this.setReadcheck(readcheck);
		this.setSdate(sdate);
	}
	public SnsDto() {}
	}
