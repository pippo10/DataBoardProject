
import java.util.*;
public class MyData implements Comparable<Data>,Data{
	//Overview: tipo di dato astratto modificabile che rappresenta un dato digitale
	//TypicalElement : < nome, contenuto, numero di like, like list >
	
	//AF(name, content, numLikes, likes) = < name, content, numLikes, likes >
	//IR : name != null && content !=null && likes != null && numLikes >= 0
	//		forall 0<= i < likes.size == > likes.get(i) != null  &&
	//		forall 0<= i < j < likes.size() ==> likes.get(i) != likes.get(j) 

	
	private String name;
	private String content;
	private int numLikes;
	private ArrayList<String> likes;
	
	public MyData(String name, String content) throws NullPointerException, IllegalArgumentException {
		if(name==null) throw new NullPointerException("Nome inesistente ! \n");
		if(content==null) throw new NullPointerException("Contenuto inesistente ! \n");
		if(name.length()==0) throw new IllegalArgumentException("Il nome deve essere lungo almeno 1 carattere ! \n");
		this.name = name;
		this.content = content;
		numLikes = 0;
		likes = new ArrayList<String>();
	}
	

	
	//@EFFECTS : clones this
	
	
	public Object clone() {
		MyData new_data = new MyData(this.name,this.content);
		new_data.numLikes = this.numLikes;
		new_data.likes = (ArrayList<String>) this.likes.clone();
		new_data.content = this.content;
		return new_data;
		 
	}
	
	//@REQUIRES : friend != null , friend.length > 0
	//@THROWS : NullPointerEXception, IllegalArgumentException
	//@MODIFIES : this
	//@EFFECTS : numLikes = numLikes + 1 , post_likes = pre_likes + friend
	
	public void addLike(String friend) throws NullPointerException, IllegalArgumentException{
		if(friend==null) throw new NullPointerException("Amico inesistente ! \n");
		if(friend.length()==0) throw new IllegalArgumentException("Nome dell'amico non valido ! \n");
		if(likes.indexOf(friend)==-1) { // se il like di friend e' gia' presente non accade niente !
			likes.add(friend);
			numLikes++;
		}
	}
	
	//@EFFECTS : puts info about this into a String
	
	public String display() {
		String info = "Nome del dato: "+ name + " Contenuto: " + content + "\n" + " Numero dei likes: " +numLikes + " ";
		return info;
	}
	
	
	//@EFFECTS : returns an int , as a result of comparison between 2 objects Data typed.
	
	public int compareTo(Data dato) {
		if(dato==null) return 1;
		if(this.equals(dato)) return 0;
		if(this.numLikes == dato.getNumLikes()) {
			if(this.name.equals(dato.getName())) {
				return this.content.compareTo(dato.getContent());
			}
			return this.name.compareTo(dato.getName());
		}
		return this.numLikes - dato.getNumLikes();
	}
	
	//@EFFECTS : return this.numLikes
	public int getNumLikes() {
		return this.numLikes;
	}
	//@EFFECTS : return this.name
	public String getName() {
		return this.name;
	}
	//@EFFECTS : return this.content
	public String getContent() {
		return this.content;
	}
}