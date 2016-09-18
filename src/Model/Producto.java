package Model;

public class Producto {
	private int codigo;
	
	private String titulo;
	
	private String descripcion;
	
	private float precio;
	 
	public Producto(int code,String title,String description,float price){
		this.codigo = code;
		this.titulo = title;
		this.descripcion = description;
		this.precio = price;
	}
}
