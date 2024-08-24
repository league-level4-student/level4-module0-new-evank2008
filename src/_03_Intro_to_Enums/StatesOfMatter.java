package _03_Intro_to_Enums;

public enum StatesOfMatter {
solid(0), liquid(25.55), gas(100);

 double celsiusTemp;
private StatesOfMatter(double celsiusTemp) {
	this.celsiusTemp=celsiusTemp;
}
public double convertToFahrenheit(double celsius) {
	return (celsius * 9/5 + 32);
}

}

