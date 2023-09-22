package entities;

public class HostedSite extends Site {

	private double maxSupportHs;
	private double minimunCost;
	
	public double getMaxSupportHs() {
		return maxSupportHs;
	}
	
	public double getMinimunCost() {
		return minimunCost;
	}

	@Override
	public double getFacturacion() {
		
		double valor = this.getValorHosting();
		
		if(valor < minimunCost) {
			return minimunCost;
		}
		return valor;
	}
	
	
}
