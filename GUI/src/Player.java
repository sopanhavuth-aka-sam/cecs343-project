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
	private Hand playerHand;
	private int location, QP, learningPts, craftPts, integrityPts, year, drawPos;
	
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
	
	public Hand getHand(){
		return this.playerHand;
	}
	
	/**
	 * 
	 * @param newLoc
	 */
	public void setLoc(int newLoc) {
		this.location = newLoc;
	}
	
	public void setHand(Hand player){
		this.playerHand = player;
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
}
