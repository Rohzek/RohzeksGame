package cf.rohzek.rpg.game.character.alignment;

import java.util.Arrays;
import java.util.List;

public class Alignments 
{
	public static Alignment lawful_good = new Alignment("Lawful Good", "The Crusader", "A lawful good character acts as a good person is expected or required to act. He combines a commitment to oppose evil with the discipline to fight relentlessly. He tells the truth, keeps his word, helps those in need, and speaks out against injustice. A lawful good character hates to see the guilty go unpunished.");
	public static Alignment lawful_neutral = new Alignment("Lawful Neutral", "The Judge", "A lawful neutral character acts as law, tradition, or a personal code directs her. Order and organization are paramount to her. She may believe in personal order and live by a code or standard, or she may believe in order for all and favor a strong, organized government.");
	public static Alignment lawful_evil = new Alignment("Lawful Evil", "The Dominator", "A lawful evil villain methodically takes what he wants within the limits of his code of conduct without regard for whom it hurts. He cares about tradition, loyalty, and order but not about freedom, dignity, or life. He plays by the rules but without mercy or compassion. He is comfortable in a hierarchy and would like to rule, but is willing to serve. He condemns others not according to their actions but according to race, religion, homeland, or social rank. He is loath to break laws or promises.");
	
	public static Alignment neutral_good = new Alignment("Neutral Good", "The Benefactor", "A neutral good character does the best that a good person can do. He is devoted to helping others. He works with kings and magistrates but does not feel beholden to them.");
	public static Alignment neutral_neutral = new Alignment("Neutral", "The Undecided", "A neutral character does what seems to be a good idea. She doesn't feel strongly one way or the other when it comes to good vs. evil or law vs. chaos. Most neutral characters exhibit a lack of conviction or bias rather than a commitment to neutrality. Such a character thinks of good as better than evil-after all, she would rather have good neighbors and rulers than evil ones. Still, she's not personally committed to upholding good in any abstract or universal way.");
	public static Alignment neutral_evil = new Alignment("Neutral Evil", "The Malefactor", "A neutral evil villain does whatever she can get away with. She is out for herself, pure and simple. She sheds no tears for those she kills, whether for profit, sport, or convenience. She has no love of order and holds no illusion that following laws, traditions, or codes would make her any better or more noble. On the other hand, she doesn't have the restless nature or love of conflict that a chaotic evil villain has.");
	
	public static Alignment chaotic_good = new Alignment("Chaotic Good", "The Rebel", "A chaotic good character acts as his conscience directs him with little regard for what others expect of him. He makes his own way, but he's kind and benevolent. He believes in goodness and right but has little use for laws and regulations. He hates it when people try to intimidate others and tell them what to do. He follows his own moral compass, which, although good, may not agree with that of society.");
	public static Alignment chaotic_neutral = new Alignment("Chaotic Neutral", "The Free Spirit", "A chaotic neutral character follows his whims. He is an individualist first and last. He values his own liberty but doesn't strive to protect others' freedom. He avoids authority, resents restrictions, and challenges traditions. A chaotic neutral character does not intentionally disrupt organizations as part of a campaign of anarchy. To do so, he would have to be motivated either by good (and a desire to liberate others) or evil (and a desire to make those different from himself suffer). A chaotic neutral character may be unpredictable, but his behavior is not totally random. He is not as likely to jump off a bridge as to cross it.");
	public static Alignment chaotic_evil = new Alignment("Chaotic Evil", "The Destroyer", "A chaotic evil character does whatever his greed, hatred, and lust for destruction drive him to do. He is hot-tempered, vicious, arbitrarily violent, and unpredictable. If he is simply out for whatever he can get, he is ruthless and brutal. If he is committed to the spread of evil and chaos, he is even worse. Thankfully, his plans are haphazard, and any groups he joins or forms are poorly organized. Typically, chaotic evil people can be made to work together only by force, and their leader lasts only as long as he can thwart attempts to topple or assassinate him.");
	
	
	
	private static Alignment[] alignments = 
	{
		lawful_good,
		lawful_neutral,
		lawful_evil,
		neutral_good,
		neutral_neutral,
		neutral_evil,
		chaotic_good,
		chaotic_neutral,
		chaotic_evil,
	};
	
	public static List<Alignment> ALIGNMENTS = Arrays.asList(alignments);
}
