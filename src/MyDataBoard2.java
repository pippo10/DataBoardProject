
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class MyDataBoard2<E extends Data> implements DataBoard<E>{
	//Overview : tipo di dato astratto che rapresenta una insieme di dati che sono associati 
	// ciascuno ad una e una sola categoria, inoltre vi e' anche un insieme di amici che possono
	// visualizzare dati di una data categoria e associargli un " like "
	//TypicalElement : <  owner, password, categories{ <category_j, friends{...}, data {...} > } >
	
	//AF ( categories, user, password ) = user, password , categories { categories.get(j).getCategory() , categories.get(j).getFriends(), categories.get(j).getData() }
	
	//IR : categories != null && user != null && password != null && user.length > 0 && password.length > 0 &&
	//		forall 0<= i < categories.size()  == >  categories.get(i) != null
	//		forall 0<= i < categories.size()  == >  categories.get(i).getData() != null
	//		forall 0<= i < categories.size()  == >  categories.get(i).getFriends() != null	
	//		forall 0<= i < categories.size()  == >  categories.get(i).getCategory() != null	
	//		forall 0<= i < j < categories.size() == >  categories.get(i).getCategory().equals ( categories.get(j).getCategory() ) == false
	//		forall 0<= i < j < categories.size() == > categories.get(i) != categories.get(j)
	//		forall 0<= i < j < categories.size() == > categories.get(i).getData().equals( categories.get(j).getData() ) == false  // a particular data can be contained only in 1 category
	//		forall 0<= i < j < categories.size() == > categories.get(i).getData().get(k).equals( categories.get(j).getData().get(g) == false   forall 0<= k < categories.get(i).getData().size
	//																																		   forall 0<= h < categories.get(j).getData().size
	//		this may not be true for friends !
	
	
	private List<Category<E>> categories;
	private String user;
	private String password;
	
	public MyDataBoard2(String user, String password) throws NullPointerException, IllegalArgumentException{
		if	(user == null) throw new NullPointerException("Invalid user ! \n");
		if  (password == null) throw new NullPointerException("Invalid password ! \n");
		if  (user.length()==0) throw new IllegalArgumentException("User cannot be an empty string ! \n");
		if  (password.length()==0)throw new IllegalArgumentException("Password cannot be an empty string ! \n");
		this.user = user;
		this.password = password;
		categories = new ArrayList<Category<E>>();
	}
	
	// Crea una categoria di dati
	// se vengono rispettati i controlli di identità
	
	
	public void createCategory(String category, String passw) throws NullPointerException, CategoryDuplicateException, WrongPasswordException, IllegalArgumentException{
		if (category == null) throw new NullPointerException ("Invalid category ! \n");
		if (passw == null) throw new NullPointerException("Invalid password ! \n");
		if (category.length()==0) throw new IllegalArgumentException("Category cannot be an empty string ! \n");
		if (!(this.password.equals(passw))) throw new WrongPasswordException ("Wrong password ! \n");
		for(Category<E> tmp : categories) {
			if (tmp.getCategory().equals(category)) throw new CategoryDuplicateException ("This category already exists ! \n");
		}
		categories.add(new Category<E>(category));	
	}
	
	
	
	
	// Rimuove una categoria di dati
	// se vengono rispettati i controlli di identità
	

	public void removeCategory(String category, String passw) throws NullPointerException, WrongPasswordException, IllegalArgumentException{
		if (category == null) throw new NullPointerException ("Invalid category ! \n");
		if (passw == null) throw new NullPointerException("Invalid password ! \n");
		if (category.length()==0) throw new IllegalArgumentException("Category cannot be an empty string ! \n");
		if (!(this.password.equals(passw))) throw new WrongPasswordException("Wrong password ! \n");
		Category<E> toRemove = null;
		for(Category<E> tmp : categories) {
			if (tmp.getCategory().equals(category)) toRemove = tmp;
		}
		if (toRemove == null) throw new IllegalArgumentException("Can't find category to remove ! \n");
		categories.remove(toRemove);
	}
	
	
	// Aggiunge un amico ad una categoria di dati
	// se vengono rispettati i controlli di identità
	

	public void addFriend(String category, String passw, String friend) throws NullPointerException, FriendDuplicateException, IllegalArgumentException, WrongPasswordException{
		if (category == null) throw new NullPointerException ("Invalid category ! \n");
		if (passw == null) throw new NullPointerException("Invalid password ! \n");
		if (friend == null) throw new NullPointerException("Invalid friend ! \n");
		if (!(this.password.equals(passw))) throw new WrongPasswordException("Wrong password ! \n");
		Category<E> cat = null;
		for(Category<E> tmp : categories) {
			if (tmp.getCategory().equals(category)) cat = tmp;
		}
		if (cat == null) throw new IllegalArgumentException("No such category ! \n");
		if (!(cat.insertFriend(friend))) throw new FriendDuplicateException("This friend already exists ! \n");
	}
	
	
	// rimuove un amico da una categoria di dati
	// se vengono rispettati i controlli di identità
	

	public void removeFriend(String category, String passw, String friend) throws NullPointerException, IllegalArgumentException, WrongPasswordException{
		if (category == null) throw new NullPointerException ("Invalid category ! \n");
		if (passw == null) throw new NullPointerException("Invalid password ! \n");
		if (friend == null) throw new NullPointerException("Invalid friend ! \n");
		if (!(this.password.equals(passw))) throw new WrongPasswordException("Wrong password ! \n");
		Category<E> cat = null;
		for(Category<E> tmp : categories) {
			if (tmp.getCategory().equals(category)) cat = tmp;
		}
		if (cat == null) throw new IllegalArgumentException("No such category ! \n");
		if (!(cat.removeFriend(friend))) throw new IllegalArgumentException("No such friend ! \n");
	}
	
	
	//Inserisce un dato in bacheca
	//se vengono rispettati i controlli di identità
	

	public boolean put (String passw, E dato, String category) throws NullPointerException, IllegalArgumentException, DataDuplicateException, WrongPasswordException{
		if (category == null) throw new NullPointerException ("Invalid category ! \n");
		if (passw == null) throw new NullPointerException("Invalid password ! \n");
		if (dato == null) throw new NullPointerException("Invalid data ! \n");
		if (!(this.password.equals(passw))) throw new WrongPasswordException("Wrong password ! \n");
		Category<E> cat = null;
		for(Category<E> tmp : categories) {
			if (tmp.getCategory().equals(category)) cat = tmp;
		}
		if (cat == null) throw new IllegalArgumentException("No such category ! \n");
		for(Category<E> tmp : categories) {
			if (tmp.getData().contains(dato)) throw new DataDuplicateException("This data already exists in this DataBoard ! \n");
		}
		return cat.insertData(dato);
	}

	
	//Restituisce una copia del dato in bacheca
	// se vengono rispettati i controlli di identità
	

	public E get(String passw, E dato) throws NullPointerException, WrongPasswordException, IllegalArgumentException{
		if (passw == null) throw new NullPointerException("Invalid password ! \n");
		if (dato == null) throw new NullPointerException("Invalid data ! \n");
		if (!(this.password.equals(passw))) throw new WrongPasswordException("Wrong password ! \n");
		for(Category<E> tmp : categories) {
			if (tmp.getData().contains(dato)) return (E)dato.clone();
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
		for(Category<E> tmp : categories) {
			if(tmp.getData().remove(dato)) toRemove = dato;
		}
		if (toRemove == null) throw new NullPointerException("No such data was found ! \n");
		return toRemove;
	}
	
	
	//Crea la lista dei dati in bacheca di una determinata categoria
	// se vengono rispettati i controlli di identità
	

	public List<E> getDataCategory(String passw, String category) throws NullPointerException, WrongPasswordException, IllegalArgumentException{
		if (category == null) throw new NullPointerException ("Invalid category ! \n");
		if (passw == null) throw new NullPointerException("Invalid password ! \n");
		if (!(this.password.equals(passw))) throw new WrongPasswordException("Wrong password ! \n");
		Category<E> cat = null;
		for(Category<E> tmp : categories) {
			if(tmp.getCategory().equals(category)) cat = tmp;
		}
		if (cat == null || cat.getData().isEmpty()) throw new IllegalArgumentException("No such category/ Empty category ! \n");
		List<E> result = cat.getData();
		Collections.sort(result);
		return result;

	}
	
	// Aggiunge un like a un dato
	// se vengono rispettati i controlli di identità
	

	public void insertLike(String friend, E data) throws NullPointerException, IllegalArgumentException{
		if (friend == null) throw new NullPointerException ("Invalid friend ! \n");
		if (data == null) throw new NullPointerException ("Invalid data ! \n");
		Category<E> cat = null;
		for(Category<E> tmp : categories) {
			if (tmp.getData().contains(data) && tmp.getFriends().contains(friend))  {
				cat = tmp;
				data.addLike(friend);
			}
				
		}
		if(cat == null) throw new IllegalArgumentException("Friend's category doesn't match data's one / Friend or data aren't contained ! \n");	
	}
	
	
	
	// restituisce un iteratore (senza remove) che genera tutti i dati in
	// bacheca ordinati rispetto al numero di like
	// se vengono rispettati i controlli di identità
	

	public Iterator<E> getIterator(String passw) throws NullPointerException, WrongPasswordException{
		if (passw == null) throw new NullPointerException("Invalid password ! \n");
		if (!(this.password.equals(passw))) throw new WrongPasswordException("Wrong password ! \n");
		List<E> result = new ArrayList<E>();
		for(Category<E> tmp : categories) {
			result.addAll(tmp.getData());
		}
		Collections.sort(result);
		result = Collections.unmodifiableList(result);
		return result.iterator();
	}
	
	
	// restituisce un iteratore (senza remove) che genera tutti i dati in
	// bacheca condivisi
	

	public Iterator<E> getFriendIterator(String friend){
		if (friend == null) throw new NullPointerException ("Invalid friend ! \n");
		List<E> result = new ArrayList<E>();
		for(Category<E> tmp : categories) {
			if(tmp.getFriends().contains(friend)) result.addAll(tmp.getData());		
		}
		Collections.sort(result);
		if (result.isEmpty()) throw new IllegalArgumentException("No data is available for this friend ! \n");
		result = Collections.unmodifiableList(result);
		return result.iterator();
	}
	
	

}
