
import java.util.Iterator;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.SortedSet;
import java.util.ArrayList;
import java.util.Collections;

public class MyDataBoard<E extends Data> implements DataBoard<E>{
	//Overview : tipo di dato astratto che rapresenta una insieme di dati che sono associati 
		// ciascuno ad una e una sola categoria, inoltre vi e' anche un insieme di amici che possono
		// visualizzare dati di una data categoria e associargli un " like "
		//TypicalElement :<  owner, password, categories{ <category_j, friends{...}, data {...} > } >
		//AF (data, friends, password, user ) = user, password, data.keySet / friends.keySet { < data/friends.keySet(). ""get(i) "" , friends.get(i), data.get(i) > }
	
		//RepInvariant : data != null && 
		//				friends != null && 
		//				user != null && 
		//				password != null && 
		//				user.length != 0 && 
		//				password.length !=0 &&
	
		//				forall 0<=i<j<data.keySet().size. ==> data.keySet()."" get(i) "" !=  data.keySet()."" get(j) "" ( no 2 same categories !! ) &&
		//				forall 0<=i<j<friends.keySet().size. ==> friends.keySet()."" get(i) "" !=  friends.keySet()."" get(j) "" ( no 2 same categories !! ) &&
		//				forall 0<=i<j< data.get(category_k).size ==> data.get(category_k). ""get(i) ""   !=  data.get(category_k). "" get(j) "" (no 2 same datas in a category ! ) &&
		//				forall 0<=i<j< friends.get(category_k).size ==> friends.get(category_k). ""get(i) ""  !=  friends.get(category_k). "" get(j) "" (no 2 same friends in a category ! ) 
		//				THIS IS ALSO GUARANTEED BY SET PROPERTIES IN JAVA !
	
		//				forall 0<= i < data.keySet().size ==> data.get(category_i) != null  &&
		//				forall 0<= i < friends.keySet().size ==> friends.get(category_i) != null  &&
		//				forall 0<=i<j< data.keySet().size ==> data.get(category_i).equals( data.get(category_j) ) == false // a particular data can be contained only in 1 category !
		//				the same thing is not true for friends !!!				
		//
						
		
	
	private HashMap <String,HashSet<E>> data;
	private HashMap <String,HashSet<String>> friends;
	private String user;
	private String password;
	
	public MyDataBoard(String user, String password) throws NullPointerException, IllegalArgumentException{
		if	(user == null) throw new NullPointerException("Invalid user ! \n");
		if  (password == null) throw new NullPointerException("Invalid password ! \n");
		if  (user.length()==0) throw new IllegalArgumentException("User cannot be an empty string ! \n");
		if  (password.length()==0)throw new IllegalArgumentException("Password cannot be an empty string ! \n");
		data = new HashMap <String,HashSet<E>> ();
		friends = new HashMap<String,HashSet<String>>();
		this.user = user;
		this.password = password;
		
	}
	
	// Crea una categoria di dati
	// se vengono rispettati i controlli di identità
		

	
		public void createCategory(String category, String passw) throws NullPointerException, CategoryDuplicateException, WrongPasswordException, IllegalArgumentException {
			if (category == null) throw new NullPointerException ("Invalid category ! \n");
			if (passw == null) throw new NullPointerException("Invalid password ! \n");
			if (category.length()==0) throw new IllegalArgumentException("Category cannot be an empty string ! \n");
			if (!(this.password.equals(passw))) throw new WrongPasswordException ("Wrong password ! \n");
			if (data.containsKey(category)) throw new CategoryDuplicateException ("This category already exists ! \n");
			data.put(category, new HashSet<E>());
			friends.put(category, new HashSet<String>());
		}
		
		
		
		
		// Rimuove una categoria di dati
		// se vengono rispettati i controlli di identità
		

		public void removeCategory(String category, String passw) throws NullPointerException, WrongPasswordException, IllegalArgumentException {
			if (category == null) throw new NullPointerException ("Invalid category ! \n");
			if (passw == null) throw new NullPointerException("Invalid password ! \n");
			if (category.length()==0) throw new IllegalArgumentException("Category cannot be an empty string ! \n");
			if (!(this.password.equals(passw))) throw new WrongPasswordException("Wrong password ! \n");
			if (!(data.containsKey(category))) throw new IllegalArgumentException("Can't find category to remove ! \n");
			data.remove(category);
			friends.remove(category);
		}
		
		
		// Aggiunge un amico ad una categoria di dati
		// se vengono rispettati i controlli di identità
		

		public void addFriend(String category, String passw, String friend) throws NullPointerException, FriendDuplicateException, IllegalArgumentException, WrongPasswordException{
			if (category == null) throw new NullPointerException ("Invalid category ! \n");
			if (passw == null) throw new NullPointerException("Invalid password ! \n");
			if (friend == null) throw new NullPointerException("Invalid friend ! \n");
			if (!(this.password.equals(passw))) throw new WrongPasswordException("Wrong password ! \n");
			if (!(data.containsKey(category))) throw new IllegalArgumentException("No such category ! \n");
			if (!(friends.get(category).add(friend))) throw new FriendDuplicateException("This friend already exists ! \n");
			
		}
		
		
		// rimuove un amico da una categoria di dati
		// se vengono rispettati i controlli di identità
		

