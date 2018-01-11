package DeckOfCards;

public class Deck {
	
	private String[] deck = new String[52];
	
	public Deck(){
		String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};
		String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
		
		for(int i = 0; i < deck.length; i++){
			if(i < 13)
				deck[i] = ranks[i] + " of " + suits[0];
			else if(i < 26)
				deck[i] = ranks[i - 13] + " of " + suits[1];
			else if(i < 39)
				deck[i] = ranks[i - 26] + " of " + suits[2];
			else
				deck[i] = ranks[i - 39] + " of " + suits[3];
		}
	}
	
	public String cardAt(int n){
		return(deck[n - 1]);
	}
}
