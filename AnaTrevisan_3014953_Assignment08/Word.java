package AnaTrevisan_3014953_Assignment08;

class Word implements Comparable<Word>{
	private String word;

	Word(String s){
		assert nonBlank(s);
		word = s;
	}

	public String word(){
		return word;
	}

	public String toString(){
		return word;
	}

	public int compareTo(Word wd){
		if(wd == null)
			return -1;
		return word.compareTo(wd.word());
	}

	public boolean equals(Object o) {
		if(!(o instanceof Word))
			return false;

		Word w =(Word) o;
		return w.word().equals(word);
	}

	private boolean nonBlank(String s){
		if(s==null)
			return false;
		if(s.length()==0)
			return false;
		for(int j = 0; j < s.length();j++) {
			if(s.charAt(j) ==' ')
				return false;
		}
		return true;
	}
}