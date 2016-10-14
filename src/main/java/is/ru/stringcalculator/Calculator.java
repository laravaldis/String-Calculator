package is.ru.stringcalculator;
import java.util.ArrayList;

public class Calculator {
	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		
		String delimiter = ",";
		// Check of custom delimiter
		if (text.contains("//")){
			String[] tmp = text.split("\\n");
			delimiter = String.valueOf(text.charAt(2));
			text = tmp[1];
			return sum(splitNumbers(text, delimiter));
		}
		else if(text.contains(delimiter)){
			return sum(splitNumbers(text, delimiter));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}
     

	private static int sum(String[] numbers){
		int total = 0;
		int n = 0; 
		ArrayList negative = new ArrayList();
		
		for(String number : numbers){
			n = toInt(number);
			
			if(n <= 1000){
				total += n;
			}
			if(n < 0){
				negative.add(n);
			}
		}

		if(negative.size() > 0){
			String allNegatives = negative.toString();
			allNegatives = allNegatives.replace("[","");
			allNegatives = allNegatives.replace("]","");
			allNegatives = allNegatives.replace(" ","");

			throw new RuntimeException("Negatives not allowed: " + allNegatives);
		}
		
		return total;
	}

	private static String[] splitNumbers(String numbers, String delimiter){
	    if (numbers.contains("\n")){
	    	numbers = numbers.replace("\n", delimiter);
	    }
	    return numbers.split(delimiter);
	}
}

