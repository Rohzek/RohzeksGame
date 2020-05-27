package cf.rohzek.rpg.game.character.religion;

import java.util.Arrays;
import java.util.List;

public class Gods 
{
	public static God NONE = new God("None", "");
	public static God BOCCOB = new God("Boccob", "God of magic, arcane knowledge, balance, and foresight.");
	public static God NERULL = new God("Nerull", "God of death, darkness, murder, and the underworld.");
	public static God PELOR = new God("Pelor", "God of sun, light, strength, and healing.");
	public static God EHLONNA = new God("Ehlonna", "Goddess of forests, woodlands, flora & fauna, and fertility.");
	public static God ERYTHNUL = new God("Erythnul", "God of hate, envy, malice, panic, ugliness, and slaughter.");
	public static God FHARLANGHN = new God("Fharlanghn", "God of horizons, distance, travel, and roads.");
	public static God HEIRONEOUS = new God("Heironeous", "God of chivalry, justice, honor, war, daring, and valor.");
	public static God HEXTOR = new God("Hextor", "God of war, discord, massacres, conflict, fitness, tyranny.");
	public static God KORD = new God("Kord", "God athletics, sports, brawling, strength, courage.");
	public static God OBAD_HAI = new God("Obad-Hai", "God of nature, freedom, hunting, and beasts.");
	public static God OLIDAMMARA = new God("Olidammara", "God of music, revels, wine, rogues, humor, and tricks.");
	public static God SAINT_CUTHBERT = new God("Saint Cuthbert", "God of common sense, wisdom, zeal, honesty, truth, and discipline.");
	public static God WEE_JAS = new God("Wee Jas", "Goddess of magic, death, vanity, and law.");
	
	private static God[] gods = 
	{
			NONE,
			BOCCOB,
			NERULL,
			PELOR,
			EHLONNA,
			ERYTHNUL,
			FHARLANGHN,
			HEIRONEOUS,
			HEXTOR,
			KORD,
			OBAD_HAI,
			OLIDAMMARA,
			SAINT_CUTHBERT,
			WEE_JAS,
	};
	
	public static List<God> GODS = Arrays.asList(gods);
}
