package prueba;

import java.util.List;

public abstract class Promocion extends Oferta{
	protected List<Oferta> atracciones;
	protected int costoOriginal;
	protected int valor;
	
	protected Promocion(List<Oferta> atracciones, int valor) {
		super();
		this.valor = valor;
		this.atracciones = atracciones;
		this.costoOriginal = calcularCostoOriginal();
		this.costo = calcularCosto();
		this.tiempo = calcularTiempo();
		this.tipo = calcularTipoDeAtraccion();
	}
	
	protected abstract int calcularCosto();
	
	private int calcularCostoOriginal() {
		int costoOriginal = 0;
		for(Oferta a : this.atracciones) {
			costoOriginal += a.getCosto();
		}
		return costoOriginal;
	}
	
	private double calcularTiempo() {
		double tiempoTotal = 0;
		for(Oferta a : this.atracciones) {
			tiempoTotal += a.getTiempo();
		}
		return tiempoTotal;
	}
	
	private TipoDeAtraccion calcularTipoDeAtraccion() {
		return this.atracciones.get(0).tipo;
	}

	@Override
	public void reducirCupo() {
		for(Oferta a : this.atracciones) {
			a.reducirCupo(); 
		}
	}
	@Override
	public double getCosto() {
		
		return this.costo;
	}
	@Override
	public double getTiempo() {
		// TODO Auto-generated method stub
		return this.tiempo;
	}
	
	@Override
	public boolean hayCupo() {
		boolean ban=true;
		for(Oferta a : this.atracciones) {
			if(!a.hayCupo())
				ban=false;
		}
		return ban;
	}
	@Override
	public String getNombre() {
		
		return this.atracciones.toString();
	}
}
