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
	
	public Player(String name, int location, int QP, int learning, int craft,
			int integrity, int year, int drawPos) {
		this.name = name;
		this.location = location;
		this.QP = QP;
		this.learningPts = learning;
		this.craftPts = craft;
		this.integrityPts = integrity;
		this.year = year;
		this.drawPos = drawPos;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getLoc() {
		return this.location;
	}
	
	public int getQP() {
		return this.QP;
	}
	
	public int getLearningPts() {
		return this.learningPts;
	}
	
	public int getCraftPts() {
		return this.craftPts;
	}
	
	public int getIntegrityPts() {
		return this.integrityPts;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public int getDrawPos() {
		return this.drawPos;
	}
	
	public void setLoc(int newLoc) {
		this.location = newLoc;
	}
	
	public void updateQP(int addedQP) {
		this.QP -= addedQP;
	}
	
	public void updateLearningPts(int addedPts) {
		this.learningPts -= addedPts;
	}
	
	public void updateCraftPts(int addedPts) {
		this.craftPts -= addedPts;
	}
	
	public void updateIntegrityPts(int addedPts){
		this.integrityPts -= addedPts;
	}
	
	public void setYear(int newYear) {
		this.year = newYear;
	}
}
