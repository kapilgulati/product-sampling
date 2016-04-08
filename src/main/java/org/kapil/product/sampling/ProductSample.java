package org.kapil.product.sampling;

import java.util.Date;

public class ProductSample implements Comparable<ProductSample> {
	private Date sampleDate;
	private Long sampleId;
	private boolean selected;
	
	
	public ProductSample() {
		super();
	}


	public ProductSample(Date sampleDate, Long sampleId, boolean selected) {
		super();
		this.sampleDate = sampleDate;
		this.sampleId = sampleId;
		this.selected = selected;
	}


	public Date getSampleDate() {
		return sampleDate;
	}


	public void setSampleDate(Date sampleDate) {
		this.sampleDate = sampleDate;
	}


	public Long getSampleId() {
		return sampleId;
	}


	public void setSampleId(Long sampleId) {
		this.sampleId = sampleId;
	}


	public boolean isSelected() {
		return selected;
	}


	public void setSelected(boolean selected) {
		this.selected = selected;
	}


	public int compareTo(ProductSample o) {
		if(o == null || o.getSampleDate()==null || o.getSampleId() == null) return 1;
		if(this.getSampleDate()==null || this.getSampleId() == null) return -1;
		if(o.getSampleDate().equals(this.getSampleDate())){
			return o.getSampleId().compareTo(this.getSampleId());
		}else{
			return o.getSampleDate().compareTo(this.getSampleDate());
		}
		
	}

	

}