		public void removeFriend(String category, String passw, String friend) throws NullPointerException, IllegalArgumentException, WrongPasswordException {
			if (category == null) throw new NullPointerException ("Invalid category ! \n");
			if (passw == null) throw new NullPointerException("Invalid password ! \n");
			if (friend == null) throw new NullPointerException("Invalid friend ! \n");
			if (!(this.password.equals(passw))) throw new WrongPasswordException("Wrong password ! \n");
			if (!(data.containsKey(category))) throw new IllegalArgumentException("No such category ! \n");
			if (!(friends.get(category).remove(friend))) throw new IllegalArgumentException("No such friend ! \n");
		}
		
		
		//Inserisce un dato in bacheca
		//se vengono rispettati i controlli di identità
		

		public boolean put (String passw, E dato, String category) throws NullPointerException, IllegalArgumentException, DataDuplicateException, WrongPasswordException{
			if (category == null) throw new NullPointerException ("Invalid category ! \n");
			if (passw == null) throw new NullPointerException("Invalid password ! \n");
			if (dato == null) throw new NullPointerException("Invalid data ! \n");
			if (!(this.password.equals(passw))) throw new WrongPasswordException("Wrong password ! \n");
			if (!(data.containsKey(category))) throw new IllegalArgumentException("No such category ! \n");
			for(HashSet<E> tmp : data.values()) {
				if (tmp.contains(dato)) throw new DataDuplicateException("This data already exists in this DataBoard ! \n");
			}
			data.get(category).add(dato);
			return true;
		}

		
		//Restituisce una copia del dato in bacheca
		// se vengono rispettati i controlli di identità
		

		public E get(String passw, E dato) throws NullPointerException, WrongPasswordException, IllegalArgumentException{
			if (passw == null) throw new NullPointerException("Invalid password ! \n");
			if (dato == null) throw new NullPointerException("Invalid data ! \n");
			if (!(this.password.equals(passw))) throw new WrongPasswordException("Wrong password ! \n");
			for(HashSet<E> tmp : data.values()) {
				if (tmp.contains(dato)) return (E)dato.clone();
			}
			throw new IllegalArgumentException ("No data found ! \n");
		}
		
		
		// Rimuove il dato dalla bacheca
		// se vengono rispettati i controlli di identità
		

		public E remove(String passw, E dato) throws NullPointerException, WrongPasswordException{
			if (passw == null) throw new NullPointerException("Invalid password ! \n");
			if (dato == null) throw new NullPointerException("Invalid data ! \n");
			if (!(this.password.equals(passw))) throw new WrongPasswordException("Wrong password ! \n");
			E toRemove=null;
			for(HashSet<E> tmp : data.values()) {
				if(tmp.remove(dato)) toRemove = dato;
			}
			if (toRemove == null) throw new NullPointerException("No such data was found ! \n");
			return toRemove;
			
		}
		
		
		//Crea la lista dei dati in bacheca di una determinata categoria
		// se vengono rispettati i controlli di identità
		

		public List<E> getDataCategory(String passw, String category) throws NullPointerException, WrongPasswordException,IllegalArgumentException{
			if (category == null) throw new NullPointerException ("Invalid category ! \n");
			if (passw == null) throw new NullPointerException("Invalid password ! \n");
			if (!(this.password.equals(passw))) throw new WrongPasswordException("Wrong password ! \n");
			HashSet<E> tmp = data.get(category);
			if (tmp == null || tmp.isEmpty()) throw new IllegalArgumentException("No such category/ Empty category ! \n");
			List<E> result = new ArrayList<E>(tmp);
			Collections.sort(result);
			return result;
		}
		
		// Aggiunge un like a un dato
		// se vengono rispettati i controlli di identità
		

		public void insertLike(String friend, E data) throws NullPointerException, IllegalArgumentException{
			if (friend == null) throw new NullPointerException ("Invalid friend ! \n");
			if (data == null) throw new NullPointerException ("Invalid data ! \n");
			boolean check = false;
			for(String cat : friends.keySet()) {
				if(friends.get(cat).contains(friend)) {
					if (this.data.get(cat).contains(data)) {
						data.addLike(friend);
						check = true;
					}
				}
			}
			if (check == false) throw new IllegalArgumentException("Friend's category doesn't match data's one / Friend or data aren't contained ! \n");
		}
		
		
		
		// restituisce un iteratore (senza remove) che genera tutti i dati in
		// bacheca ordinati rispetto al numero di like
		// se vengono rispettati i controlli di identità
		

		public Iterator<E> getIterator(String passw) throws NullPointerException, WrongPasswordException{
			if (passw == null) throw new NullPointerException("Invalid password ! \n");
			if (!(this.password.equals(passw))) throw new WrongPasswordException("Wrong password ! \n");
			SortedSet<E> tmp = new TreeSet<E>();
			for(HashSet <E> tmp2 : data.values()) {
				tmp.addAll(tmp2);
			}
			SortedSet<E> finalResult = Collections.unmodifiableSortedSet(tmp);
			return finalResult.iterator();
			
		}
		
		
		// restituisce un iteratore (senza remove) che genera tutti i dati in
		// bacheca condivisi
		

		public Iterator<E> getFriendIterator(String friend){
			if (friend == null) throw new NullPointerException ("Invalid friend ! \n");
			SortedSet<E> result = new TreeSet<E> () ;
			for( String category : friends.keySet()) {
				if(friends.get(category).contains(friend)) {
					result.addAll(data.get(category));
				}
			}
			if(result.isEmpty()) throw new IllegalArgumentException("No data is available for this friend ! \n");
			SortedSet<E> finalResult = Collections.unmodifiableSortedSet(result);
			return finalResult.iterator();
		}

}