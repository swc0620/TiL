import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Genre, Title 을 관리하는 영화 데이터베이스.
 * 
 * MyLinkedList 를 사용해 각각 Genre와 Title에 따라 내부적으로 정렬된 상태를  
 * 유지하는 데이터베이스이다. 
 */
public class MovieDB {
	MyLinkedList<MyLinkedList<MovieDBItem>> GenreMyLinkedList;
    public MovieDB() {
        // FIXME implement this
		GenreMyLinkedList = new MyLinkedList<MyLinkedList<MovieDBItem>>();
		GenreMyLinkedList.numItems = 0;
    	// HINT: MovieDBGenre 클래스를 정렬된 상태로 유지하기 위한 
    	// MyLinkedList 타입의 멤버 변수를 초기화 한다.
    }

    public void insert(MovieDBItem item) {
        // FIXME implement this
		// Insert the given item to the MovieDB.
		
		if(GenreMyLinkedList.isEmpty()){
			MyLinkedList<MovieDBItem> ItemLinkedList = new MyLinkedList<MovieDBItem>();
			GenreMyLinkedList.add(ItemLinkedList);
			ItemLinkedList.add(item);
			// System.out.println("Passed here 0");
			// System.out.println(GenreMyLinkedList.size());
		} else {
			GenreMyLinkedList.setfirst();
			GenreMyLinkedList.moveNext();
			loop:
			for(int i = 0; i < GenreMyLinkedList.size(); i++){
				// System.out.println(GenreMyLinkedList.size());
				if(GenreMyLinkedList.returncurr().getItem().first().getGenre().equals(item.getGenre())){
					// System.out.println("Passed here 1");
					// System.out.println(GenreMyLinkedList.returncurr().getItem().size());
					GenreMyLinkedList.returncurr().getItem().setfirst();
					for(int j = 0; j < GenreMyLinkedList.returncurr().getItem().size(); j++){
						if(GenreMyLinkedList.returncurr().getItem().next().getTitle().equals(item.getTitle())){
							break loop;
						}
					}
					GenreMyLinkedList.returncurr().getItem().setfirst();
					for(int j = 0; j < GenreMyLinkedList.returncurr().getItem().size(); j++){
						if(GenreMyLinkedList.returncurr().getItem().next().getTitle().compareTo(item.getTitle()) > 0){
							GenreMyLinkedList.returncurr().getItem().addHere(item);
							break loop;
						}
					}
					GenreMyLinkedList.returncurr().getItem().add(item);
					// System.out.println(GenreMyLinkedList.size());
					// System.out.println(GenreMyLinkedList.returncurr().getItem().size());
				} else {
					if(GenreMyLinkedList.hasNext()){
						MyLinkedList<MovieDBItem> newItemLinkedList = new MyLinkedList<MovieDBItem>();
						if(GenreMyLinkedList.returncurr().getItem().first().getGenre().compareTo(item.getGenre()) > 0){
							// System.out.println("entered here 0");
							GenreMyLinkedList.addHere(newItemLinkedList);
							newItemLinkedList.add(item);
							break;
						}
						// System.out.println("Passed here 2");
						// System.out.println(GenreMyLinkedList.size());
						// System.out.println(GenreMyLinkedList.returncurr().getItem().size());
						GenreMyLinkedList.moveNext();
					} else {
						// System.out.println("Passed here 3");
						MyLinkedList<MovieDBItem> newItemLinkedList = new MyLinkedList<MovieDBItem>();
						if(GenreMyLinkedList.returncurr().getItem().first().getGenre().compareTo(item.getGenre()) > 0){
							// System.out.println("entered here 1");
							GenreMyLinkedList.addHere(newItemLinkedList);
							newItemLinkedList.add(item);
							break;
						}
						GenreMyLinkedList.add(newItemLinkedList);
						newItemLinkedList.add(item);
						// System.out.println(GenreMyLinkedList.size());
						// System.out.println(newItemLinkedList.size());
						break;
					}	
				}
			}		
		}

    	// Printing functionality is provided for the sake of debugging.
		// This code should be removed before submitting your work.
        // System.err.printf("[trace] MovieDB: INSERT [%s] [%s]\n", item.getGenre(), item.getTitle());
    }

    public void delete(MovieDBItem item) {
        // FIXME implement this
        // Remove the given item from the MovieDB.
    	if(!GenreMyLinkedList.isEmpty()){
			GenreMyLinkedList.setfirst();
			GenreMyLinkedList.moveNext();
			loop:
			for(int i = 0; i < GenreMyLinkedList.size(); i++){
				// System.out.println("Passed here 0");
				if(GenreMyLinkedList.returncurr().getItem().first().getGenre().equals(item.getGenre())){
					// System.out.println("Passed here 1");
					GenreMyLinkedList.returncurr().getItem().setfirst();
					for(int j = 0; j < GenreMyLinkedList.returncurr().getItem().size(); j++){
						// System.out.println(GenreMyLinkedList.returncurr().getItem().size());
						if(GenreMyLinkedList.returncurr().getItem().next().getTitle().equals(item.getTitle())){
							// System.out.println("Passed here 2");
							GenreMyLinkedList.returncurr().getItem().remove();
							// System.out.println(GenreMyLinkedList.returncurr().getItem().size());
							break loop;
						} else {
							// System.out.println("Passed here 3");
							// GenreMyLinkedList.returncurr().getItem().moveNext();
							// System.out.println(GenreMyLinkedList.returncurr().getItem().size());
						}
					}
				} else {
					// System.out.println("Passed here 4");
					if(GenreMyLinkedList.hasNext()){
						GenreMyLinkedList.moveNext();
						// System.out.println("Passed here 5");
					} else {
						// System.out.println("Passed here 6");
						break;
					}
				}
			}
			for(int i = 0; i < GenreMyLinkedList.size(); i++){
				// System.out.println("passed here 1");
				// System.out.println(GenreMyLinkedList.returncurr().getItem().size());
				if(GenreMyLinkedList.returncurr().getItem().size() == 0){
					// System.out.println("passed here 2");
					GenreMyLinkedList.remove();
					break;
				}
			}	
		}		
    	// Printing functionality is provided for the sake of debugging.
        // This code should be removed before submitting your work.
        // System.err.printf("[trace] MovieDB: DELETE [%s] [%s]\n", item.getGenre(), item.getTitle());
    }

