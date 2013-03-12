package com.icitic.avp.bean.hbm.pojo;

// Generated 2013-3-10 21:34:44 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * IcSysPara generated by hbm2java
 */
@Entity
@Table(name = "IC_SYS_PARA", schema = "AVPTXN")
public class IcSysPara implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1454487442418114857L;
	
	private String parameterIndex;
	private String parameterName;
	private String parameterValue;
	private String parameterDescription;
	private String parameterControl;

	public IcSysPara() {
	}

	public IcSysPara(String parameterIndex, String parameterName,
			String parameterValue, String parameterDescription,
			String parameterControl) {
		this.parameterIndex = parameterIndex;
		this.parameterName = parameterName;
		this.parameterValue = parameterValue;
		this.parameterDescription = parameterDescription;
		this.parameterControl = parameterControl;
	}

	@Id
	@Column(name = "PARAMETER_INDEX", unique = true, nullable = false, length = 6)
	public String getParameterIndex() {
		return this.parameterIndex;
	}

	public void setParameterIndex(String parameterIndex) {
		this.parameterIndex = parameterIndex;
	}

	@Column(name = "PARAMETER_NAME", nullable = false, length = 64)
	public String getParameterName() {
		return this.parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	@Column(name = "PARAMETER_VALUE", nullable = false, length = 254)
	public String getParameterValue() {
		return this.parameterValue;
	}

	public void setParameterValue(String parameterValue) {
		this.parameterValue = parameterValue;
	}

	@Column(name = "PARAMETER_DESCRIPTION", nullable = false, length = 64)
	public String getParameterDescription() {
		return this.parameterDescription;
	}

	public void setParameterDescription(String parameterDescription) {
		this.parameterDescription = parameterDescription;
	}

	@Column(name = "PARAMETER_CONTROL", nullable = false, length = 8)
	public String getParameterControl() {
		return this.parameterControl;
	}

	public void setParameterControl(String parameterControl) {
		this.parameterControl = parameterControl;
	}

}
