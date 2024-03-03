public class Card extends AbstractCard
{
    private int rank;
    private String suit;
    public Card(String rank, String suit)
    {
        this.rank = validateRank(rank);
        this.suit = validateSuit(suit);
    }

    public Card(int rank, String suit)
    {
        this.rank = isValidRank(rank);
        this.suit = validateSuit(suit);
    }

    private static String validateSuit(String suit)
    {
        for (String validSuit : SUITS)
        {
            if (validSuit.equals(suit))
            {
                return suit;
            }
        }
        return "invalid";
    }

    private static int validateRank(String rank)
    {
        for (int i = 0; i < RANKS.length; i++)
        {
            if (RANKS[i].equals(rank))
            {
                return i + 2;
            }
        }
        return 0;
    }

    private int isValidRank(int rank)
    {
        if (rank >= 2 && rank <= 15)
        {
            return rank;
        }
        return 0;
    }

    @Override
    public int getRankValue()
    {
        return this.rank;
    }

    @Override
    public String getRankString()
    {
        if(this.rank>=2 && this.rank<=15) return this.RANKS[rank-2];
        /*if (this.rank == 15)
        {
            return "Joker";
        }
        if (this.rank >= 2 && this.rank <= 10)
        {
            return String.valueOf(this.rank);
        }
        switch(this.rank)
        {
            case 11:
            {
                return "Jack";
            }
            case 12:
            {
                return "Queen";
            }
            case 13:
            {
                return "King";
            }
            case 14:
            {
                return "Ace";
            }
            default:
            {
                return "Invalid";
            }
        }*/
        return "Invalid";
    }

    @Override
    public String getSuit()
    {
        if (this.rank == 15)
        {
            return "Joker";
        }
        return this.suit;
    }

    @Override
    public int compareTo(AbstractCard num)
    {
        if (!(num instanceof Card))
        {
            return -1; //
        }
        Card other = (Card) num;
        if (this.rank == 15 && other.rank != 15)
        {
            return 1; // Joker is higher than any other card
        }
        if (this.rank != 15 && other.rank == 15)
        {
            return -1; // Any card is lower than Joker
        }
        int suitComparison = this.suit.compareTo(other.getSuit());

        if (suitComparison != 0)
        {
            if (suitComparison < 0)
            {
                return -1; // return -1 for a lesser suit
            }
            else
            {
                return 1; // return 1 for a greater suit
            }
        }

        // Adjusting this part to return -1 or 1 based on rank comparison
        if (this.rank < other.rank)
        {
            return -1; // return -1 for a lesser rank
        }
        else if (this.rank > other.rank)
        {
            return 1; // return 1 for a greater rank
        }
        else
        {
            return 0; // Equal ranks
}
        }

    public static void main(String[] args)
    {
        Card queen = new Card("Queen", "Diamonds");
        System.out.println( queen.getRankValue() ); //prints 12
        System.out.println( queen.getRankString() ); //prints Queen
        System.out.println( queen.getSuit() ); //prints "Diamonds"
        System.out.println( queen ); //prints 12D
        Card four = new Card("4", "Spades");
        System.out.println( queen.compareTo(four) ); //prints negative int value
        System.out.println( four.compareTo(queen) ); //prints a positive int value
        Card jack = new Card("Jack", "Spades");
        System.out.println( four.compareTo(jack) ); //prints a negative int value
        System.out.println( jack.compareTo(jack) ); //prints 0
        System.out.println( jack.getRankValue() ); //prints 11
        System.out.println( jack.getSuit() ); //prints "Spades"
        Card joker = new Card("Joker", "Joker");
        System.out.println( joker ); //prints 15J
        System.out.println( joker.getRankValue() ); //prints 15
        System.out.println( joker.getSuit() ); //prints "Joker"
        System.out.println( jack.compareTo(joker) ); //prints a negative int value
    }
}