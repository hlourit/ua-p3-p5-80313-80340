import java.util.*;
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
	public static Data today(){
		Calendar cal = Calendar.getInstance();
		return new Data(cal.get(Calendar.DAY_OF_MONTH),cal.get(Calendar.MONTH),cal.get(Calendar.YEAR));
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
	@Override
	public String toString(){
		return ""+dia+"/"+mes+"/"+ano;
	}
	@Override
	public boolean equals(Object other){
		Data otherd;
		if(other==null) return false;
		if(other==this) return true;
		if(this.getClass()!=other.getClass()) return false;
		otherd=(Data) other;
		if(dia!=otherd.getDay()) return false;
		if(mes!=otherd.getMonth()) return false;	
		if(ano!=otherd.getYear()) return false;	
		return true;
	}
}
