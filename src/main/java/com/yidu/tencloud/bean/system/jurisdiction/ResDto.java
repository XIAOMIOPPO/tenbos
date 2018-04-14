package com.yidu.tencloud.bean.system.jurisdiction;

import java.util.List;
/**
 * 树传输层
 * @author youngboy
 * @since 2017/12/19
 */
public class ResDto {

	/**
	 * id值
	 */
	private String id;
	
	/**
	 * 文本
	 */
	private String Text;
	
	
	/**
	 * 子节点
	 */
	private List<ResDto> nodes;
	
	

	public List<ResDto> getNodes() {
		return nodes;
	}

	public void setNodes(List<ResDto> nodes) {
		this.nodes = nodes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return Text;
	}

	public void setText(String text) {
		Text = text;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Text == null) ? 0 : Text.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nodes == null) ? 0 : nodes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResDto other = (ResDto) obj;
		if (Text == null) {
			if (other.Text != null)
				return false;
		} else if (!Text.equals(other.Text))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nodes == null) {
			if (other.nodes != null)
				return false;
		} else if (!nodes.equals(other.nodes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ResDto [id=" + id + ", Text=" + Text + ", nodes=" + nodes + "]";
	}

	
	
	
	
}
