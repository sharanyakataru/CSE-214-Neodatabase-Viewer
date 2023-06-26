import java.util.Date;

public class NearEarthObject {
    private int referenceID;
    private String name;
    private double absoluteMagnitude;
    private double averageDiameter;
    private boolean isDangerous;
    private Date closestApproachDate;
    private double missDistance;
    private String orbitingBody;

    public NearEarthObject(int referenceID, String name, double absoluteMagnitude, double minDiameter,
                           double maxDiameter, boolean isDangerous, long closestDateTimestamp, double missDistance, String orbitingBody){
        this.referenceID = referenceID;
        this.name = name;
        this.absoluteMagnitude = absoluteMagnitude;
        this.isDangerous = isDangerous;
        this.closestApproachDate = new Date(closestDateTimestamp);
        this.missDistance = missDistance;
        this.orbitingBody = orbitingBody;
        this.averageDiameter = (minDiameter + maxDiameter) / 2.0;
    }

    /**
     * @return
     * the unique iD of the NEO
     */
    public int getReferenceID() {
        return referenceID;
    }

    /**
     * @param reference
     * id of the NEO
     */
    public void setReferenceID(int reference) {
        this.referenceID = reference;
    }

    /**
     * @return
     * unique name of the asteroid or orbital body
     */
    public String getName(){
        return name;
    }

    /**
     * @param name
     * the name of the orbital body/ asteroid
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     * absolute brightness of the orbital body in the sky
     */
    public double getAbsoluteMagnitude(){
        return absoluteMagnitude;
    }

    /**
     * @param absoluteMagnitude
     * the brightness of the asteroid or orbital body in the sky
     */
    public void setAbsoluteMagnitude(double absoluteMagnitude) {
        this.absoluteMagnitude = absoluteMagnitude;
    }

    /**
     * @return
     *the average diameter in km
     */
    public double getAverageDiameter() {
        return averageDiameter;
    }

    /**
     * @param averageDiameter
     * the average diameter of the asteroid or orbital body
     */
    public void setAverageDiameter(double averageDiameter){
        this.averageDiameter = averageDiameter;
    }

    /**
     * @return
     * boolean value indicating if the asteroid or orbital body is a potential impact threat
     */
    public boolean getIsDangerous(){
        return isDangerous;
    }

    /**
     * @param isDangerous
     * true or false depending on if the asteroid or orbital body is a potential threat
     */
    public void setIsDangerous(boolean isDangerous){
        this.isDangerous = isDangerous;
    }

    /**
     * @return
     * Unix timestamp representing the date of closest approach
     */
    public Date getClosestApproachDate(){
        return closestApproachDate;
    }

    /**
     * @param closestApproachDate
     * date of closest approach of the asteroid or orbital body
     */
    public void setClosestApproachDate(Date closestApproachDate){
        this.closestApproachDate = closestApproachDate;
    }

    /**
     * @return
     * distance in km that the orbital or asteroid will pass by the Earth on the date of closest approach
     */
    public double getMissDistance() {
        return missDistance;
    }

    /**
     * @param missDistance
     * distance in km that the asteroid or orbital body will pass by the Earth
     */
    public void setMissDistance(double missDistance){
        this.missDistance = missDistance;
    }

    /**
     * @return
     * the planet or orbital body which the NEO orbits
     */
    public String getOrbitingBody() {
        return orbitingBody;
    }

    /**
     * @param orbitingBody
     * the orbital body which the NEO orbits
     */
    public void setOrbitingBody(String orbitingBody) {
        this.orbitingBody = orbitingBody;
    }
}
