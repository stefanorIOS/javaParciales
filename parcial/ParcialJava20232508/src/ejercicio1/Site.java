package ejercicio1;

import java.util.LinkedList;

abstract class Site {
	int id;
	double outgoingTransferMB;
	double storageUsageMb;
	Hosting host;
	
	public abstract double costSite();
	
	public double devStorageUsageMb(){
		return (this.storageUsageMb);
	}
	
	public double devOutgoingTransferMb(){
		return this.outgoingTransferMB;
	}
	
	class DevelopedSite extends Site{
		double hostingDiscountPercentage;
		double developmentCost;
		
		@Override
		public double costSite(){
			double importe = 0;
			importe = host.hostingAmount() + this.developmentCost + this.hostingDiscountPercentage;
			return importe;
		}
	}
	
	
	
	class HostedSite extends Site{
		double maxSuportedHs;
		double minimumCost;
		
		@Override
		public double costSite() {
			double importe = 0;
			importe = host.hostingAmount();
			if (importe < this.minimumCost) {
				return importe;
			}
			else {
				return this.minimumCost;
			}
		}
		
		
	}
}

class Cliente{
	int id;
	String firstName;
	String lastName;
	String email;
	String phone;
	LinkedList<Site>sitiosClientes = new LinkedList<Site>();
	
	
	//getBill -> La facturación de un cliente se calcula como la sumatoria de todas las facturaciones de sus sitios.
	
	public double getBill(){
		double finalCost=0;
		for(Site s:sitiosClientes) {
			finalCost = finalCost + s.costSite();
		}
		return finalCost;
	}
}
	
abstract class Hosting{
	boolean useCDN;
	boolean useVPN;
	LinkedList<Site> sites = new LinkedList<Site>();
	
	public boolean devUseCDN(){
		return this.useCDN;
	}
	
	public boolean devUseVPN(){
		return (this.useVPN);
	}
	
	public abstract double hostingAmount();
	
	
	
}

class FixedPriceHosting extends Hosting{
	double fixedPrice;
	
	@Override
	public double hostingAmount() {
		return this.fixedPrice;
	}
	
}

class OnDemandHosting extends Hosting{
	double pricePerMbTransfered;
	double StoragePricePerMb;
	
	@Override
	public double hostingAmount() {
		
		double cost = 0;
		double totalCost=0;
		
		if(this.devUseCDN()==true) {
			totalCost = this.transferCost() * 2;
		}
		else {
			totalCost = this.transferCost();
		}
		
		if(this.useVPN==true) {
		totalCost = (this.storageCoast() + totalCost) + ( 140 * (this.storageCoast() + totalCost) / 100);
		}
		
		else {
			totalCost = (this.storageCoast() + totalCost);
		}
		
		return totalCost;
	}
	
	public double storageCoast(){
		double c = 0;
		for (Site s : sites) {
			c = c + s.devStorageUsageMb();
		}
		return ((c+this.StoragePricePerMb));
	}
	
	public double transferCost() {
		double c = 0;
		for (Site s:sites) {
			c = c * s.devOutgoingTransferMb();
		}
		return (c * this.pricePerMbTransfered);
	}
	
	
}
	

