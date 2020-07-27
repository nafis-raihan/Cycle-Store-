package project;



public class Cycle {

	private String brandname;
	private String modelname;
	private String category;
	private String price;
	
	
	public Cycle(){
		
	}
	
	
	
	
	public Cycle(String brandname, String modelname, String category, String price) {
		super();
		this.modelname = modelname;
		this.brandname = brandname;
		this.price = price;
		this.category = category;
	}



	
	public String getModelname() {
		return modelname;
	}


	public void setModelname(String modelname) {
		this.modelname = modelname;
	}


	public String getBrandname() {
		return brandname;
	}


	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}


	


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}

	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}
	
	public String toString() {
		return "Cycle [Brandname=" + brandname + ", modelname=" + modelname + ", category=" + category + ", price="
				+ price + "]";
	}
	
	
	
	
	
	
	
}
