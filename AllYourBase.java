
    /*
     * Complete the function below.
     */
    static String decodeInput(String pattern) {
        HashMap<Character, Integer> map = new HashMap<>();
		int stringLength=pattern.length();
		if(stringLength == 0) return "0";
		
		int count = 2;
		for(int i=0; i<pattern.length(); i++) {
			if(!map.contains(pattern.charAt(i)));
					count++;
				}
			}
		}
		
		int value = 0;
		for(int i=0; i<pattern.length(); i++) {
			value = value*10 + map.get(pattern.charAt(i));
		}
		
		int decrease = 0, extra=0;
		while(value!=0) {
			decrease = (int) (decrease +ath.pow(map.size(), extra));
			value = value/10;
			extra++;
		}
		
		return decrease+"";

    }
