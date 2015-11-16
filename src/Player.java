import java.awt.Image;
import java.util.ArrayList;

/**
 * 
 * @author sam
 *
 */
public class Player {
	
	/**
	 * 
	 */
	private String name;
	private int location, QP, learningPts, craftPts, integrityPts, year, drawPos;
	private ArrayList<Card> hand = new ArrayList<Card>();
	
	/**
	 * 
	 * @param name
	 * @param location
	 * @param QP
	 * @param learning
	 * @param craft
	 * @param integrity
	 * @param year
	 * @param drawPos
	 */
	public Player(String name, int location, int learning, int craft,
			int integrity, int QP, int year, int drawPos) {
		this.name = name;
		this.location = location;
		this.QP = QP;
		this.learningPts = learning;
		this.craftPts = craft;
		this.integrityPts = integrity;
		this.year = year;
		this.drawPos = drawPos;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getLoc() {
		return this.location;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getQP() {
		return this.QP;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getLearningPts() {
		return this.learningPts;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getCraftPts() {
		return this.craftPts;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getIntegrityPts() {
		return this.integrityPts;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getYear() {
		return this.year;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getDrawPos() {
		return this.drawPos;
	}
	
	/**
	 * 
	 * @param newLoc
	 */
	public void setLoc(int newLoc) {
		this.location = newLoc;
	}
	
	/**
	 * 
	 * @param addedQP
	 */
	public void updateQP(int addedQP) {
		this.QP += addedQP;
	}
	
	/**
	 * 
	 * @param addedPts
	 */
	public void updateLearningPts(int addedPts) {
		this.learningPts += addedPts;
	}
	
	/**
	 * 
	 * @param addedPts
	 */
	public void updateCraftPts(int addedPts) {
		this.craftPts += addedPts;
	}
	
	/**
	 * 
	 * @param addedPts
	 */
	public void updateIntegrityPts(int addedPts){
		this.integrityPts += addedPts;
	}
	
	/**
	 * 
	 * @param newYear
	 */
	public void setYear(int newYear) {
		this.year = newYear;
	}
	
	public String toString() {
		return String.format("%s is at %d has learning: %d, craft: %d, integrity: %d\n"
				+ "QP: %d, draw Position: %d, Year: %d", name, location, learningPts, craftPts,
				integrityPts, QP, drawPos, year);
	}
	
	public void addCard(Card newCard) {
		hand.add(newCard);
	}
	
	public void removeCard(int index) {
		hand.remove(index);
	}
	
	public Image getCardImage(int index) {
		return hand.get(index).getImg();
	}
}
