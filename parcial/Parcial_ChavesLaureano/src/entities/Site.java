package entities;

public abstract class Site {

	private int id;
	private double outGoingTransferMB;
	private double storageUsageMB;
	private Client cliente;
	private Hosting hosting;
	
	public int getId() {
		return id;
	}
	
	public double getOutGoingTransferMB() {
		return outGoingTransferMB;
	}
	
	public double getStorageUsageMB() {
		return storageUsageMB;
	}
	
	public abstract double getFacturacion();
	
	public double getValorHosting() {
		
		if (hosting instanceof FixedPriceHosting) {
			return ((FixedPriceHosting) hosting).getFixedPrice();
		}
		
		if(hosting instanceof OnDemandHosting) {
			double priceTransfered = ((OnDemandHosting) hosting).getPricePerMBTransfered();
			double storagePrice = ((OnDemandHosting) hosting).getStoragePricePerMB();
			
			double transferCost = priceTransfered*this.getOutGoingTransferMB(); 
			double storageCost = storagePrice*this.getStorageUsageMB();
			
			double costo = transferCost + storageCost;
			
			
			if(hosting.isUsesCdn()) {
				costo += transferCost; //doble de los mb
			}
			
			if(hosting.isUsesVps()) {
				costo = costo*1.4;
			}
			
			return costo;
			
			
		}
		
		return 0;
		
	}
	

}
