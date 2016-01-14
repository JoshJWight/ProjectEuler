package problem051_060;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem54 {

	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get("poker.txt"));
		
		int num = 0;
		for(String l: lines) {
			if(p1Wins(l)) {
				num++;
			}
		}
		System.out.println(num);

	}
	
	public static boolean p1Wins(String input) {
		String cards[] = input.split(" ");
		ArrayList<Card> p1Cards = new ArrayList<Card>();
		ArrayList<Card> p2Cards = new ArrayList<Card>();
		for(int i=0; i<5; i++) {
			p1Cards.add(new Card(cards[i]));
		} for(int i=5; i<10; i++) {
			p2Cards.add(new Card(cards[i]));
		}
		Collections.sort(p1Cards);
		Collections.sort(p2Cards);
		
		Rank r1 = getRank(p1Cards);
		Rank r2 = getRank(p2Cards);
		
		if(r1.v>r2.v) {
			return true;
		} else if(r2.v>r1.v) {
			return false;
		} else {
			switch(r1) {
			case HIGHCARD:
			case STRAIGHT:
			case STRAIGHTFLUSH:
			case FLUSH:{
				for(int i=4; i>=0; i--) {
					Card c1 = p1Cards.get(i);
					Card c2 = p2Cards.get(i);
					if(c1.value>c2.value) {
						return true;
					} else if(c2.value>c1.value) {
						return false;
					}
				}
				System.out.println("NO CLEAR WINNER: " + input);
				return false;
			}
			case PAIR:{
				int p1=0;
				int p2=0;
				
				for(int i=0; i<4; i++) {
					if(p1Cards.get(i).value==p1Cards.get(i+1).value) {
						p1=p1Cards.get(i).value;
					}
					if(p2Cards.get(i).value==p2Cards.get(i+1).value) {
						p2=p1Cards.get(i).value;
					}
				}
				if(p1!=p2) {
					return p1>p2;
				}
				
				///
				for(int i=4; i>=0; i--) {
					Card c1 = p1Cards.get(i);
					Card c2 = p2Cards.get(i);
					if(c1.value>c2.value) {
						return true;
					} else if(c2.value>c1.value) {
						return false;
					}
				}
				System.out.println("NO CLEAR WINNER: " + input);
				return false;
			}
			case TWOPAIR:{
				int p1=0;
				int p2=0;
				int t1=0;
				int t2=0;
				
				for(int i=0; i<4; i++) {
					if(p1Cards.get(i).value==p1Cards.get(i+1).value) {
						if(p1>0) {
							t1=p1Cards.get(i).value;
						} else {
							p1=p1Cards.get(i).value;
						}
					}
					if(p2Cards.get(i).value==p2Cards.get(i+1).value) {
						if(p1>0) {
							t2=p2Cards.get(i).value;
						} else {
							p2=p2Cards.get(i).value;
						}
					}
				}
				
				if(t1!=t2) {
					return t1>t2;
				}
				if(p1!=p2) {
					return p1>p2;
				}
				
				///
				for(int i=4; i>=0; i--) {
					Card c1 = p1Cards.get(i);
					Card c2 = p2Cards.get(i);
					if(c1.value>c2.value) {
						return true;
					} else if(c2.value>c1.value) {
						return false;
					}
				}
				System.out.println("NO CLEAR WINNER: " + input);
				return false;
			}
			case THREE:{
				int t1 = p1Cards.get(2).value;
				int t2 = p2Cards.get(2).value;
				if(t1>t2) {
					return true;
				} else if(t2>t1) {
					return false;
				} 
				
				///
				for(int i=4; i>=0; i--) {
					Card c1 = p1Cards.get(i);
					Card c2 = p2Cards.get(i);
					if(c1.value>c2.value) {
						return true;
					} else if(c2.value>c1.value) {
						return false;
					}
				}
				System.out.println("NO CLEAR WINNER: " + input);
				return false;
			}
			case FULLHOUSE:
			case FOUR:{
				int t1 = p1Cards.get(2).value;
				int t2 = p2Cards.get(2).value;
				if(t1>t2) {
					return true;
				} else if(t2>t1) {
					return false;
				} 
				
				if(p1Cards.get(4).value!=p2Cards.get(4).value) {
					return p1Cards.get(4).value > p2Cards.get(4).value;
				}
				
				return p1Cards.get(0).value > p2Cards.get(0).value;
				
			}
			
			}
		}
		System.out.println("NO CLEAR WINNER: " + input);
		return false;
	}
	
	public static Rank getRank(ArrayList<Card> hand) {
		Card c1 = hand.get(0);
		Card c2 = hand.get(1);
		Card c3 = hand.get(2);
		Card c4 = hand.get(3);
		Card c5 = hand.get(4);
		
		boolean straight=(c1.value+1==c2.value && c2.value+1==c3.value && c3.value+1==c4.value && c4.value+1==c5.value);
		boolean flush = (c1.suit==c2.suit && c1.suit==c3.suit && c1.suit==c4.suit && c1.suit==c5.suit);
		
		if(straight&&flush) {
			return Rank.STRAIGHTFLUSH;
		}
		
		if(c2.value==c3.value && c3.value==c4.value && (c1.value==c2.value || c4.value==c5.value)) {
			return Rank.FOUR;
		}
		
		boolean three = false;
		int threeIndex = 0;
		for(int i=0; i<3; i++) {
			if(hand.get(i).value==hand.get(i+1).value && hand.get(i).value==hand.get(i+2).value) {
				three=true;
				threeIndex=i;
				break;
			}
		}
		
		if(three) {
			if(threeIndex==0) {
				if(hand.get(3).value==hand.get(4).value) {
					return Rank.FULLHOUSE;
				}
			} else if(threeIndex==2) {
				if(hand.get(0).value==hand.get(1).value) {
					return Rank.FULLHOUSE;
				}
			}
		}
		
		if(flush) {
			return Rank.FLUSH;
		}
		
		if(straight) {
			return Rank.STRAIGHT;
		}
		
		if(three) {
			return Rank.THREE;
		}
		
		int numPairs = 0;
		
		for(int i=0; i<4; i++) {
			if(hand.get(i).value==hand.get(i+1).value) {
				numPairs++;
				i++;
			}
		}
		
		if(numPairs==2) {
			return Rank.TWOPAIR;
		} else if(numPairs==1) {
			return Rank.PAIR;
		} else {
			return Rank.HIGHCARD;
		}
	}
	
	public enum Rank {
		HIGHCARD(0),
		PAIR(1),
		TWOPAIR(2),
		THREE(3),
		STRAIGHT(4),
		FLUSH(5),
		FULLHOUSE(6),
		FOUR(7),
		STRAIGHTFLUSH(8);
		
		public Integer v;
		private Rank(Integer v) {
			this.v=v;
		}
	}

	public enum Suit{
		CLUBS,
		HEARTS,
		SPADES,
		DIAMONDS
	}
	public static class Card implements Comparable{
		public Suit suit;
		public Integer value;
		public Card(String input) {
			String v = input.substring(0, 1);
			String s = input.substring(1);
			
			switch(s) {
			case "C":suit=Suit.CLUBS;break;
			case "H":suit=Suit.HEARTS;break;
			case "D":suit=Suit.DIAMONDS;break;
			case "S":suit=Suit.SPADES;break;
			default:System.out.println("Invalid suit " + s);
			}
			
			switch(v) {
			case "A":value=14;break;
			case "K":value=13;break;
			case "Q":value=12;break;
			case "J":value=11;break;
			case "T":value=10;break;
			default:value=Integer.valueOf(v);
			}
		}
		
		public int compareTo(Object other) {
			if(other instanceof Card) {
				Card c = (Card) other;
				return value.compareTo(c.value);
			} else {
				return 0;
			}
		}
		
	}
}
