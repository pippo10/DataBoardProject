
import java.util.ArrayList;
import java.util.List;

public class Category<E extends Data> {
	//Overview : tipo di dato astratto modificabile che rappresenta una collezione della DataBoard
	//TypicalElement : < category, friends { ...} , data {... }
	
	//AF (category, friends, data ) = < category, friends, data >
	//IR : category !=  null && friends != null && data != null && category.length > 0 &&
	//		forall 0<= i < friends.size() == > friends.get(i) != null
	//		forall 0<= i < data.size() == > data.get(i) != null
	//		forall 0<= i < j< friends.size() == > friends.get(i).equals ( friends.get(j) ) == false  
	//		forall 0<= i < j< data.size() == > data.get(i).equals ( data.get(j) ) == false  
	
	//		all of this conditions are checked in upper level implementation, and necessary exceptions are thrown !


	private String category;
	private List<String> friends;
	private List<E> data;
	
	public Category(String category) {
		this.category = category;
		friends = new ArrayList<String> ();
		data = new ArrayList<E>();
	}
	
	public String getCategory() {
		return category;
	}
	
	public List<String> getFriends(){
		return friends;
	}
	
	public List<E> getData(){
		return data;
	}
	
	public boolean insertFriend(String friend) {
		if (friends.contains(friend)) return false;
		return friends.add(friend);
	}
	
	public boolean removeFriend(String friend) {
		return friends.remove(friend);
	}
	
	public boolean insertData(E data) {
		return this.data.add(data);
	}
	
	public boolean removeData(E data) {
		return this.data.remove(data);
	}
	
}