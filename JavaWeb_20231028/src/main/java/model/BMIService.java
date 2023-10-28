package model;

public class BMIService {
	
	/**
	 * 計算並返回 bmi 指數資料
	 * 注意: 該方法必須將身高由公分(cm)改為公尺(m)
	 * 
	 * @param h 身高(cm)
	 * @param w 體重(kg)
	 * @return 計算出 bmi 值
	 * */
	public double calcBmi(double h, double w) {
		double bmiValue = w / Math.pow(h/100, 2);
		return bmiValue;
	}
	
}
