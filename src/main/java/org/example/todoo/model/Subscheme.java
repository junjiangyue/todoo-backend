package org.example.todoo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import lombok.Data;


@Entity
@Table ( name ="subscheme" )
@Data
public class Subscheme  implements Serializable {

	private static final long serialVersionUID =  7377969206920655175L;

	@Id
   	@Column(name = "sub_task_id")
	private Long subTaskId;

   	@Column(name = "father_id")
	private Long fatherId;

	public Long getSubTaskId() {
		return subTaskId;
	}

	public void setSubTaskId(Long subTaskId) {
		this.subTaskId = subTaskId;
	}

	public Long getFatherId() {
		return fatherId;
	}

	public void setFatherId(Long fatherId) {
		this.fatherId = fatherId;
	}
}
