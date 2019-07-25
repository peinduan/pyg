package entity;

import java.io.Serializable;
import java.util.List;

import com.pinyougou.pojo.TbBrand;

/**
 * 分页对象
 * @author DarryRing
 *
 */
public class PageResults implements Serializable{
	
	private List rows;
	private long total;
	
	
	public PageResults(long total,List rows) {
		super();
		this.rows = rows;
		this.total = total;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	
	
	
}
