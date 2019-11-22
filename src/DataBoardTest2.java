
import java.util.Arrays;
import java.util.List;
import java.util.Iterator;

public class DataBoardTest2 {
	public static void main (String[] args) {
		
		// TEST COSTRUTTORE
		
		try {
			System.out.println("Creo una DataBoard con Passw a null -> NullPointerException \n \n");
			DataBoard<Data> Paolo_board = new MyDataBoard2<Data>("Paolo",null);
		}
		catch (NullPointerException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		
		try {
			System.out.println("Creo una DataBoard con User a null -> NullPointerException \n \n");
			DataBoard<Data> Paolo_board = new MyDataBoard2<Data>(null,"1234");
		}
		catch (NullPointerException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		try {
			System.out.println("Creo una DataBoard con User vuota -> IllegalArgumentException \n \n");
			DataBoard<Data> Paolo_board = new MyDataBoard2<Data>("","1234");
		}
		catch (IllegalArgumentException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		try {
			System.out.println("Creo una DataBoard con Passw vuota -> IllegalArgumentException \n \n");
			DataBoard<Data> Paolo_board = new MyDataBoard2<Data>("Paolo","");
		}
		catch (IllegalArgumentException e ) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		System.out.println("Creo qualche DataBoard ok ");
		

			DataBoard<Data> Paolo_board = new MyDataBoard2<Data>("Paolo","1234");
			System.out.println("Paolo_board, PW: 1234 ");
			DataBoard<Data> Alice_board = new MyDataBoard2<Data>("Alice","alice101");
			System.out.println("Alice_board, PW: alice101 ");
			DataBoard<Data> Gigi_board = new MyDataBoard2<Data>("Gigi","thebestgigio");
			System.out.println("Gigi_board, PW: thebestgigio ");

		
		System.out.println("Testo createCategory");
		
		
		
		
		
		
		try {
			System.out.println("Cerco di inserire in Paolo_board categoria null -> NullPointerException \n \n");
			Paolo_board.createCategory(null,"1234");
		}
		catch (NullPointerException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		
		try {
			System.out.println("Cerco di inserire in Paolo_board la categoria 'Trash' con passw a null -> NullPointerException \n \n");
			Paolo_board.createCategory("Trash",null);
		}
		catch (NullPointerException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		try {
			System.out.println("Cerco di inserire in Paolo_board la categoria con length = 0  -> IllegalArgumentException \n \n");
			Paolo_board.createCategory("","1234");
		}
		catch (IllegalArgumentException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		try {
			System.out.println("Cerco di inserire in Paolo_board la categoria 'Trash' con passw sbagliata -> WrongPasswordException \n \n");
			Paolo_board.createCategory("Trash","12345");
		}
		catch (WrongPasswordException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		System.out.println("Inserisco qualche categoria ok \n \n");
		try {
			Paolo_board.createCategory("Confidenziale", "1234");
			System.out.println("Categoria 'Confidenziale' inserita in Paolo_board \n \n");
			Alice_board.createCategory("Tempo libero", "alice101");
			System.out.println("Categoria 'Tempo libero' inserita in Alice_board \n \n");
			Gigi_board.createCategory("Calcio", "thebestgigio");
			System.out.println("Categoria 'Calcio' inserita in Gigi_board \n \n");
			Paolo_board.createCategory("Lavoro", "1234");
			System.out.println("Categoria 'Lavoro' inserita in Paolo_board \n \n");
			Alice_board.createCategory("Scuola", "alice101");
			System.out.println("Categoria 'Scuola' inserita in Alice_board \n \n");
			Gigi_board.createCategory("Musica", "thebestgigio");
			System.out.println("Categoria 'Musica' inserita in Gigi_board \n \n");
			Paolo_board.createCategory("Famiglia", "1234");
			System.out.println("Categoria 'Famiglia' inserita in Paolo_board \n \n");
			Alice_board.createCategory("Danza", "alice101");
			System.out.println("Categoria 'Danza' inserita in Alice_board \n \n");
			Gigi_board.createCategory("Giochi", "thebestgigio");
			System.out.println("Categoria 'Giochi' inserita in Gigi_board \n \n");
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		
		System.out.println("Provo a inserire categorie duplicati \n \n");
		
		
		
		
		
		
		try {
			System.out.println(" Provo: categoria 'Confidenziale' in Paolo_board -> CategoryDuplicateException \n");
			Paolo_board.createCategory("Confidenziale", "1234");
		}
		catch (CategoryDuplicateException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		try {
			System.out.println(" Provo: categoria 'Danza' in Alice_board -> CategoryDuplicateException \n");
			Alice_board.createCategory("Danza", "alice101");
		}
		catch (CategoryDuplicateException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		try {
			System.out.println(" Provo: categoria 'Musica' in Gigi_board -> CategoryDuplicateException \n");
			Gigi_board.createCategory("Musica", "thebestgigio");
		}
		catch (CategoryDuplicateException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		
		
		System.out.println("Testo la removeCategory");
		
		
		
		
		
		try {
			System.out.println(" Provo a rimuovere la categoria null da Alice_board -> NullPointerException \n \n");
			Alice_board.removeCategory(null, "alice101");
		}
		catch (NullPointerException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		try {
			System.out.println(" Provo a rimuovere la categoria 'Scuola' con passw = null da Alice_board -> NullPointerException \n \n");
			Alice_board.removeCategory("Scuola", null);
		}
		catch (NullPointerException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		try {
			System.out.println(" Provo a rimuovere la categoria con length = 0 da Alice_board -> IllegalArgumentException \n \n");
			Alice_board.removeCategory("", "alice101");
		}
		catch (IllegalArgumentException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		try {
			System.out.println(" Provo a rimuovere la categoria 'Scuola' con passw sbagliata da Alice_board -> WrongPasswordException \n \n");
			Alice_board.removeCategory("Scuola", "passSbagliata");
		}
		catch (WrongPasswordException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		
		
		
		
		System.out.println("Provo a rimuovere categorie inesistenti ");
		
		
		
		
		
		try {
			System.out.println(" Provo a rimuovere la categoria 'Giardino'  da Alice_board -> IllegalArgumentException \n \n");
			Alice_board.removeCategory("Giardino", "alice101");
		}
		catch (IllegalArgumentException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		try {
			System.out.println(" Provo a rimuovere la categoria 'Basket'  da Paolo_board -> IllegalArgumentException \n \n");
			Paolo_board.removeCategory("Basket", "1234");
		}
		catch (IllegalArgumentException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		
		try {
			System.out.println(" Provo a rimuovere la categoria 'Bambole' da Gigi_board -> IllegalArgumentException \n \n");
			Gigi_board.removeCategory("Bambole", "thebestgigio");
		}
		catch (IllegalArgumentException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		
		System.out.println("Rimuovo 1 categoria esistente per ciascuna board");
		
		try {
			Paolo_board.removeCategory("Confidenziale", "1234");
			System.out.println("Ho rimosso la categoria 'Confidenziale' da Paolo_board");
			Alice_board.removeCategory("Scuola", "alice101");
			System.out.println("Ho rimosso la categoria 'Scuola' da Alice_board");
			Gigi_board.removeCategory("Giochi", "thebestgigio");
			System.out.println("Ho rimosso la categoria 'Giochi' da Gigi_board");
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		
		
		
		System.out.println("Testo add friend");
		
		
		
		
		try {
			System.out.println("Cerco di aggiungere Silvio alla categoria 'null' in Paolo_board  -> NullPointerException \n \n");
			Paolo_board.addFriend(null,"1234","Silvio");
		}
		catch (NullPointerException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		try {
			System.out.println("Cerco di aggiungere amico 'null' alla categoria Lavoro in Paolo_board  -> NullPointerException \n \n");
			Paolo_board.addFriend("Lavoro","1234",null);
		}
		catch (NullPointerException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		try {
			System.out.println("Cerco di aggiungere Silvio alla categoria Lavoro in Paolo_board con password null -> NullPointerException \n \n");
			Paolo_board.addFriend("Lavoro",null,"Silvio");
		}
		catch (NullPointerException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		try {
			System.out.println("Cerco di aggiungere Silvio alla categoria Lavoro in Paolo_board con password sbagliata -> WrongPasswordException \n \n");
			Paolo_board.addFriend("Lavoro","123","Silvio");
		}
		catch (WrongPasswordException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch(Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		try {
			System.out.println("Cerco di aggiungere Silvio alla categoria inesistente Calcio in Paolo_board  -> IllegalArgumentException \n \n");
			Paolo_board.addFriend("Calcio","1234","Silvio");
		}
		catch (IllegalArgumentException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		try {
			System.out.println("Cerco di aggiungere Silvio alla categoria esistente Lavoro in Paolo_board per 2 volte ! -> FriendDuplicateException \n \n");
			Paolo_board.addFriend("Lavoro","1234","Silvio");
			Paolo_board.addFriend("Lavoro","1234","Silvio");
		}		
		catch (FriendDuplicateException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		
		
		System.out.println("Testo removeFriend");
		
		
		
		try {
			System.out.println("Cerco di rimuovere Silvio dalla categoria 'null' in Paolo_board  -> NullPointerException \n \n");
			Paolo_board.removeFriend(null,"1234","Silvio");
		}
		catch (NullPointerException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		try {
			System.out.println("Cerco di rimuovere amico 'null' dalla categoria Lavoro in Paolo_board  -> NullPointerException \n \n");
			Paolo_board.removeFriend("Lavoro","1234",null);
		}
		catch (NullPointerException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		try {
			System.out.println("Cerco di rimuovere Silvio dalla categoria Lavoro in Paolo_board con password null -> NullPointerException \n \n");
			Paolo_board.removeFriend("Lavoro",null,"Silvio");
		}
		catch (NullPointerException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		try {
			System.out.println("Cerco di rimuovere Silvio dalla categoria Lavoro in Paolo_board con password sbagliata -> WrongPasswordException \n \n");
			Paolo_board.removeFriend("Lavoro","123","Silvio");
		}
		catch (WrongPasswordException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		try {
			System.out.println("Cerco di rimuovere Silvio dalla categoria inesistente Calcio in Paolo_board -> IllegalArgumentException \n \n");
			Paolo_board.removeFriend("Calcio","1234","Silvio");
		}
		catch (IllegalArgumentException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		try {
			System.out.println("Cerco di rimuovere l'amico inesistente Davide dalla categoria Lavoro in Paolo_board -> IllegalArgumentException \n \n");
			Paolo_board.removeFriend("Lavoro","1234","Davide");
		}
		catch (IllegalArgumentException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		
		
		
		System.out.println("Testo put");
		
		
		
		Data relazione = new MyData ("Relazione","Riscaldamento globale");
		System.out.println("Ho creato il dato" + relazione.display());
		Data riflessioni = new MyData ("Riflessioni","Sentimenti");
		System.out.println("Ho creato il dato" + riflessioni.display());

		try {
			System.out.println("Provo a inserire " + relazione.display() + " nella categoria null di Paolo_board -> NullPointerException \n \n");
			Paolo_board.put("1234", relazione, null);
		}
		catch (NullPointerException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		try {
			System.out.println("Provo a inserire " + relazione.display() + " nella categoria Lavoro di Paolo_board  con password null-> NullPointerException \n \n");
			Paolo_board.put(null, relazione, "Lavoro");
		}
		catch (NullPointerException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		
		try {
			System.out.println("Provo a inserire data null nella categoria Lavoro di Paolo_board -> NullPointerException \n \n");
			Paolo_board.put("1234", null, "Lavoro");
		}
		catch (NullPointerException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		try {
			System.out.println("Provo a inserire " + relazione.display() + " nella categoria Lavoro di Paolo_board  con password sbagliata-> WrongPasswordException \n \n");
			Paolo_board.put("12345", relazione, "Lavoro");
		}
		catch (WrongPasswordException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		try {
			System.out.println("Provo a inserire " + relazione.display() + " nella categoria inesistente Calcio di Paolo_board  -> IllegalArgumentException \n \n");
			Paolo_board.put("1234", relazione, "Calcio");
		}
		catch (IllegalArgumentException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		try {
			System.out.println("Provo a inserire " + relazione.display() + " nella categoria Lavoro di Paolo_board per 2 volte ! -> DataDuplicateException \n \n");
			Paolo_board.put("1234", relazione, "Lavoro");
			Paolo_board.put("1234", relazione, "Lavoro");
		}
		catch (DataDuplicateException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		
		
		System.out.println("Testo get");
		
		
		try {
			System.out.println("Provo a copiare "+ relazione.display() + "con password null -> NullPointerException \n \n");
			Data cloned = Paolo_board.get(null, relazione);
		}
		catch (NullPointerException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		try {
			System.out.println("Provo a copiare un dato null  -> NullPointerException \n \n");
			Data cloned = Paolo_board.get("1234", null);
		}
		catch (NullPointerException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		try {
			System.out.println("Provo a copiare "+ relazione.display() + "con password sbagliata -> WrongPasswordException \n \n");
			Data cloned = Paolo_board.get("12345", relazione);
		}
		catch (WrongPasswordException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		try {
			System.out.println("Provo a copiare "+ riflessioni.display() + "non contenuto in Paolo_board ! -> IllegalArgumentException \n \n");
			Data cloned = Paolo_board.get("1234", riflessioni);
		}
		catch (IllegalArgumentException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		
		
		
		
		System.out.println("Testo remove");
		
		
		
		try {
			System.out.println("Provo a rimuovere "+ relazione.display() + "da Paolo_board  con password null -> NullPointerException \n \n");
			Paolo_board.remove(null, relazione);
		}
		catch (NullPointerException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		Data data_null = null;
		try {
			System.out.println("Provo a rimuovere un dato null da Paolo_board  -> NullPointerException \n \n");
			Paolo_board.remove("1234", data_null);
		}
		catch (NullPointerException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		
		try {
			System.out.println("Provo a rimuovere "+ relazione.display() + "da Paolo_board  con password sbagliata -> WrongPasswordException \n \n");
			Paolo_board.remove("12344", relazione);
		}
		catch (WrongPasswordException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		
		try {
			System.out.println("Provo a rimuovere un dato inesistente : " + riflessioni.display() + " da Paolo_board  -> NullPointerException \n \n");
			Paolo_board.remove("1234", riflessioni);
		}
		catch (NullPointerException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		
		
		
		System.out.println("Testo getDataCategory");
		
		try {
			System.out.println("Provo ad ottenere una lista di dati di Paolo_board passando una categoria null-> NullPointerException \n \n");
			List<Data> list = Paolo_board.getDataCategory("1234", null);
		}
		catch (NullPointerException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		
		try {
			System.out.println("Provo ad ottenere una lista di dati di Paolo_board passando una password null-> NullPointerException \n \n");
			List<Data> list = Paolo_board.getDataCategory(null, "Lavoro");
		}
		catch (NullPointerException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		try {
			System.out.println("Provo ad ottenere una lista di dati della categoria Lavoro di Paolo_board con password sbagliata-> WrongPasswordException \n \n");
			List<Data> list = Paolo_board.getDataCategory("12345", "Lavoro");
		}
		catch (WrongPasswordException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		try {
			System.out.println("Provo ad ottenere una lista di una categoria vuota/inesistente di Paolo_board (Famiglia) -> IllegalArgumentException \n \n");
			List<Data> list = Paolo_board.getDataCategory("1234", "Famiglia");
		}
		catch (IllegalArgumentException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		
		try {
			System.out.println("Provo ad ottenere la lista della categoria Lavoro di Paolo_board -> NullPointerException \n \n");
			List<Data> list = Paolo_board.getDataCategory("1234", "Lavoro");
			System.out.println("Devo ottenere una lista contenente solo: " + relazione.display() + " ottengo : " );
			for (int i=0;i<list.size();i++){
				System.out.println(list.get(i).display());
			}
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		
		
		
		
		System.out.println("Testo insertLike");
		
		
		try {
			System.out.println("Provo a mettere like con friend = null in Paolo_board ->  NullPointerException \n \n");
			Paolo_board.insertLike(null, relazione);
		}
		catch (NullPointerException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		try {
			System.out.println("Provo a mettere like a un dato null in Paolo_board ->  NullPointerException \n \n");
			Paolo_board.insertLike("1234", null);
		}
		catch (NullPointerException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		try {
			System.out.println("Provo a mettere like a un dato a cui l'amico non ha accesso in Paolo_board ->  IllegalArgumentException \n \n");
			Paolo_board.addFriend("Famiglia", "1234", "Andrea");
			System.out.println("Ho aggiunto Andrea nella categoria Famiglia in Paolo_board");
			System.out.println("Andrea prova a mettere like a relazione :" + relazione.display()+ " che sta in categoria Lavoro !");
			Paolo_board.insertLike("Andrea", relazione);
		}
		catch (IllegalArgumentException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		
		try {
			System.out.println("Andrea prova a mettere like a riflessioni :" + riflessioni.display()+ " che non e' presente in Paolo_board!");
			Paolo_board.insertLike("Andrea", riflessioni);
		}
		catch (IllegalArgumentException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		try {
			System.out.println("Silvio che sta in categoria Lavoro mette like a relazione :" + relazione.display()+ "  in Paolo_board!");
			Paolo_board.insertLike("Silvio", relazione);
			System.out.println("Successo !" + relazione.display());

		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		
		
		
		System.out.println("Testo getIterator");
		
		
		
		try {		
			System.out.println("Chiamo getIterator con password = null -> NullPointerException \n");	
			Paolo_board.getIterator(null);
		}
		catch (NullPointerException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		try {		
			System.out.println("Chiamo getIterator con password sbagliata -> WrongPasswordException \n");	
			Paolo_board.getIterator("12334");
		}
		catch (WrongPasswordException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		
		
		
		
		System.out.println("Testo getFriendIterator");
		
		
		
		try {		
			System.out.println("Chiamo getFriendIterator con friend null in Paolo_board-> NullPointerException \n");	
			Paolo_board.getFriendIterator(null);
		}
		catch (NullPointerException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		
		
		try {		
			System.out.println("Chiamo getFriendIterator con friend Gianni inesistente in Paolo_board-> IllegalArgumentException \n");	
			Paolo_board.getFriendIterator("Gianni");
		}
		catch (IllegalArgumentException e) {
			System.out.println("OK");
			System.out.println(e);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}

		System.out.println("Test con dati validi su Paolo_board !");
		System.out.println("Aggiungo la categoria Film ");
		try {
			Paolo_board.createCategory("Film", "1234");
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		
		System.out.println("Aggiungo l'amica Jessica alla categoria Film");
		try {
			Paolo_board.addFriend("Film", "1234", "Jessica");
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		
		System.out.println("Aggiungo l'amico Mario alla categoria Lavoro");
		try {
			Paolo_board.addFriend("Lavoro", "1234", "Mario");
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		
		Data progetto = new MyData("Progetto","Disegni");
		System.out.println("Ho creato un nuovo dato Progetto " + progetto.display());
		Data estrattoConto = new MyData("Estratto Conto", "Tabelle");
		System.out.println("Ho creato un nuovo dato Estratto Conto " + estrattoConto.display());
		Data gita = new MyData ("Gita", "Fotografie");
		System.out.println("Ho creato un nuovo dato Gita " + gita.display());
		Data creed = new MyData ("Creed", "Video");
		System.out.println("Ho creato un nuovo dato Creed " + creed.display());
		Data got = new MyData ("Game of Thrones", "Video");
		System.out.println("Ho creato un nuovo dato GOT " + got.display());
		
		
		
		
		System.out.println("Aggiungo il dato Progetto a Lavoro");
		try {
			Paolo_board.put("1234",progetto, "Lavoro");
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		
		System.out.println("Aggiungo il dato Estratto Conto a Lavoro");
		try {
			Paolo_board.put("1234",estrattoConto, "Lavoro");
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		System.out.println("Aggiungo il dato Gita a Famiglia");
		try {
			Paolo_board.put("1234",gita, "Famiglia");
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		System.out.println("Aggiungo il dato Creed a Film");
		try {
			Paolo_board.put("1234",creed, "Film");
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		
		
		System.out.println("Aggiungo il dato GOT a Film");
		try {
			Paolo_board.put("1234",got, "Film");
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		
		System.out.println("Mario mette like a Progetto e a Estratto Conto");

		try {
			Paolo_board.insertLike("Mario", progetto);
			Paolo_board.insertLike("Mario", estrattoConto);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		
		System.out.println("Silvio mette like a Progetto");

		try {
			Paolo_board.insertLike("Silvio", progetto);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		System.out.println("Tutti i dati contenuti in bacheca ordinati per like sono:");
		System.out.println(" ");


		try {
			Iterator<Data> iter =Paolo_board.getIterator("1234");
			while (iter.hasNext()) {
				Data tmp = (Data) iter.next();
				System.out.println(tmp.getName());

			}
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		System.out.println("I dati disponibili a Mario sono :");
		System.out.println(" ");


		try {
			Iterator<Data> iter =Paolo_board.getFriendIterator("Mario");
			while (iter.hasNext()) {
				Data tmp = (Data) iter.next();
				System.out.println(tmp.getName());

			}
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		System.out.println("I dati disponibili ad Andrea sono :");
		System.out.println(" ");


		try {
			Iterator<Data> iter =Paolo_board.getFriendIterator("Andrea");
			while (iter.hasNext()) {
				Data tmp = (Data) iter.next();
				System.out.println(tmp.getName());

			}
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		
		System.out.println("I dati disponibili a Jessica sono :");
		System.out.println(" ");


		try {
			Iterator<Data> iter =Paolo_board.getFriendIterator("Jessica");
			while (iter.hasNext()) {
				Data tmp = (Data) iter.next();
				System.out.println(tmp.getName());

			}
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		System.out.println(" Aggiungo Mario, oltre che alla categoria Lavoro, anche alla categoria Film !");
		
		try {
			Paolo_board.addFriend("Film", "1234", "Mario");
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		System.out.println("Adesso i dati disponibili a Mario sono :");
		System.out.println(" ");


		try {
			Iterator<Data> iter =Paolo_board.getFriendIterator("Mario");
			while (iter.hasNext()) {
				Data tmp = (Data) iter.next();
				System.out.println(tmp.getName());

			}
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		System.out.println("Mario mette like per 3 volte a Creed ");
		try{
			Paolo_board.insertLike("Mario", creed);
			Paolo_board.insertLike("Mario", creed);
			Paolo_board.insertLike("Mario", creed);
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
		System.out.println(creed.display());
		
		System.out.println(" ");
		System.out.println("I dati della categoria Lavoro sono \n ");
		
		try {
			List<Data> datiLavoro = Paolo_board.getDataCategory("1234", "Lavoro");
			for (Data tmp : datiLavoro) {
				System.out.println(tmp.getName());
			}
		}
		catch (Exception err) {
			System.out.println("ERROR");
			System.out.println(err);
		}
	


		
		
		
		
		
		
		

		
	}
}