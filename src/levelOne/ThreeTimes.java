package levelOne;

public class ThreeTimes {

	public static void main(String[] args) {
//		디지털 시계에 하루동안(00:00~23:59) 3이 표시되는 시간을 초로 환산하면 총 몇 초(second) 일까요?
//		디지털 시계는 하루동안 다음과 같이 시:분(00:00~23:59)으로 표시됩니다.

		int a = 0;
		int b = 0;
		
		for (int i =0; i < 24; i++) {
			
			if(i%10 ==3) {
				a = a +1;
			} else {
				for(int j = 0; j <60; j++) {
					if(j/10 ==3) {
						b = b +1;
					} else {
						if(j%10 ==3) {
							b = b+1;
						}
					}
				}
			}
		}
		
		System.out.println(a+","+b);
		
		int total = a*3600 + b*60;
		
		System.out.println(total);
		
		
	}

}
