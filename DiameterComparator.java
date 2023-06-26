/**This is the Comparator class that sorts the Near Earth objects based on their diameter.
 * @author sharanyakataru
 * email: sharanya.kataru@stonybrook.edu
 * SBU ID: 114850472
 * Recitation: R02
 */
import java.util.Comparator;
public class DiameterComparator implements Comparator<NearEarthObject> {
    public int compare (NearEarthObject left, NearEarthObject right){
        return Double.compare(left.getAverageDiameter(), right.getAverageDiameter());
    }
}