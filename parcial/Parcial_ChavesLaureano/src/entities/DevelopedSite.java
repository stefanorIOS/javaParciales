package entities;

public class DevelopedSite extends Site{
	
	private double hostingDiscountPercentage;
	private double developmentCost;
	
	
	public double getHostingDiscountPercentage() {
		return hostingDiscountPercentage;
	}
	
	public double getDevelopmentCost() {
		return developmentCost;
	}

	@Override
	public double getFacturacion() {
		
		return this.getValorHosting()*hostingDiscountPercentage/100+developmentCost;
	}
	
	
	

}