    public MyLinkedList<MyLinkedList<MovieDBItem>> search(String term) {
        // FIXME implement this
        // Search the given term from the MovieDB.
        // You should return a linked list of MovieDBItem.
		// The search command is handled at SearchCmd class.
		
		MyLinkedList<MyLinkedList<MovieDBItem>> SearchMyLinkedList = new MyLinkedList<MyLinkedList<MovieDBItem>>();
		GenreMyLinkedList.setfirst();
		

		for(int i = 0; i < GenreMyLinkedList.size(); i++){
			GenreMyLinkedList.moveNext();
			// System.out.println(GenreMyLinkedList.size());
			if(GenreMyLinkedList.returncurr().getItem().first().getGenre().contains(term)){
				MyLinkedList<MovieDBItem> ItemMyLinkedList = GenreMyLinkedList.returncurr().getItem();
				SearchMyLinkedList.add(ItemMyLinkedList);
				// System.out.println(GenreMyLinkedList.returncurr().getItem().first().getGenre());
				break;
			}
		}	

		GenreMyLinkedList.setfirst();
		

		for(int i = 0; i < GenreMyLinkedList.size(); i++){
			GenreMyLinkedList.moveNext();
			// System.out.println(GenreMyLinkedList.size());
			// System.out.println("enters here 0");
			// System.out.println(GenreMyLinkedList.returncurr().getItem().first().getGenre());
			if(!GenreMyLinkedList.returncurr().getItem().first().getGenre().contains(term)){
				GenreMyLinkedList.returncurr().getItem().setfirst();
				// System.out.println("enters here 1");
				for(int j = 0; j < GenreMyLinkedList.returncurr().getItem().size(); j++){
					// System.out.println("enters here 2");
					if(GenreMyLinkedList.returncurr().getItem().next().getTitle().contains(term)){
						// System.out.println("enters here 3");
						// System.out.println(GenreMyLinkedList.returncurr().getItem().curritem().getTitle());
						MyLinkedList<MovieDBItem> ItemMyLinkedList = new MyLinkedList<MovieDBItem>();
						ItemMyLinkedList.add(GenreMyLinkedList.returncurr().getItem().curritem());
						SearchMyLinkedList.add(ItemMyLinkedList);
					}	
				}	
			}
		}	
    	// Printing search results is the responsibility of SearchCmd class. 
    	// So you must not use System.out in this method to achieve specs of the assignment.
    	
        // This tracing functionality is provided for the sake of debugging.
        // This code should be removed before submitting your work.
    	// System.err.printf("[trace] MovieDB: SEARCH [%s]\n", term);
    	
    	// FIXME remove this code and return an appropriate MyLinkedList<MovieDBItem> instance.
    	// This code is supplied for avoiding compilation error.   
		// MyLinkedList<MovieDBItem> results = new MyLinkedList<MovieDBItem>();
		
		MyLinkedList<MyLinkedList<MovieDBItem>> results = SearchMyLinkedList;

        return results;
    }
    
    public MyLinkedList<MyLinkedList<MovieDBItem>> items() {
        // FIXME implement this
        // Search the given term from the MovieDatabase.
        // You should return a linked list of QueryResult.
        // The print command is handled at PrintCmd class.
    	// Printing movie items is the responsibility of PrintCmd class. 
    	// So you must not use System.out in this method to achieve specs of the assignment.

    	// Printing functionality is provided for the sake of debugging.
        // This code should be removed before submitting your work.
        // System.err.printf("[trace] MovieDB: ITEMS\n");

    	// FIXME remove this code and return an appropriate MyLinkedList<MovieDBItem> instance.
    	// This code is supplied for avoiding compilation error.   
        MyLinkedList<MyLinkedList<MovieDBItem>> results = GenreMyLinkedList;
		
		// MyLinkedList<MovieDBItem> results = new MyLinkedList<MovieDBItem>();
    	return results;
    }
}

class Genre extends Node<String> implements Comparable<Genre> {
	public Genre(String name) {
		super(name);
		throw new UnsupportedOperationException("not implemented yet");
	}
	
	@Override
	public int compareTo(Genre o) {
		throw new UnsupportedOperationException("not implemented yet");
	}

	@Override
	public int hashCode() {
		throw new UnsupportedOperationException("not implemented yet");
	}

	@Override
	public boolean equals(Object obj) {
		throw new UnsupportedOperationException("not implemented yet");
	}
}

class MovieList implements ListInterface<String> {	
	public MovieList() {
	}

	@Override
	public Iterator<String> iterator() {
		throw new UnsupportedOperationException("not implemented yet");
	}

	@Override
	public boolean isEmpty() {
		throw new UnsupportedOperationException("not implemented yet");
	}

	@Override
	public int size() {
		throw new UnsupportedOperationException("not implemented yet");
	}

	@Override
	public void add(String item) {
		throw new UnsupportedOperationException("not implemented yet");
	}

	@Override
	public String first() {
		throw new UnsupportedOperationException("not implemented yet");
	}

	@Override
	public void removeAll() {
		throw new UnsupportedOperationException("not implemented yet");
	}
}