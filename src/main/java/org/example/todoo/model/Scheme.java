package org.example.todoo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import lombok.Data;
import java.util.Date;



@Entity
@Table ( name ="scheme" )
@Data
public class Scheme  implements Serializable {

	private static final long serialVersionUID =  109906975486729805L;

	@Id
   	@Column(name = "scheme_id")
	private Long schemeId;

   	@Column(name = "scheme_title")
	private String schemeTitle;

   	@Column(name = "scheme_description")
	private String schemeDescription;

   	@Column(name = "scheme_start_time")
	private Date schemeStartTime;

   	@Column(name = "scheme_end_time")
	private Date schemeEndTime;

   	@Column(name = "scheme_date")
	private Date schemeDate;

   	@Column(name = "priority")
	private String priority;

   	@Column(name = "state")
	private String state;

   	@Column(name = "tag_name")
	private String tagName;

   	@Column(name = "repetition")
	private Long repetition;

   	@Column(name = "repetition_scope")
	private String repetitionScope;

   	@Column(name = "user_id")
	private Long userId;

	public Long getSchemeId() {
		return schemeId;
	}

	public void setSchemeId(Long schemeId) {
		this.schemeId = schemeId;
	}

	public String getSchemeTitle() {
		return schemeTitle;
	}

	public void setSchemeTitle(String schemeTitle) {
		this.schemeTitle = schemeTitle;
	}

	public String getSchemeDescription() {
		return schemeDescription;
	}

	public void setSchemeDescription(String schemeDescription) {
		this.schemeDescription = schemeDescription;
	}

	public Date getSchemeStartTime() {
		return schemeStartTime;
	}

	public void setSchemeStartTime(Date schemeStartTime) {
		this.schemeStartTime = schemeStartTime;
	}

	public Date getSchemeEndTime() {
		return schemeEndTime;
	}

	public void setSchemeEndTime(Date schemeEndTime) {
		this.schemeEndTime = schemeEndTime;
	}

	public Date getSchemeDate() {
		return schemeDate;
	}

	public void setSchemeDate(Date schemeDate) {
		this.schemeDate = schemeDate;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Long getRepetition() {
		return repetition;
	}

	public void setRepetition(Long repetition) {
		this.repetition = repetition;
	}

	public String getRepetitionScope() {
		return repetitionScope;
	}

	public void setRepetitionScope(String repetitionScope) {
		this.repetitionScope = repetitionScope;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
