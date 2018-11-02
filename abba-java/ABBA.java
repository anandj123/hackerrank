public class ABBA{public String canObtain(String initial,String target){if(fillWord(initial,target)){return "Possible";}return "Impossible";}
public boolean fillWord(String word, String target){if(word.length()==target.length()){return(word.equals(target));}
return(fillWord( word + "A",target) || fillWord(new StringBuilder(word).reverse().toString() + "B",target));}}
