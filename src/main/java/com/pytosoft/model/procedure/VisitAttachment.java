package com.pytosoft.model.procedure;

import java.io.Serializable;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.pytosoft.model.Visit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "visit_attachment")
public class VisitAttachment implements Serializable
{

	private static final long serialVersionUID = -4942509008014431016L;

	public static final String VISIT = "visit";

	public static final String CAPTUREON = "captureOn";

	public static final String PROCEDURE = "procedure";

	private Long id;

	// @NotBlank(message = "{visitattachment.title.notBlank}")
	@Size(max = 100, message = "{visitattachment.title.size}")
	private String title;

	// @NotBlank(message = "{visitattachment.filePath.notBlank}")
	@Size(max = 300, message = "{visitattachment.filePath.size}")
	private String filePath;

	@NotBlank(message = "{visitattachment.filePath.notBlank}")
	@Size(max = 100, message = "{visitattachment.filePath.size}")
	private String fileName;

	// @NotNull(message = "{visitattachment.captureOn.notNull}")
	private Date captureOn;

//	@NotHtml(message = "{visitattachment.notes.notHtml}")
	@Size(max = 255, message = "{visitattachment.notes.size}")
	private String notes;

//	@Valid
//	private Visit visit;
	
//	@Valid
//	private Procedure procedure;

	public VisitAttachment()
	{
	}

	public VisitAttachment(Long id)
	{
		super();
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

//	@ManyToOne(optional = true)
//	@JoinColumn(name = "visit_Id", referencedColumnName = "Id")
//	public Visit getVisit()
//	{
//		return visit;
//	}
//
//	public void setVisit(Visit visit)
//	{
//		this.visit = visit;
//	}
//	
//	@ManyToOne(optional = true)
//	@JoinColumn(name = "Procedure_Id", referencedColumnName = "Id")
//	public Procedure getProcedure() {
//		return procedure;
//	}
//
//	public void setProcedure(Procedure procedure) {
//		this.procedure = procedure;
//	}

	@Column(name = "Title", length = 100, nullable = false)
	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getFilePath()
	{
		return filePath;
	}

	@Column(name = "File_Path", length = 300, nullable = false)
	public void setFilePath(String filePath)
	{
		this.filePath = filePath;
	}

	@Column(name = "File_Name", length = 100, nullable = false)
	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	@Column(name = "Capture_On", nullable = false)
	public Date getCaptureOn()
	{
		return captureOn;
	}

	public void setCaptureOn(Date captureOn)
	{
		this.captureOn = captureOn;
	}

	@Column(name = "notes", length = 255, nullable = false)
	public String getNotes()
	{
		return notes;
	}

	public void setNotes(String notes)
	{
		this.notes = notes;
	}

}