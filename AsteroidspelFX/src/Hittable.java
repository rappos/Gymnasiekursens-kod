
//Ett gränssnitt som gör att objekt kan träffas av 
//t.ex. skott och rymdskepp
public interface Hittable {
	//Träffas objektret av given rektangel
	public boolean isHitBy(HitRectangle rect);
	
	//Visar antal poäng och påverkar objektet (det kanske försvinner och/
	//eller animerar en explosion) 
	public int getPointsAndHit();
}
