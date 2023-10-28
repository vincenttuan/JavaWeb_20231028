package model;

// BMI 基礎代謝率
public class BMRService {
	
	// BMR 計算
	public double calcBmr(double h, double w, int age, String sex) {
		double bmrValue = 0;
		switch(sex) {
			case "man":
				bmrValue = 66 + (13.7* w + 5 * h - 6.8 * age );
				break;
			default:
				bmrValue = 655 + (9.6 * w + 1.8 * h - 4.7 * age);
		}
		return bmrValue;
	}
	
	// BMR 診斷
	public String getDiagnosis(double bmrValue, String sex) {
		String diagnosis = null;
		switch (sex) {
			case "man":
				diagnosis = bmrValue > 1800 ? "過高" : bmrValue < 1400 ? "過低" : "正常"; 
				break;
			default:
				diagnosis = bmrValue > 1500 ? "過高" : bmrValue < 1200 ? "過低" : "正常";
		}
		return diagnosis;
	}
	
}
