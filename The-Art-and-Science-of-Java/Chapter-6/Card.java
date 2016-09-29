
public class Card {
	
	public Card( String a, int n) {
		
		suit = a ;
		rank = n ;
		
	}
	
	public String getSuit() {
		
		return suit;
	}
	
	public int getRank() {	
		
		return rank;
		
	}
	
	public String  toString() {
		
		String r;
		switch(rank) {
		case 1: r = "Ace";
		case 11: r = "Jack";
		case 12: r= "Queen";
		case 13: r = "King";
		default: r = "Error";
		
		return r + " of " + suit;
		
		}
		
	}
	
	
	private String suit;
	private int rank;
	

}
