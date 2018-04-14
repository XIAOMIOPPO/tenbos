package com.yidu.tencloud.bean.taketosend.pack;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class UserPack implements Serializable {

	/**
	 * 包装实体类
	 */
	private static final long serialVersionUID = -2369894200058409964L;

	private String packId;
	private String workSheetNo;
	private String description;
	private int metHod;
	private String pacKage;
	private String enpId;
	private Date taskTime;
	private String folder;
	private String outId;
	private Date ruKushi;
	private String clieId;
	private BigDecimal packAges;
	private BigDecimal wegeht;
	private BigDecimal gedweight;
	private String volume;
	private BigDecimal expenses;
	
	
	public UserPack(String packId, String workSheetNo, String description, int metHod, String pacKage, String enpId,
			Date taskTime, String folder, String outId, Date ruKushi, String clieId, BigDecimal packAges,
			BigDecimal wegeht, BigDecimal gedweight, String volume, BigDecimal expenses) {
		super();
		this.packId = packId;
		this.workSheetNo = workSheetNo;
		this.description = description;
		this.metHod = metHod;
		this.pacKage = pacKage;
		this.enpId = enpId;
		this.taskTime = taskTime;
		this.folder = folder;
		this.outId = outId;
		this.ruKushi = ruKushi;
		this.clieId = clieId;
		this.packAges = packAges;
		this.wegeht = wegeht;
		this.gedweight = gedweight;
		this.volume = volume;
		this.expenses = expenses;
	}

	@Override
	public String toString() {
		return "UserPack [packId=" + packId + ", workSheetNo=" + workSheetNo + ", description=" + description + ", metHod=" + metHod
				+ ", pacKage=" + pacKage + ", enpId=" + enpId + ", taskTime=" + taskTime + ", folder=" + folder
				+ ", outId=" + outId + ", ruKushi=" + ruKushi + ", clieId=" + clieId + ", packAges=" + packAges
				+ ", wegeht=" + wegeht + ", gedweight=" + gedweight + ", volume=" + volume + ", expenses=" + expenses
				+ "]";
	}

	public String getPackId() {
		return packId;
	}

	public void setPackId(String packId) {
		this.packId = packId;
	}

	public String getworkSheetNo() {
		return workSheetNo;
	}

	public void setworkSheetNo(String workSheetNo) {
		this.workSheetNo = workSheetNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMetHod() {
		return metHod;
	}

	public void setMetHod(int metHod) {
		this.metHod = metHod;
	}

	public String getPacKage() {
		return pacKage;
	}

	public void setPacKage(String pacKage) {
		this.pacKage = pacKage;
	}

	public String getEnpId() {
		return enpId;
	}

	public void setEnpId(String enpId) {
		this.enpId = enpId;
	}

	public Date getTaskTime() {
		return taskTime;
	}

	public void setTaskTime(Date taskTime) {
		this.taskTime = taskTime;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public String getOutId() {
		return outId;
	}

	public void setOutId(String outId) {
		this.outId = outId;
	}

	public Date getRuKushi() {
		return ruKushi;
	}

	public void setRuKushi(Date ruKushi) {
		this.ruKushi = ruKushi;
	}

	public String getClieId() {
		return clieId;
	}

	public void setClieId(String clieId) {
		this.clieId = clieId;
	}

	public BigDecimal getPackAges() {
		return packAges;
	}

	public void setPackAges(BigDecimal packAges) {
		this.packAges = packAges;
	}

	public BigDecimal getWegeht() {
		return wegeht;
	}

	public void setWegeht(BigDecimal wegeht) {
		this.wegeht = wegeht;
	}

	public BigDecimal getGedweight() {
		return gedweight;
	}

	public void setGedweight(BigDecimal gedweight) {
		this.gedweight = gedweight;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public BigDecimal getExpenses() {
		return expenses;
	}

	public void setExpenses(BigDecimal expenses) {
		this.expenses = expenses;
	}

	
	public UserPack() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clieId == null) ? 0 : clieId.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((enpId == null) ? 0 : enpId.hashCode());
		result = prime * result + ((expenses == null) ? 0 : expenses.hashCode());
		result = prime * result + ((folder == null) ? 0 : folder.hashCode());
		result = prime * result + ((gedweight == null) ? 0 : gedweight.hashCode());
		result = prime * result + metHod;
		result = prime * result + ((workSheetNo == null) ? 0 : workSheetNo.hashCode());
		result = prime * result + ((outId == null) ? 0 : outId.hashCode());
		result = prime * result + ((pacKage == null) ? 0 : pacKage.hashCode());
		result = prime * result + ((packAges == null) ? 0 : packAges.hashCode());
		result = prime * result + ((packId == null) ? 0 : packId.hashCode());
		result = prime * result + ((ruKushi == null) ? 0 : ruKushi.hashCode());
		result = prime * result + ((taskTime == null) ? 0 : taskTime.hashCode());
		result = prime * result + ((volume == null) ? 0 : volume.hashCode());
		result = prime * result + ((wegeht == null) ? 0 : wegeht.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		UserPack other = (UserPack) obj;
		if (clieId == null) {
			if (other.clieId != null) {
				return false;
			}
		} else if (!clieId.equals(other.clieId)) {
			return false;
		}
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (enpId == null) {
			if (other.enpId != null) {
				return false;
			}
		} else if (!enpId.equals(other.enpId)) {
			return false;
		}
		if (expenses == null) {
			if (other.expenses != null) {
				return false;
			}
		} else if (!expenses.equals(other.expenses)) {
			return false;
		}
		if (folder == null) {
			if (other.folder != null) {
				return false;
			}
		} else if (!folder.equals(other.folder)) {
			return false;
		}
		if (gedweight == null) {
			if (other.gedweight != null) {
				return false;
			}
		} else if (!gedweight.equals(other.gedweight)) {
			return false;
		}
		if (metHod != other.metHod) {
			return false;
		}
		if (workSheetNo == null) {
			if (other.workSheetNo != null) {
				return false;
			}
		} else if (!workSheetNo.equals(other.workSheetNo)) {
			return false;
		}
		if (outId == null) {
			if (other.outId != null) {
				return false;
			}
		} else if (!outId.equals(other.outId)) {
			return false;
		}
		if (pacKage == null) {
			if (other.pacKage != null) {
				return false;
			}
		} else if (!pacKage.equals(other.pacKage)) {
			return false;
		}
		if (packAges == null) {
			if (other.packAges != null) {
				return false;
			}
		} else if (!packAges.equals(other.packAges)) {
			return false;
		}
		if (packId == null) {
			if (other.packId != null) {
				return false;
			}
		} else if (!packId.equals(other.packId)) {
			return false;
		}
		if (ruKushi == null) {
			if (other.ruKushi != null) {
				return false;
			}
		} else if (!ruKushi.equals(other.ruKushi)) {
			return false;
		}
		if (taskTime == null) {
			if (other.taskTime != null) {
				return false;
			}
		} else if (!taskTime.equals(other.taskTime)) {
			return false;
		}
		if (volume == null) {
			if (other.volume != null) {
				return false;
			}
		} else if (!volume.equals(other.volume)) {
			return false;
		}
		if (wegeht == null) {
			if (other.wegeht != null) {
				return false;
			}
		} else if (!wegeht.equals(other.wegeht)) {
			return false;
		}
		return true;
	}
	
	
	
}
