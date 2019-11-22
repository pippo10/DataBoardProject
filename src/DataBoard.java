
import java.util.*;
public interface DataBoard<E extends Data>{
	
	//Overview : tipo di dato astratto che rapresenta una insieme di dati che sono associati 
	// ciascuno ad una e una sola categoria, inoltre vi e' anche un insieme di amici che possono
	// visualizzare dati di una data categoria e associargli un " like "
	//TypicalElement : <  owner, password, categories{ <category_j, friends{...}, data {...} > } >
	
	// Crea una categoria di dati
	// se vengono rispettati i controlli di identità
	
	//@REQUIRES : category != null && passw!=null && category != all category_k
	//@THROWS: NullPointerException, CategoryDuplicateException, WrongPasswordException, IllegalArgumentExeption
	//@MODIFIES : this
	//@EFFECTS : if passw = password && category is not yet in categories,
	//			then post_categories = pre_categories + category
	public void createCategory(String category, String passw) throws NullPointerException, CategoryDuplicateException, WrongPasswordException, IllegalArgumentException;
	
	
	
	
	// Rimuove una categoria di dati
	// se vengono rispettati i controlli di identità
	
	//@REQUIRES : category!=null && passw != null && category is in categories
	//@THROWS : NullPointerException, IllegalArgumentException, WrongPasswordException
	//@MODIFIES : this
	//@EFFECTS : if passw = password && category is in categories,
	//			then post_categories = pre_categories / category
	public void removeCategory(String category, String passw) throws NullPointerException, WrongPasswordException, IllegalArgumentException;
	
	
	// Aggiunge un amico ad una categoria di dati
	// se vengono rispettati i controlli di identità
	
	//@REQUIRES : category != null & passw!=null && friend != null && friend != friend_i forall 0<= i < category.friends.size
	//@THROWS: NullPointerException, FriendDuplicateException, IllegalArgumentException, WrongPasswordException
	//@MODIFIES : this
	//@EFFECTS : if passw = password && category is in categories,
	//			then post_friends = pre_friends + friend
	public void addFriend(String category, String passw, String friend) throws NullPointerException, FriendDuplicateException, IllegalArgumentException, WrongPasswordException;
	
	
	// rimuove un amico da una categoria di dati
	// se vengono rispettati i controlli di identità
	
	//@REQUIRES : category != null && passw!=null && friend != null && category is in categories && friend is in category.friends 															
	//@THROWS : NullPointerException, IllegalArgumentException, WrongPasswordException
	//@MODIFIES : this
	//@EFFECTS : if category !=null, friend != null, passw != null,category is in categories, friend is in category.friends
	// 																
	//					then post_friends = pre_friends / friend
	public void removeFriend(String category, String passw, String friend) throws NullPointerException, IllegalArgumentException, WrongPasswordException;
	
	
	//Inserisce un dato in bacheca
	//se vengono rispettati i controlli di identità
	
	//@REQUIRES : passw != null && dato != null && category != null && category is in categories
	// && dato ! = all data_j in category.data
	//@THROWS : NullPointerException, IllegalArgumentException, **DataDuplicateException**, WrongPasswordException
	//@MODIFIES : this
	//@EFFECTS : returns true if post_data = pre_data + dato, else false
	//					ps. false only when Exists i : data_i = dato
	public boolean put (String passw, E dato, String category) throws NullPointerException, IllegalArgumentException, DataDuplicateException, WrongPasswordException;

	
	//Restituisce una copia del dato in bacheca
	// se vengono rispettati i controlli di identità
	
	//@REQUIRES : passw != null, dato != null
	//@THROWS : NullPointerException, WrongPasswordException, IllegalArgumentException
	//@EFFECTS : returns  data_i.copy, if exists data_i = dato in categories_j.data forall j
	public E get(String passw, E dato) throws NullPointerException, WrongPasswordException, IllegalArgumentException;
	
	
	// Rimuove il dato dalla bacheca
	// se vengono rispettati i controlli di identità
	
	//@REQUIRES : passw != null, dato != null
	//@THROWS : NullPointerException, IllegalArgumentException, WrongPasswordException
	//@MODIFIES : this 
	//@EFFECTS : removes and returns data_i, if Exists i : data_i = dato in categories_j.data forall j
	public E remove(String passw, E dato) throws NullPointerException, WrongPasswordException;
	
	
	//Crea la lista dei dati in bacheca di una determinata categoria
	// se vengono rispettati i controlli di identità
	
	//@REQUIRES : passw != null, category != null
	//@THROWS : NullPointerException, WrongPasswordException, IllegalArgumentExeption
	//@EFFECTS : returns a list containing all data_i : data_i.category = category
	public List<E> getDataCategory(String passw, String category) throws NullPointerException, WrongPasswordException,IllegalArgumentException;
	
	// Aggiunge un like a un dato
	// se vengono rispettati i controlli di identità
	
	//@REQUIRES : friend != null, data != null
	//@THROWS : NullPointerException, IllegalArgumentException
	//@MODIFIES : data
	//@EFFECTS : data.likes ++;
	void insertLike(String friend, E data) throws NullPointerException, IllegalArgumentException;
	
	
	
	// restituisce un iteratore (senza remove) che genera tutti i dati in
	// bacheca ordinati rispetto al numero di like
	// se vengono rispettati i controlli di identità
	
	//@REQUIRES : passw != null
	//@THROWS : NullPointerException, WrongPasswordException
	//@EFFECTS : returns an Iterator among all data elements , "like" ordered
	public Iterator<E> getIterator(String passw) throws NullPointerException, WrongPasswordException;
	
	
	// restituisce un iteratore (senza remove) che genera tutti i dati in
	// bacheca condivisi
	
	//@REQUIRES : friend != null
	//@THROWS : NullPointerException, IllegalArgumentException
	//@EFFECTS : return an Iterator among all those data elements, which are available to friend
	public Iterator<E> getFriendIterator(String friend);
	
	
	// … altre operazione da definire a scelta
}