package Aula01.ex12;

public class Data{

	private final int dia;
	private final int mes;
	private final int ano;

	public Data(int dia,int mes,int ano){
		assert validDay(dia)&&validMonth(mes)&&validYear(ano);
		this.dia=dia;
		this.mes=mes;
		this.ano=ano;
	}
	private boolean validDay(int day){
		if(day<1) return false;
		if(day>31) return false; //FIXME better check
		return true;
	}
	private boolean validMonth(int month){
		if(month<1 || month>12) return false;
		return true;
	}
	private boolean validYear(int year){
		if(year<1) return false;
		return true;
	}
	public int getDay(){
		return dia;
	}
	public int getMonth(){
		return mes;
	}
	public int getYear(){
		return ano;
	}
	public String toString(){
		return ""+dia+"/"+mes+"/"+ano;
	}
}
