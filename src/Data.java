
public interface Data extends Comparable<Data>{
	//Overview: tipo di dato astratto modificabile che rappresenta un dato digitale
	//TypicalElement : < name, content, num_likes, like_list >
	
	//@EFFECTS : clones this ( returns a copy of this )
	public Object clone();
	
	//@REQUIRES : friend != null , friend.length > 0
	//@THROWS : NullPointerEXception, IllegalArgumentException
	//@MODIFIES : this
	//@EFFECTS : numLikes = numLikes + 1 , post_likes = pre_likes + friend
	public void addLike(String friend)throws NullPointerException, IllegalArgumentException;
	
	
	//@EFFECTS : puts info about this into a String and returns a string
	public String display();
	

	//@EFFECTS : returns an int , as a result of comparison between 2 objects Data typed.
	public int compareTo(Data dato);
	
	//@EFFECTS : return this.num_likes
	public int getNumLikes();
	
	//@EFFECTS : return this.name
	public String getName();
	
	//@EFFECTS : return this.content
	public String getContent();
	
}
