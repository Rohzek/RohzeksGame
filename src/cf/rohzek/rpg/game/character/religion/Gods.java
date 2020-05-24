package cf.rohzek.rpg.game.character.religion;

import java.util.Arrays;
import java.util.List;

public class Gods 
{
	public static God none = new God("None", "");
	public static God boccob = new God("Boccob", "God of magic, arcane knowledge, balance, and foresight.");
	public static God nerull = new God("Nerull", "God of death, darkness, murder, and the underworld.");
	public static God pelor = new God("Pelor", "God of sun, light, strength, and healing.");
	public static God ehlonna = new God("Ehlonna", "Goddess of forests, woodlands, flora & fauna, and fertility.");
	public static God erythnul = new God("Erythnul", "God of hate, envy, malice, panic, ugliness, and slaughter.");
	public static God fharlanghn = new God("Fharlanghn", "God of horizons, distance, travel, and roads.");
	public static God heironeous = new God("Heironeous", "God of chivalry, justice, honor, war, daring, and valor.");
	public static God hextor = new God("Hextor", "God of war, discord, massacres, conflict, fitness, tyranny.");
	public static God kord = new God("Kord", "God athletics, sports, brawling, strength, courage.");
	public static God obad_hai = new God("Obad-Hai", "God of nature, freedom, hunting, and beasts.");
	public static God olidammara = new God("Olidammara", "God of music, revels, wine, rogues, humor, and tricks.");
	public static God saint_cuthbert = new God("Saint Cuthbert", "God of common sense, wisdom, zeal, honesty, truth, and discipline.");
	public static God wee_jas = new God("Wee Jas", "Goddess of magic, death, vanity, and law.");
	
	private static God[] god = 
	{
			none,
			boccob,
			nerull,
			pelor,
			ehlonna,
			erythnul,
			fharlanghn,
			heironeous,
			hextor,
			kord,
			obad_hai,
			olidammara,
			saint_cuthbert,
			wee_jas,
	};
	
	public static List<God> GODS = Arrays.asList(god);
}
