/**This is the Comparator class that sorts the Near Earth Objects based on their miss distance.
 * @author sharanyakataru
 * email: sharanya.kataru@stonybrook.edu
 * SBU ID: 114850472
 * Recitation: R02
 */
import java.util.Comparator;
public class MissDistanceComparator implements Comparator<NearEarthObject> {
    public int compare(NearEarthObject left, NearEarthObject right){
        return Double.compare(left.getMissDistance(), right.getMissDistance());
    }
}
